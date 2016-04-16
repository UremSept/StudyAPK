package com.example.houjie.studyapk.studyservice.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyservice.bean.FirstService;
import com.example.houjie.studyapk.studyservice.bean.TestBindService;

import junit.framework.Test;

import java.io.Serializable;

public class TestServiceOne extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private TestBindService testBindService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test_service_one);
        button1 = (Button) findViewById(R.id.btnTestOneStartService);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestServiceOne.this, FirstService.class);
                startService(intent);
            }
        });
        button2 = (Button) findViewById(R.id.btnTestOneStopService);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestServiceOne.this, FirstService.class);
                stopService(intent);
            }
        });
        button3 = (Button) findViewById(R.id.btnTestTwoPageService);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestServiceOne.this, TestServiceTwo.class);
                startActivity(intent);
            }
        });

        button4 = (Button) findViewById(R.id.btnTestBindService);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestServiceOne.this, TestBindService.class);
                bindService(intent,sc,BIND_AUTO_CREATE);

            }
        });
        button5 = (Button) findViewById(R.id.btnTestUnBindService);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sc!=null){
                    unbindService(sc);
                }

            }
        });
    }

    public ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("TestServiceOne","连接成功");
            if(service instanceof TestBindService.MyServiceBinder){
                //testBindService = new TestBindService();
                testBindService = (TestBindService) ((TestBindService.MyServiceBinder) service).getService();
                Log.i("TestServiceOne",testBindService.getNum()+"");
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("TestServiceOne","断开连接");
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(testBindService!=null){
            testBindService.unbindService(sc);
        }

    }
}
