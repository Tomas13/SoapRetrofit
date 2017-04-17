package kazpost.kz.soapretrofit;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by root on 4/17/17.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

    }
}
