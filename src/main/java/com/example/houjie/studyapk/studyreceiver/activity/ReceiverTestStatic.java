package com.example.houjie.studyapk.studyreceiver.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyreceiver.receiver.TestReceiverStatic;

public class ReceiverTestStatic extends AppCompatActivity {
    private  Button button1;
    private EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_test_first);
        button1 = (Button) findViewById(R.id.mReceiverTestFirstButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText1.getText().toString();
                Intent intent = new Intent(ReceiverTestStatic.this, TestReceiverStatic.class);
                intent.setAction("My_Receiver");
                intent.putExtra("message",str);
                sendBroadcast(intent);
            }
        });
        editText1 = (EditText) findViewById(R.id.mReceiverTestFirstEditText);

    }
}
