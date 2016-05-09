package com.example.houjie.studyapk.studyanimation;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyanimation.bean.AnimPadType;
//动画效果
public class ActivityAnimation extends AppCompatActivity implements View.OnClickListener {
    private Button LayoutAnimationBtn;
    private Button buttonFBF;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button aniamtionbtnAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_animation);
        init();

    }

    private void init() {
        aniamtionbtnAnimator = (Button) findViewById(R.id.aniamtionbtnAnimator);
        aniamtionbtnAnimator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAnimation.this,ActivityAnimator.class);
                startActivity(intent);
            }
        });
        LayoutAnimationBtn = (Button) findViewById(R.id.LayoutAnimationBtn);
        LayoutAnimationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAnimation.this,ActivityAnimationLayout.class);
                startActivity(intent);
            }
        });
        buttonFBF = (Button) findViewById(R.id.aniamtionbtnFBF1);
        buttonFBF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAnimation.this,ActivityFBF.class);
                startActivity(intent);
            }
        });

        button1 = (Button) findViewById(R.id.aniamtionbtn1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.aniamtionbtn2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.aniamtionbtn3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.aniamtionbtn4);
        button4.setOnClickListener(this);
        button5 = (Button) findViewById(R.id.aniamtionbtn5);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,ActivityAnimationPadding.class);
        switch (v.getId()){
            case R.id.aniamtionbtn1:intent.putExtra("type", AnimPadType.Translate);break;
            case R.id.aniamtionbtn2:intent.putExtra("type", AnimPadType.Rotate);break;
            case R.id.aniamtionbtn3:intent.putExtra("type", AnimPadType.Scale);break;
            case R.id.aniamtionbtn4:intent.putExtra("type", AnimPadType.Alpha);break;
            case R.id.aniamtionbtn5:intent.putExtra("type", AnimPadType.GroupAnim);break;
        }
        startActivity(intent);
    }
}



















