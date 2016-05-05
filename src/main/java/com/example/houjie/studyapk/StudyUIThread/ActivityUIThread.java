package com.example.houjie.studyapk.studyuithread;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.houjie.studyapk.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityUIThread extends AppCompatActivity {
    private Button button1, button2,button3,button4,button5;
    private TextView textView1, textView2;
    private TestThread testThread;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_uithread);
        button1 = (Button) findViewById(R.id.BtnUIThread1);
        textView1 = (TextView) findViewById(R.id.textUIThread1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd,hh-mm-ss");
                            String time = format.format(new Date());
                            Message msg = new Message();
                            msg.obj = time;
                            MyHandle.sendMessage(msg);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
                button1.setClickable(false);
            }
        });



        button2 = (Button) findViewById(R.id.BtnUIThread2);
        textView2 = (TextView) findViewById(R.id.textUIThread2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread() {
                    @Override
                    public void run() {
                        Log.d("正在运行的线程-----",Thread.currentThread().getName());
                        while (true){
                            MyHandle.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Log.d("正在运行的线程-----",Thread.currentThread().getName());
                                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd,hh-mm-ss");
                                    String time = format.format(new Date());
                                    textView2.setText(time);
                                }
                            }, 1000);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }

                    }

                }.start();

            }
        });





        testThread = new TestThread();
        testThread.start();
        button3 = (Button) findViewById(R.id.BtnUIThread3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message =testThread.getHandler().obtainMessage();
                message.arg1 = 566;
                testThread.getHandler().sendMessage(message);
            }
        });



        progressBar = (ProgressBar) findViewById(R.id.ProgressBarUIThread1);
        button4 = (Button) findViewById(R.id.BtnUIThread4);
        //测试通过AsyncTask的方法实现子线程中对UI的更新
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressUIThread progressUIThread = new ProgressUIThread(button4,progressBar);
                progressUIThread.execute();
                button4.setClickable(false);
            }
        });

        button5 = (Button) findViewById(R.id.BtnUIThread5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ActivityUIThread.this,TestSwipeRefreshLayout.class);
                startActivity(intent1);
            }
        });


    }

    private Handler MyHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String tiem = (String) msg.obj;
            textView1.setText(tiem);
        }
    };

    //测试主线程给子线程发送消息
    class TestThread extends Thread{
        private Handler handler=null;
        public Handler getHandler(){
            return handler;
        }
        @Override
        public void run() {
            Looper.prepare();
            handler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    Log.i("主线程发送来一条消息",msg.arg1+"");
                }
            };
            Looper.loop();
        }
    }



}
