package com.example.houjie.studyapk.studyreceiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by houjie on 2016/4/17.
 */
public class TestReceiverStatic extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String str = intent.getStringExtra("message");
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
    }
}
