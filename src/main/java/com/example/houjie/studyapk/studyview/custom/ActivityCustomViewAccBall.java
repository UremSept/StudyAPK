package com.example.houjie.studyapk.studyview.custom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;

/**
 * 仿360加速球显示的activity
 */
public class ActivityCustomViewAccBall extends AppCompatActivity {
    private Button btnCustomAccBall;
    private CustomViewAccBall viewAccBall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_custom_view_acc_ball);
        viewAccBall = (CustomViewAccBall) findViewById(R.id.viewAccBall);
        btnCustomAccBall = (Button) findViewById(R.id.btnCustomAccBall);
        btnCustomAccBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewAccBall.sendMassage();
            }
        });
    }
}
