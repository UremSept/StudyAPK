package com.example.houjie.studyapk.studyservice.bean;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.houjie.studyapk.MainActivity;

/**
 * Created by houjie on 2016/4/17.
 */
public class TestServiceReceiver extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
//用来测试让广播来开启服务，并且弹出对话框
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(),"ddddd",Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setTitle("强制下线通知");
        builder.setMessage("异地登陆");
        builder.setNegativeButton("重新登陆",null);
        Dialog dialog = builder.create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        dialog.show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
