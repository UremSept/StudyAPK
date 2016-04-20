package com.example.houjie.studyapk.studyreceiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by houjie on 2016/4/17.
 */
public class ReceiverTestStaticTwo extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("ReceiverTestStaticOne","------------广播接收到");
    }
}
