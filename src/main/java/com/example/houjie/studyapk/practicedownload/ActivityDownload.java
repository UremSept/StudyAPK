package com.example.houjie.studyapk.practicedownload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.practicedownload.service.ServiceDownload;

public class ActivityDownload extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private SeekBar seekBar;
    private ServiceDownload serviceDownload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_music);

        IntentFilter intentFilter = new IntentFilter();
        ReceiverDownload receiverDownload = new ReceiverDownload();
        intentFilter.addAction("download_go");
        registerReceiver(receiverDownload,intentFilter);

        button1 = (Button) findViewById(R.id.startDownload);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDownload.this, ServiceDownload.class);
                startService(intent);
            }
        });
        button2 = (Button) findViewById(R.id.stopDownload);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityDownload.this,ServiceDownload.class);
                stopService(i);
            }
        });
        seekBar = (SeekBar) findViewById(R.id.seekBarDownload);

    }

    public class ReceiverDownload extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(ActivityDownload.this,"dddd",Toast.LENGTH_SHORT).show();
            int count = intent.getIntExtra("count",0);
            seekBar.setProgress(count);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent i = new Intent(ActivityDownload.this,ServiceDownload.class);
        stopService(i);
    }
}
