package com.example.houjie.studyapk.studymedia.video;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;

import java.io.File;
import java.io.IOException;

public class ActivityMediaVideo extends AppCompatActivity implements MediaPlayer.OnPreparedListener {
    private SurfaceView surfaceView;
    private Button button;
    private Button mediaVideoBtn2;
    private String path;
    private MediaPlayer mediaPlay;
    private boolean aBoolean = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medio_video);
        button = (Button) findViewById(R.id.mediaVideoBtn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlay!=null){
                    if(mediaPlay.isPlaying()){
                        mediaPlay.pause();
                        button.setText("暂停");
                    }else{
                        button.setText("播放");
                        if(aBoolean){
                            mediaPlay.start();
                        }else{
                            mediaPlay.setDisplay(surfaceView.getHolder());
                            try {
                                File file = new File(path);
                                if(!file.exists()){
                                    Log.i("文件不存在","-----"+path);
                                }
                                mediaPlay.setDataSource(path);
                                mediaPlay.prepareAsync();
                                mediaPlay.seekTo(0);
                                aBoolean =true;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        });
        mediaVideoBtn2= (Button) findViewById(R.id.mediaVideoBtn2);
        mediaVideoBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMediaVideo.this,ActivityMediaInternetVideo.class);
                startActivity(intent);
            }
        });
        surfaceView = (SurfaceView) findViewById(R.id.mediaVideoSurface);
        path = Environment.getExternalStorageDirectory().getPath()+"/qqmusic/mv/"+"陈冰-盛夏光年.mp4";
        //path = Environment.getExternalStorageDirectory().getPath()+"/Movies/"+"111.mp4";
        surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceView.setKeepScreenOn(true);//设置屏幕常亮

        mediaPlay = new MediaPlayer();
        //mediaPlay.setAudioStreamType(AudioManager.ST);
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
