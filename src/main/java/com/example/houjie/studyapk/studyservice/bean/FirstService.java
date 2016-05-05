package com.example.houjie.studyapk.studyservice.bean;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 简单的service
 */
public class FirstService extends Service{
    private static final String TAG = "FirstService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"正在运行的方法---------"+Thread.currentThread().getStackTrace()[2].getMethodName());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"正在运行的方法---------"+Thread.currentThread().getStackTrace()[2].getMethodName());

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"正在运行的方法---------"+Thread.currentThread().getStackTrace()[2].getMethodName());
        return super.onStartCommand(intent, flags, startId);
    }
}
