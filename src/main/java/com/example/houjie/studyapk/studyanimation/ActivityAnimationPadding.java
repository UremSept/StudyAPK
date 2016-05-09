package com.example.houjie.studyapk.studyanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyanimation.bean.AnimPadType;


public class ActivityAnimationPadding extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_only_imageview);
        imageView = (ImageView) findViewById(R.id.OnlyImageView);
        String str = getIntent().getStringExtra("type");
        Animation animation = null;
        switch (str){
            case AnimPadType.Translate:
                animation = AnimationUtils.loadAnimation(this,R.anim.translateanimation);
                break;
            case AnimPadType.Rotate:
                animation = AnimationUtils.loadAnimation(this,R.anim.rotateanimation);
                break;
            case AnimPadType.Scale:
                animation = AnimationUtils.loadAnimation(this,R.anim.scaleanimation);
                break;
            case AnimPadType.Alpha:
                animation = AnimationUtils.loadAnimation(this,R.anim.alphaanimation);
                break;
            case AnimPadType.GroupAnim:
                animation = AnimationUtils.loadAnimation(this,R.anim.groupanimation);
                break;

        }
        imageView.setBackgroundResource(R.mipmap.ic_launcher);
        imageView.setAnimation(animation);
    }
}
