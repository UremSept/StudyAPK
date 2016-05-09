package com.example.houjie.studyapk.studyanimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.houjie.studyapk.R;
//逐帧动画frame by frame
public class ActivityFBF extends AppCompatActivity {
    private ImageView imageView;
    private ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_fbf);
        imageView = (ImageView) findViewById(R.id.aniamtionimageview1);
        imageView2 = (ImageView) findViewById(R.id.aniamtionimageview2);
        imageView2.setBackgroundResource(R.drawable.animation);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView2.getBackground();
        animationDrawable.start();
    }
}
