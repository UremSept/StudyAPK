package com.example.houjie.studyapk.studyservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyservice.activity.TestServiceOne;

public class ActivityService extends AppCompatActivity {
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_service);
        init();
    }

    private void init() {
        mButton = (Button) findViewById(R.id.btnTestService);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityService.this, TestServiceOne.class);
                startActivity(intent);
            }
        });
    }
}
