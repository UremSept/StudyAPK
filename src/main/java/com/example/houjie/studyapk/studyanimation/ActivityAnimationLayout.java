package com.example.houjie.studyapk.studyanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.example.houjie.studyapk.R;

public class ActivityAnimationLayout extends AppCompatActivity {
    private CheckBox aniamtionLayoutCheckBox1;
    private CheckBox aniamtionLayoutCheckBox2;
    private CheckBox aniamtionLayoutCheckBox3;
    private CheckBox aniamtionLayoutCheckBox4;
    private GridLayout aniamtionLayoutGridLayout;
    private Button aniamtionLayoutButton ;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_layout);
        init();
    }

    private void init() {
        aniamtionLayoutCheckBox1 = (CheckBox) findViewById(R.id.aniamtionLayoutCheckBox1);
        aniamtionLayoutCheckBox2 = (CheckBox) findViewById(R.id.aniamtionLayoutCheckBox2);
        aniamtionLayoutCheckBox3 = (CheckBox) findViewById(R.id.aniamtionLayoutCheckBox3);
        aniamtionLayoutCheckBox4 = (CheckBox) findViewById(R.id.aniamtionLayoutCheckBox4);
        aniamtionLayoutGridLayout = (GridLayout) findViewById(R.id.aniamtionLayoutGridLayout);

//        LayoutTransition layoutTransition = new LayoutTransition();
//        ObjectAnimator animator = new ObjectAnimator().ofFloat(this,"scaleX",0,1);
//        layoutTransition.setAnimator(LayoutTransition.APPEARING,animator);
//        aniamtionLayoutGridLayout.setLayoutTransition(layoutTransition);
//
//        LayoutTransition layoutTransition1 = new LayoutTransition();
//        ObjectAnimator disappear = new ObjectAnimator().ofFloat(this,"scaleX",1,0);
//        layoutTransition1.setAnimator(LayoutTransition.DISAPPEARING,disappear);
//        aniamtionLayoutGridLayout.setLayoutTransition(layoutTransition1);

        aniamtionLayoutButton = (Button) findViewById(R.id.aniamtionLayoutButton);
        aniamtionLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addViewToGrid();
            }
        });
    }

    private void addViewToGrid(){
        count++;
        Button button =new Button(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aniamtionLayoutGridLayout.setLayoutTransition(getLayoutTransition());
                aniamtionLayoutGridLayout.removeView(v);

            }
        });
        button.setText("测试"+count);
        aniamtionLayoutGridLayout.setLayoutTransition(getLayoutTransition());
        aniamtionLayoutGridLayout.addView(button,1);

    }

    /**
     * 用于ViewGroup出现变化时使用
     主要包含四种
     APPEARING ViewGroup中出现新的View时，新View的动画
     DISAPPEARING  ViewGroup中有View消失时，消失的View的动画
     CHANGE_APPEARING ViewGroup中出现新的View，已存在的Views的动画
     CHANGE_DISAPPEARING ViewGroup中有View消失时，尚存在的Views的动画
     * @return
     */
    private LayoutTransition getLayoutTransition(){
        LayoutTransition layoutTransition = new LayoutTransition();
        ObjectAnimator animator = new ObjectAnimator().ofFloat(this,"scaleX",0,1);
        ObjectAnimator disappear = new ObjectAnimator().ofFloat(this,"scaleX",1,0);
        if(aniamtionLayoutCheckBox1.isChecked()){
            layoutTransition.setAnimator(LayoutTransition.APPEARING,animator);
        }
         if (aniamtionLayoutCheckBox2.isChecked()){
             layoutTransition.setAnimator(LayoutTransition.DISAPPEARING,disappear);
         }
        if(aniamtionLayoutCheckBox3.isChecked()){
            PropertyValuesHolder holderX =PropertyValuesHolder.ofFloat("scaleX",1,0,1);
            PropertyValuesHolder holderY = PropertyValuesHolder.ofFloat("scaleY",1,0,1);
            PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofFloat("left",0,1);
            PropertyValuesHolder phvTop = PropertyValuesHolder.ofFloat("top",0,1);
            PropertyValuesHolder phvRight = PropertyValuesHolder.ofFloat("right",0,1);
            PropertyValuesHolder phvButtom = PropertyValuesHolder.ofFloat("bottom",0,1);
           ObjectAnimator change = new ObjectAnimator().ofPropertyValuesHolder(this,
                   pvhLeft,phvTop,phvRight,phvButtom,holderX,holderY);
            change.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    View view = (View) ((ObjectAnimator)animation).getTarget();
                    view.setScaleX(8);
                    view.setScaleY(8);
                }
            });
           layoutTransition.setDuration(1000);
            layoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING,change);
        }
        if(aniamtionLayoutCheckBox4.isChecked()){
            PropertyValuesHolder holderX =PropertyValuesHolder.ofFloat("scaleX",1,0,1);
            PropertyValuesHolder holderY = PropertyValuesHolder.ofFloat("scaleY",1,0,1);
            PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofFloat("left",0,1);
            PropertyValuesHolder phvTop = PropertyValuesHolder.ofFloat("top",0,1);
            PropertyValuesHolder phvRight = PropertyValuesHolder.ofFloat("right",0,1);
            PropertyValuesHolder phvButtom = PropertyValuesHolder.ofFloat("bottom",0,1);
            ObjectAnimator change = new ObjectAnimator().ofPropertyValuesHolder(this,
                    pvhLeft,phvTop,phvRight,phvButtom,holderX,holderY);
            change.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    View view = (View) ((ObjectAnimator)animation).getTarget();
                    view.setScaleX(1);
                    view.setScaleY(1);
                }
            });
            layoutTransition.setDuration(1000);
            layoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING,change);
        }
        return layoutTransition;
    }
}
