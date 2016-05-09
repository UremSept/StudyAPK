package com.example.houjie.studyapk.studyhttp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyhttp.activity.ActivityHttpOk;
import com.example.houjie.studyapk.studyhttp.activity.ActivityHttpSeeNews;
import com.example.houjie.studyapk.studyhttp.activity.ActivityVolley;

public class ActivityStudyHttp extends AppCompatActivity {
    private Button btnStudyHttpSeeNews;
    private Button btnStudyHttpVolley;
    private Button btnStudyHttpOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_http);
        init();
    }

    private void init() {
        btnStudyHttpSeeNews = (Button) findViewById(R.id.btnStudyHttpSeeNews);
        btnStudyHttpSeeNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStudyHttp.this, ActivityHttpSeeNews.class);
                startActivity(intent);
            }
        });
        btnStudyHttpVolley = (Button) findViewById(R.id.btnStudyHttpVolley);
        btnStudyHttpVolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStudyHttp.this, ActivityVolley.class);
                startActivity(intent);
            }
        });
        btnStudyHttpOk = (Button) findViewById(R.id.btnStudyHttpOk);
        btnStudyHttpOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStudyHttp.this, ActivityHttpOk.class);
                startActivity(intent);
            }
        });
    }
}
