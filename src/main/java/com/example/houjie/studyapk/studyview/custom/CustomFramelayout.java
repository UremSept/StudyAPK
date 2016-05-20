package com.example.houjie.studyapk.studyview.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by hj on 2016/5/20.
 */
public class CustomFramelayout extends FrameLayout {
    public CustomFramelayout(Context context) {
        super(context);
    }

    public CustomFramelayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomFramelayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomFramelayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:Log.i("点击事件","FrameLayout" + "----ACTION_DOWN------dispatchTouchEvent");;break;
            case MotionEvent.ACTION_UP:Log.i("点击事件","FrameLayout" + "----ACTION_UP------dispatchTouchEvent");break;
            case MotionEvent.ACTION_MOVE:Log.i("点击事件","FrameLayout" + "----ACTION_MOVE------dispatchTouchEvent");break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:Log.i("点击事件","FrameLayout" + "----ACTION_DOWN------onInterceptTouchEvent");;break;
            case MotionEvent.ACTION_UP:Log.i("点击事件","FrameLayout" + "----ACTION_UP------onInterceptTouchEvent");break;
            case MotionEvent.ACTION_MOVE:Log.i("点击事件","FrameLayout" + "----ACTION_MOVE------onInterceptTouchEvent");break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:Log.i("点击事件","FrameLayout" + "----ACTION_DOWN------onTouchEvent");;break;
            case MotionEvent.ACTION_UP:Log.i("点击事件","FrameLayout" + "----ACTION_UP------onTouchEvent");break;
            case MotionEvent.ACTION_MOVE:Log.i("点击事件","FrameLayout" + "----ACTION_MOVE------onTouchEvent");break;
        }
        return super.onTouchEvent(event);
    }
}
