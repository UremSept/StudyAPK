package com.example.houjie.studyapk.studyview.custom;

import android.os.Handler;
import android.os.Message;
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
    private int i = 0;
    private  Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(i<=100){
                viewAccBall.setProgress(i);//延时1秒改变加速球进度
                sendEmptyMessageDelayed(1,1000);
                i+=10;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_custom_view_acc_ball);
        viewAccBall = (CustomViewAccBall) findViewById(R.id.viewAccBall);
        btnCustomAccBall = (Button) findViewById(R.id.btnCustomAccBall);
        btnCustomAccBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 0;
                handler.sendEmptyMessageDelayed(1,1000);//开启动画
            }
        });
    }
}
