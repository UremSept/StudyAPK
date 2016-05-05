package com.example.houjie.studyapk.practicedownload.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by houjie on 2016/4/17.
 */
public class ServiceDownload extends Service{
    private final String TAG="ServiceDownload";
    private boolean flag =true;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"正在运行的方法---------"+ Thread.currentThread().getStackTrace()[2].getMethodName());

        return null;
    }
    @Override
    public void onCreate() {

        Log.i(TAG,"正在运行的方法---------"+ Thread.currentThread().getStackTrace()[2].getMethodName());
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"正在运行的方法---------"+ Thread.currentThread().getStackTrace()[2].getMethodName());
        flag=false;
        super.onDestroy();
    }

    @Override
    public int onStartCommand(final Intent intent, final int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                    for (int i = 0;i<101&&flag;i++){
                        Intent intent1 = new Intent("download_go");
                        intent1.putExtra("count",i);
                        sendBroadcast(intent1);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

        }).start();

        return super.onStartCommand(intent, flags, startId);
    }
}
