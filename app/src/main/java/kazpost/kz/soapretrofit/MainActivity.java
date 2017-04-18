package kazpost.kz.soapretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        config();
    }

    private void config() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Strategy strategy = new AnnotationStrategy();

        Serializer serializer = new Persister(strategy);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()


                .addNetworkInterceptor(new StethoInterceptor())
//                .addInterceptor(interceptor)
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://172.30.223.25:8088/mobiterminal/Terminal.wsdl/")
                .client(okHttpClient)
                .build();

        Service service = retrofit.create(Service.class);

        RequestEnvelope envelope = new RequestEnvelope();

        AuthRequestBody authRequestBody = new AuthRequestBody();

        AuthRequestData authRequestData = new AuthRequestData();
        authRequestData.setUserBarcode("1000");
        authRequestData.setUserPin("1234");

        authRequestBody.setAuthRequestData(authRequestData);

        envelope.setAuthRequestBody(authRequestBody);

        Call<Envelope> call = service.requestStateInfo(envelope);

        call.enqueue(new Callback<Envelope>() {
            @Override
            public void onResponse(Call<Envelope> call, Response<Envelope> response) {
                Log.d("MainRes", response.body().getBody().getAuthorizeResponse().getResponseInfo().getResponseGenTime()); //.getAuthorizeResponse().getRootBody().getAuthRequestData().getResponseGenTime());


            }

            @Override
            public void onFailure(Call<Envelope> call, Throwable t) {
                Log.d("MainFa", t.getMessage());

            }
        });

        Observable<Envelope> observable = service.requestStateInfoObs(envelope);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        responseEnvelope -> {


                            Log.d("Main", " body " + responseEnvelope.getBody().getAuthorizeResponse().getResponseInfo().getResponseGenTime()); //.getAuthorizeResponse().getRootBody().getAuthRequestData().getResponseCode());


                        },
                        throwable -> {
                            Log.d("Main", " thro " + throwable.getMessage());
                        }
                );
    }
}
