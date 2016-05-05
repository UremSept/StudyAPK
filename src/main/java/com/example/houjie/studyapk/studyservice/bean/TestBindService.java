package com.example.houjie.studyapk.studyservice.bean;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * BindService 随着Activity的生命结束而结束
 */
public class TestBindService extends Service{
    private static final String TAG="TestBindService";
    @Override
    public void onCreate() {
        Log.i(TAG,"正在运行的方法---------"+ Thread.currentThread().getStackTrace()[2].getMethodName());
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"正在运行的方法---------"+ Thread.currentThread().getStackTrace()[2].getMethodName());
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG,"正在运行的方法---------"+ Thread.currentThread().getStackTrace()[2].getMethodName());
        return super.onUnbind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"正在运行的方法---------"+ Thread.currentThread().getStackTrace()[2].getMethodName());
        return new MyServiceBinder();


    }

    public class MyServiceBinder extends Binder{
        public Service getService(){
            return TestBindService.this;
        }
        public int getNum1() {
            Log.i("getNum", this.getClass().toString());
            return 0;
        }
    }

    public int getNum() {
        Log.i("getNum", this.getClass().toString());
        return 0;
    }
}
