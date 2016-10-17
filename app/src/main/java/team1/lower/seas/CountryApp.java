package team1.lower.seas;

import android.app.Application;
import android.content.Context;

/**
 * Created by winthanhtike on 10/17/16.
 */
public class CountryApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

    }

    public static Context getContext() {
        return context;
    }
}
