package com.example.houjie.studyapk.studymedia.video;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.houjie.studyapk.R;

import java.io.File;
import java.io.IOException;

public class ActivityMediaInternetVideo extends AppCompatActivity implements MediaPlayer.OnPreparedListener{
    private String path = "http://172.6.1.73:8080/AndroidWebServer/video1.mp4";
    private EditText mediaInternetVideoEdit;
    private SurfaceView surfaceView;
    private Button button;
    private MediaPlayer mediaPlay;
    private boolean aBoolean = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_internet_video);
        mediaInternetVideoEdit = (EditText) findViewById(R.id.mediaInternetVideoEdit);



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
    }
    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaPlay.start();
    }

    @Override
    protected void onDestroy() {
        mediaPlay.release();
        super.onDestroy();
    }
}
