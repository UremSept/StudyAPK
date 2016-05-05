package com.example.houjie.studyapk.studyuithread;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.houjie.studyapk.R;
//下拉刷新
public class TestSwipeRefreshLayout extends AppCompatActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView textView;
    private Handler testHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uithread_swipe_refresh_layout);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.testSwipeRefreshLayout);
        textView  = (TextView) findViewById(R.id.textSwipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorBlack,R.color.colorAccent,
                R.color.colorBule,R.color.colorYellow,R.color.colorGreen);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(){
                    @Override
                    public void run() {
                        testHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText("刷新完成");
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        },8000);
                    }
                }.start();
            }
        });
    }

}
