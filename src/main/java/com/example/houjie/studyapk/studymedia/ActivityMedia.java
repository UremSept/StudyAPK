package com.example.houjie.studyapk.studymedia;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studymedia.canvas.ActivityMediaCanvas;
import com.example.houjie.studyapk.studymedia.canvas.ActivityMediaCanvasZigzag;
import com.example.houjie.studyapk.studymedia.canvas.ActivityMediaCatPicture;
import com.example.houjie.studyapk.studymedia.canvas.ActivityMediaChangeColor;
import com.example.houjie.studyapk.studymedia.canvas.ActivityMediaXfermode;
import com.example.houjie.studyapk.studymedia.mipmap.ActivityMediaMatrix;
import com.example.houjie.studyapk.studymedia.mipmap.ActivityMediaMipmap;
import com.example.houjie.studyapk.studymedia.music.ActivityMediaMusic;
import com.example.houjie.studyapk.studymedia.record.ActivityMediaRecord;
import com.example.houjie.studyapk.studymedia.video.ActivityMediaVideo;

public class ActivityMedia extends AppCompatActivity {
    private Button MeidaMipmapBtn;
    private Button MeidaCanvasBtn;
    private Button MediaCanvasZigzagBtn;
    private Button MediaXfermode;
    private Button mediaCatPicture;
    private Button mediaChangeColer;
    private Button mediaMatrix;
    private Button mediaMusic;
    private Button mediaVideo;
    private Button mediaRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_media);
        MeidaMipmapBtn  = (Button) findViewById(R.id.MeidaMipmapBtn);
        MeidaMipmapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(ActivityMedia.this,ActivityMediaMipmap.class));
                startActivity(intent);
            }
        });
        MeidaCanvasBtn  = (Button) findViewById(R.id.MeidaCanvasBtn);
        MeidaCanvasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(ActivityMedia.this,ActivityMediaCanvas.class));
                startActivity(intent);
            }
        });
        MediaCanvasZigzagBtn  = (Button) findViewById(R.id.MediaCanvasZigzagBtn);
        MediaCanvasZigzagBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(ActivityMedia.this,ActivityMediaCanvasZigzag.class));
                startActivity(intent);
            }
        });
        MediaXfermode = (Button) findViewById(R.id.MediaXfermode);
        MediaXfermode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(ActivityMedia.this,ActivityMediaXfermode.class));
                startActivity(intent);
            }
        });
        mediaCatPicture = (Button) findViewById(R.id.mediaCatPicture);
        mediaCatPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(ActivityMedia.this,ActivityMediaCatPicture.class));
                startActivity(intent);
            }
        });
        mediaChangeColer = (Button) findViewById(R.id.mediaChangeColer);
        mediaChangeColer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(ActivityMedia.this,ActivityMediaChangeColor.class));
                startActivity(intent);
            }
        });
        mediaMatrix = (Button) findViewById(R.id.mediaMatrix);
        mediaMatrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(ActivityMedia.this,ActivityMediaMatrix.class));
                startActivity(intent);
            }
        });
        mediaMusic = (Button) findViewById(R.id.mediaMusic);
        mediaMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(ActivityMedia.this,ActivityMediaMusic.class));
                startActivity(intent);
            }
        });
        mediaVideo = (Button) findViewById(R.id.mediaVideo);
        mediaVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(ActivityMedia.this,ActivityMediaVideo.class));
                startActivity(intent);
            }
        });
        mediaRecord = (Button) findViewById(R.id.mediaRecord);
        mediaRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(ActivityMedia.this,ActivityMediaRecord.class));
                startActivity(intent);
            }
        });

    }
}
