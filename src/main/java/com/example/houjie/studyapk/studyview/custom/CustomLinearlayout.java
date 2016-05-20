package com.example.houjie.studyapk.studyview.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by hj on 2016/5/20.
 */
public class CustomLinearlayout extends LinearLayout {
    public CustomLinearlayout(Context context) {
        super(context);
    }

    public CustomLinearlayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearlayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomLinearlayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    //ViewGroup包含dispatchEvent和onInterceptEvent以及onTouchEvent三个方法

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:Log.i("点击事件","LinearLayout" + "----ACTION_DOWN------dispatchTouchEvent");;break;
            case MotionEvent.ACTION_UP:Log.i("点击事件","LinearLayout" + "----ACTION_UP------dispatchTouchEvent");break;
            case MotionEvent.ACTION_MOVE:Log.i("点击事件","LinearLayout" + "----ACTION_MOVE------dispatchTouchEvent");break;
        }
        //dispatchEvent()		分配事件
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:Log.i("点击事件","LinearLayout" + "----ACTION_DOWN------onInterceptTouchEvent");;break;
            case MotionEvent.ACTION_UP:Log.i("点击事件","LinearLayout" + "----ACTION_UP------onInterceptTouchEvent");break;
            case MotionEvent.ACTION_MOVE:Log.i("点击事件","LinearLayout" + "----ACTION_MOVE------onInterceptTouchEvent");break;
        }
        //        onInterceptEvent()	是否拦截事件
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:Log.i("点击事件","LinearLayout" + "----ACTION_DOWN------onTouchEvent");;break;
            case MotionEvent.ACTION_UP:Log.i("点击事件","LinearLayout" + "----ACTION_UP------onTouchEvent");break;
            case MotionEvent.ACTION_MOVE:Log.i("点击事件","LinearLayout" + "----ACTION_MOVE------onTouchEvent");break;
        }
        //onTouchEvent()		是否响应事件
        return super.onTouchEvent(event);
    }
}
