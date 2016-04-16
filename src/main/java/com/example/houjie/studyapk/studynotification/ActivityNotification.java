package com.example.houjie.studyapk.studynotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.example.houjie.studyapk.R;

public class ActivityNotification extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    private  Button button2;
    private Button button3;
    private NotificationManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        setContentView(R.layout.activity_study_notification);
        init();
    }

    private void init() {
        button1 = (Button) findViewById(R.id.NotificationButton1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.NotificationButton2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.NotificationButton3);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.NotificationButton1:
                Notification.Builder builder = new Notification.Builder(this);
                builder.setTicker("张三给你发来一条短信");
                builder.setSmallIcon(R.mipmap.helloword);
                builder.setContentTitle("消息提醒");
                builder.setContentText("你该吃饭了");
                PendingIntent pendingIntent = PendingIntent.getActivity
                        (this,1,new Intent(ActivityNotification.this,ActivityNotification.class),0);
                builder.setContentIntent(pendingIntent);
                manager.notify(1,builder.build());
                break;
            case R.id.NotificationButton2:
                Notification notification = new Notification();
                notification.icon = R.mipmap.helloword;//必须有，虽然不显示。。。
                notification.tickerText="您有一条新消息";
                notification.when = System.currentTimeMillis();
                notification.flags = Notification.FLAG_NO_CLEAR;
                RemoteViews rv = new RemoteViews(getPackageName(),R.layout.layout_notification);
                rv.setTextViewText(R.id.NotificationText1,"天天飞车");
                rv.setTextViewText(R.id.NotificationText2,"清明节活动");
                notification.contentView=rv;
                Intent intent = new Intent(ActivityNotification.this,ActivityNotification.class);
                PendingIntent contentIntent = PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_ONE_SHOT);
                notification.contentIntent=contentIntent;
                manager.notify(2,notification);
                break;
            case R.id.NotificationButton3:
                manager.cancelAll();
                break;
            default:break;
        }
    }
}
