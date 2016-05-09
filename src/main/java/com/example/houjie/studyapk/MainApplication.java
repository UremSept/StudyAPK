package com.example.houjie.studyapk;

import android.app.Application;

import org.xutils.x;


/**
 * Created by houjie on 2016/5/6.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
