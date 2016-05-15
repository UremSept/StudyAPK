package com.example.houjie.studyapk.studymedia.music;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import com.example.houjie.studyapk.R;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class ActivityMediaInternetMusic extends AppCompatActivity implements MediaPlayer.OnPreparedListener
,MediaPlayer.OnBufferingUpdateListener{
    private SeekBar mSeekBar;
    private Button mPaly;
    private Button mFinsh;
    private MediaPlayer mediaPlayer;
    private boolean aBoolean =false;
    private boolean onPrepared = false;
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_internet_music);
        mFinsh = (Button) findViewById(R.id.mediaInternetMusicBtn2);
        mFinsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mPaly = (Button) this.findViewById(R.id.mediaInternetMusicBtn1);
        mPaly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlayer!=null){
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.pause();
                        mPaly.setText("暂停");
                    }else {
                        mPaly.setText("播放");
                        if(onPrepared){
                            mediaPlayer.start();

                        }else {
                            try {
                                mediaPlayer.setDataSource("http://abv.cn/music/光辉岁月.mp3");
                                mediaPlayer.prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
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

            }
        });
        mSeekBar = (SeekBar) findViewById(R.id.mediaInternetMusicSeekBar);
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
                if(onPrepared){
                    mediaPlayer.seekTo(mSeekBar.getProgress());
                }
                aBoolean =false;
            }
        });
        mediaPlayer = new MediaPlayer();
        //设置流的类型，可以省略
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        mediaPlayer.setOnBufferingUpdateListener(this);
        mediaPlayer.setOnPreparedListener(this);
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        onPrepared =true;
        mediaPlayer.start();
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        //设置缓存进度，此处传入的进度是按百分比，所以需要计算一下
        mSeekBar.setSecondaryProgress(mediaPlayer.getDuration()/100*percent);
        Log.e("音乐缓存进度","-------------------------"+percent);
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
