package kazpost.kz.soapretrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by root on 4/17/17.
 */

public interface Service {
    @Headers({
            "Content-Type: text/xml",
            "Accept-Charset: utf-8"
    })
    @POST("/mobiterminal/Terminal.wsdl")
    Call<RequestEnvelope> requestStateInfo(@Body RequestEnvelope requestEnvelope);

    @POST("/mobiterminal/Terminal.wsdl")
    @Headers("Content-Type: text/xml")
    Observable<RequestEnvelope> requestStateInfoObs(@Body RequestEnvelope requestEnvelope);

}
