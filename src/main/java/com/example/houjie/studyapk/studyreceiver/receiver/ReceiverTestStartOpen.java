package com.example.houjie.studyapk.studyreceiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.houjie.studyapk.MainActivity;

/**
 * Created by houjie on 2016/4/17.
 */
public class ReceiverTestStartOpen extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, MainActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
