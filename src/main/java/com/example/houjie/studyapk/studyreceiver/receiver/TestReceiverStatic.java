package com.example.houjie.studyapk.studyreceiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.houjie.studyapk.studyservice.bean.TestServiceReceiver;

/**
 * Created by houjie on 2016/4/17.
 */
public class TestReceiverStatic extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String str = intent.getStringExtra("message");
        Intent intent1 = new Intent(context,TestServiceReceiver.class);
        context.startService(intent);
        Log.i("TestReceiverStatic","------------广播接收到");
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
    }
}
