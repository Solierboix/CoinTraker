package com.example.walczpio.cointraker;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;

public class MyApplication extends Application {

    private static Context context;
    @Override
    public void onCreate() {
        MyApplication.
        super.onCreate();
        MyApplication.context = getApplicationContext();
        Realm.init(this);
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}
