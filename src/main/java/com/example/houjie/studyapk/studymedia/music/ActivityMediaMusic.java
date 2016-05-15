package com.example.houjie.studyapk.studymedia.music;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.example.houjie.studyapk.R;

import java.util.Timer;
import java.util.TimerTask;

public class ActivityMediaMusic extends AppCompatActivity {
    private SeekBar mSeekBar;
    private Button mPaly;
    private Button mFinsh;
    private Button mInternetMusic;
    private MediaPlayer mediaPlayer;
    private boolean aBoolean =false;
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_music);
//第一种实例化方式
//        mediaPlayer = new MediaPlayer();
//        mediaPlayer.setDataSource();
        mediaPlayer = MediaPlayer.create(this,R.raw.cldyg);
        mSeekBar = (SeekBar) findViewById(R.id.mediaMusicSeekBar);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                aBoolean = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(mSeekBar.getProgress());
                aBoolean =false;
            }
        });
        mInternetMusic = (Button) findViewById(R.id.mediaMusicBtn3);
        mInternetMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMediaMusic.this,ActivityMediaInternetMusic.class);
                startActivity(intent);
            }
        });
        mPaly = (Button) findViewById(R.id.mediaMusicBtn1);
        mPaly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSeekBar.setMax(mediaPlayer.getDuration());
                timer = new Timer();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        if(aBoolean){
                            return;
                        }
                        mSeekBar.setProgress(mediaPlayer.getCurrentPosition());
                    }
                };
                timer.schedule(timerTask,0,1000);
                if(mediaPlayer!=null){
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.pause();
//                        timer.cancel();
                        mPaly.setText("暂停");
                        aBoolean =true;
                    }else{
                        mediaPlayer.start();
                        aBoolean =false;
                        mPaly.setText("播放");
                    }
                }
            }
        });
        mFinsh = (Button) findViewById(R.id.mediaMusicBtn2);
        mFinsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.release();
        if(timer!=null){
            timer.cancel();
        }
        super.onDestroy();
    }
}
