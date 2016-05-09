package com.example.houjie.studyapk.studyanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;

import com.example.houjie.studyapk.R;

public class ActivityAnimator extends AppCompatActivity implements View.OnClickListener{
    private ImageView aniamtionAnimatorImageView;
    private Button aniamtionAnimatorBtn1;
    private Button aniamtionAnimatorBtn2;
    private Button aniamtionAnimatorBtn3;
    private Button aniamtionAnimatorBtn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_animator);
        init();
    }

    private void init() {
        aniamtionAnimatorImageView = (ImageView) findViewById(R.id.aniamtionAnimatorImageView);
        aniamtionAnimatorBtn1 = (Button) findViewById(R.id.aniamtionAnimatorBtn1);
        aniamtionAnimatorBtn1.setOnClickListener(this);
        aniamtionAnimatorBtn2 = (Button) findViewById(R.id.aniamtionAnimatorBtn2);
        aniamtionAnimatorBtn2.setOnClickListener(this);
        aniamtionAnimatorBtn3 = (Button) findViewById(R.id.aniamtionAnimatorBtn3);
        aniamtionAnimatorBtn3.setOnClickListener(this);
        aniamtionAnimatorBtn4 = (Button) findViewById(R.id.aniamtionAnimatorBtn4);
        aniamtionAnimatorBtn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.aniamtionAnimatorBtn1:objAnimator();break;
            case R.id.aniamtionAnimatorBtn2:propertyVile();break;
            case R.id.aniamtionAnimatorBtn3:setAnimation();break;
            case R.id.aniamtionAnimatorBtn4:animatorListView();break;
        }
    }

    private void animatorListView() {
        Intent intent = new Intent(this,ActivityAnimatorListView.class);
        startActivity(intent);
    }

    private void setAnimation() {
        ObjectAnimator objAnimation = new ObjectAnimator().ofFloat(aniamtionAnimatorImageView,
                "rotationX",0,360);
        ObjectAnimator objAnimation1 = new ObjectAnimator().ofFloat(aniamtionAnimatorImageView,
                "translationX",0,360);
        ObjectAnimator objAnimation2 = new ObjectAnimator().ofFloat(aniamtionAnimatorImageView,
                "alpha",1.0f,0,1.0f);
        ObjectAnimator objAnimation3 = new ObjectAnimator().ofFloat(aniamtionAnimatorImageView,
                "scaleX",1.0f,0,1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        //设置动画一起执行
        //animatorSet.playTogether(objAnimation,objAnimation1,objAnimation2,objAnimation3);
        //设置动画顺序执行，顺序为 2 0 1 3
        animatorSet.play(objAnimation3).after(objAnimation1).after(objAnimation).after(objAnimation2);
        animatorSet.setDuration(4000);
        animatorSet.start();
    }
    /**
     * 位移动画  TranslateAnimation
     旋转动画  RotateAnimation
     缩放动画  ScaleAnimation
     淡入淡出动画 AlphaAnimation
     */
    private void propertyVile() {
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX",1.0f,0f,1.0f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY",1.0f,0f,1.0f);
        PropertyValuesHolder rotationX = PropertyValuesHolder.ofFloat("rotationX",0,360);
        ObjectAnimator animator = new ObjectAnimator().ofPropertyValuesHolder(aniamtionAnimatorImageView
        ,scaleX,scaleY,rotationX).setDuration(4000);
        animator.start();

    }

    private void objAnimator() {
        ObjectAnimator animator = new ObjectAnimator().ofFloat(aniamtionAnimatorImageView,"rotationX",0.0f,360.0f);
        animator.setDuration(3000);
        animator.start();
    }

}
