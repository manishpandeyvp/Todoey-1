package com.example.todoey;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.todoey.utils.Constants;

public class MyApplication extends Application {

    private static Context mContext;
    private static SharedPreferences sharedPref;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getBaseContext();
        sharedPref = getSharedPreferences(Constants.SHARED_PREF, Context.MODE_PRIVATE);
    }

    public static Context getContext() {
        return mContext;
    }

    public static SharedPreferences getSharedPrefs() {
        return sharedPref;
    }
}
