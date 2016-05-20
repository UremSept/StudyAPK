package com.example.houjie.studyapk.studyview.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by hj on 2016/5/20.
 */
public class CustomButton extends Button {
    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    //View中包含dispatchEvent和onTouchEvent两个方法
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:Log.i("点击事件","Button" + "----ACTION_DOWN------dispatchTouchEvent");;break;
            case MotionEvent.ACTION_UP:Log.i("点击事件","Button" + "----ACTION_UP------dispatchTouchEvent");break;
            case MotionEvent.ACTION_MOVE:Log.i("点击事件","Button" + "----ACTION_MOVE------dispatchTouchEvent");break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:Log.i("点击事件","Button" + "------ACTION_DOWN----onTouchEvent");break;
            case MotionEvent.ACTION_UP:Log.i("点击事件","Button" + "-----ACTION_UP-----onTouchEvent");break;
            case MotionEvent.ACTION_MOVE:Log.i("点击事件","Button" + "-----ACTION_MOVE-----onTouchEvent");break;
        }
        return super.onTouchEvent(event);
    }
}
