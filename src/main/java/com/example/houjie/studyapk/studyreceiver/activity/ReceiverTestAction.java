package com.example.houjie.studyapk.studyreceiver.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.houjie.studyapk.R;
//测试动态注册广播
public class ReceiverTestAction extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private TextView textView;
    private TestReciverAction testReciverAction;
    public static final String MESSAGE= "thisisabroadcastreceiver";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_test_action);
        button = (Button) findViewById(R.id.mReceiverTestActionButton);
        editText = (EditText) findViewById(R.id.mReceiverTestActionEditText);
        textView = (TextView) findViewById(R.id.mReceiverTestActionTextView);
        testReciverAction = new TestReciverAction();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MESSAGE);
        registerReceiver(testReciverAction,intentFilter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                Intent intent = new Intent();
                intent.setAction(MESSAGE);
                intent.putExtra("message",str);
                sendBroadcast(intent);
                Intent intent1 = new Intent("My_Receiver");
                intent1.putExtra("message",str+"two");
                sendBroadcast(intent1);

            }
        });
    }
    public class TestReciverAction extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String str  =intent.getStringExtra("message");
            textView.setText(str);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(testReciverAction);
    }
}
