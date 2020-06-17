package com.mmy.yiyi.base;

import android.app.Application;
import android.content.Context;

import com.mmy.yiyi.BuildConfig;
import com.mmy.yiyi.crash.CrashHandler;


/*
 * {Nothing is Importance}
 */
public class BaseApplication extends Application {

    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        CrashHandler.getInstance().init(this, BuildConfig.APPLICATION_ID);

    }

    public static Context getContent(){
        return context;
    }

}
