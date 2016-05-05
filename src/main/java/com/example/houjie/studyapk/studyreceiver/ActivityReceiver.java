package com.example.houjie.studyapk.studyreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyreceiver.activity.ReceiverTestAction;
import com.example.houjie.studyapk.studyreceiver.activity.ReceiverTestStatic;

public class ActivityReceiver extends AppCompatActivity {
    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_receiver);
        button1 = (Button) findViewById(R.id.btnReceiverTestStatic);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ActivityReceiver.this, ReceiverTestStatic.class);
                startActivity(intent);
            }
        });
        button2 = (Button) findViewById(R.id.btnReceiverTestAction);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ActivityReceiver.this, ReceiverTestAction.class);
                startActivity(intent);
            }
        });
    }
}
