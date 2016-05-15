package com.example.houjie.studyapk.studymedia.video;


import android.media.MediaPlayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import com.example.houjie.studyapk.R;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class ActivityMediaInternetVideo extends AppCompatActivity implements MediaPlayer.OnPreparedListener
,MediaPlayer.OnBufferingUpdateListener,MediaPlayer.OnVideoSizeChangedListener{
    private String path = "http://172.6.1.73:8080/AndroidWebServer/video1.mp4";
    private EditText mediaInternetVideoEdit;
    private SurfaceView surfaceView;
    private Button button;
    private MediaPlayer mediaPlay;
    private boolean aBoolean = false;
    private SeekBar seekBar;
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_internet_video);
        mediaInternetVideoEdit = (EditText) findViewById(R.id.mediaInternetVideoEdit);

        seekBar = (SeekBar) findViewById(R.id.mediaInternetVideoSeekBar);
        button = (Button) findViewById(R.id.mediaInternetVideoBtn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlay.isPlaying()){
                    mediaPlay.pause();
                    button.setText("暂停");
                }else {
                    button.setText("播放");
                    if (aBoolean) {
                        mediaPlay.start();
                    } else {
                        mediaPlay.setDisplay(surfaceView.getHolder());
                        try {
                            String string =mediaInternetVideoEdit.getText().toString();
                            if(string.endsWith(".mp4")){
                                mediaPlay.setDataSource(string);
                            }else {
                                mediaPlay.setDataSource(path);
                            }
                            mediaPlay.prepareAsync();
                            mediaPlay.seekTo(0);
                            aBoolean =true;
                            seekBar.setMax(100);
                            Log.i("media长度","--------------"+100);
                            timer = new Timer();
                            TimerTask timerTask = new TimerTask() {
                                @Override
                                public void run() {
//                                    if(aBoolean){
//                                        return;
//                                    }
                                    if(mediaPlay.getDuration()==0||mediaPlay.getCurrentPosition()==0){

                                    }else {
                                        seekBar.setProgress((int)(100*(((float)mediaPlay.getCurrentPosition())/mediaPlay.getDuration())));
                                        Log.i("media当前进度","--------------"+100*(((float)mediaPlay.getCurrentPosition())/mediaPlay.getDuration()));
                                    }

                                }
                            };
                            timer.schedule(timerTask,0,1000);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
        surfaceView = (SurfaceView) findViewById(R.id.mediaInternetVideoSurface);
        surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceView.setKeepScreenOn(true);//设置屏幕常亮

        mediaPlay = new MediaPlayer();
        mediaPlay.setOnPreparedListener(this);
        mediaPlay.setOnBufferingUpdateListener(this);
    }
    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaPlay.start();
    }

    @Override
    protected void onDestroy() {
        mediaPlay.release();
        if(timer!=null){
            timer.cancel();
        }
        super.onDestroy();
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        seekBar.setSecondaryProgress(percent);
        Log.e("音乐缓存进度","-------------------------"+percent);
    }

    @Override
    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

    }
}
