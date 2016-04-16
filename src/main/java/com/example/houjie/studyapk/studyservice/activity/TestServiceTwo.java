package com.example.houjie.studyapk.studyservice.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyservice.bean.FirstService;

public class TestServiceTwo extends AppCompatActivity {
    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test_service_two);
        button1 = (Button) findViewById(R.id.btnTestTwoStartService);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestServiceTwo.this, FirstService.class);
                startService(intent);
            }
        });
        button2 = (Button) findViewById(R.id.btnTestTwoStopService);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestServiceTwo.this, FirstService.class);
                stopService(intent);
            }
        });
    }
}
