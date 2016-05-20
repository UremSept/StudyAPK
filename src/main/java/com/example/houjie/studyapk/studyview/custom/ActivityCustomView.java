package com.example.houjie.studyapk.studyview.custom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;

public class ActivityCustomView extends AppCompatActivity {
    private Button btnViewCustomViewGroup,btnViewCustomAccBall,btnViewCustomEnvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        btnViewCustomViewGroup = (Button) findViewById(R.id.btnViewCustomViewGroup);
        btnViewCustomViewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityCustomView.this,ActivityCustomViewGroup.class);
                startActivity(intent);
            }
        });
        btnViewCustomAccBall = (Button) findViewById(R.id.btnViewCustomAccBall);
        btnViewCustomAccBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityCustomView.this,ActivityCustomViewAccBall.class);
                startActivity(intent);
            }
        });
        btnViewCustomEnvent = (Button) findViewById(R.id.btnViewCustomEnvent);
        btnViewCustomEnvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityCustomView.this,ActivityCustomEvent.class);
                startActivity(intent);
            }
        });
    }
}
