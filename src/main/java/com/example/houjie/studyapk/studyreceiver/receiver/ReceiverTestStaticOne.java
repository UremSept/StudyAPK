package com.example.houjie.studyapk.studyreceiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 用来测试多个广播接收
 */
public class ReceiverTestStaticOne extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("ReceiverTestStaticOne","------------广播接收到");
    }
}
