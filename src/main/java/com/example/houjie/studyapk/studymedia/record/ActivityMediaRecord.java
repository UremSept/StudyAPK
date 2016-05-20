package com.example.houjie.studyapk.studymedia.record;

import android.app.Activity;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;

import java.io.IOException;

public class ActivityMediaRecord extends AppCompatActivity implements View.OnClickListener {
    private SurfaceView mediaRecordSufaceView;
    private Button mediaRecordBtn1,mediaRecordBtn2,mediaRecordBtn3,mediaRecordBtn4;
    private MediaRecorder mediaRecorder;
    private String path;
    private Camera camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_record);
        init();
        mediaRecordSufaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                //回调视窗
                camera = Camera.open();//打开相机
                //同
                mediaRecorder = new MediaRecorder();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

                try {
                    camera.setPreviewDisplay(holder);
                    camera.setDisplayOrientation(getDegrre(ActivityMediaRecord.this));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                camera.startPreview();
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
        mediaRecordSufaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mediaRecordSufaceView.setKeepScreenOn(true);

    }

    private void init() {
        path = Environment.getExternalStorageDirectory()+"/录制.3gp";
        mediaRecordSufaceView = (SurfaceView) findViewById(R.id.mediaRecordSufaceView);
        mediaRecordBtn1 = (Button) findViewById(R.id.mediaRecordBtn1);
        mediaRecordBtn1.setOnClickListener(this);
        mediaRecordBtn2 = (Button) findViewById(R.id.mediaRecordBtn2);
        mediaRecordBtn2.setOnClickListener(this);
        mediaRecordBtn3 = (Button) findViewById(R.id.mediaRecordBtn3);
        mediaRecordBtn3.setOnClickListener(this);
        mediaRecordBtn4 = (Button) findViewById(R.id.mediaRecordBtn4);
        mediaRecordBtn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mediaRecordBtn1:
                //
                camera.unlock();
                //录制设置相机
                mediaRecorder.setCamera(camera);
                //设置回调surfaceview
                mediaRecorder.setPreviewDisplay(mediaRecordSufaceView.getHolder().getSurface());
                //设置录音源
                mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                //设置视频源
                mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
                //设置输出类型
                mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                //设置输出路径
                mediaRecorder.setOutputFile(path);
                //设置输出音频编码
                mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                //设置输出视频编码
                mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.DEFAULT);
                try {
                    //准备
                    mediaRecorder.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //开始录制
                mediaRecorder.start();
                break;
            case R.id.mediaRecordBtn2:
                //释放资源
                mediaRecorder.release();
                camera.release();
                mediaRecorder=null;
                break;
            case R.id.mediaRecordBtn3:break;
            case R.id.mediaRecordBtn4:break;
        }
    }
    //得到相机的角度
    private int getDegrre(Activity activity){
        //得到手机当前旋转角度
        int rotating = activity.getWindowManager().getDefaultDisplay().getRotation();
        //改变角度
        int degrre = 0;
        switch (rotating){
            case Surface.ROTATION_0:
                degrre = 90;
                break;
            case Surface.ROTATION_90:
                degrre = 0;
                break;
            case Surface.ROTATION_180:
                degrre = 270;
                break;
            case Surface.ROTATION_270:
                degrre = 180;
                break;
        }
        return degrre;
    }

    @Override
    protected void onDestroy() {
        if(mediaRecorder!=null){
            mediaRecorder.release();
            mediaRecorder=null;
        }
        if(camera!=null){
            camera.release();
        }
        super.onDestroy();
    }
}
