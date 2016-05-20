package com.example.houjie.studyapk.studyview.custom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;

public class ActivityCustomEvent extends AppCompatActivity {
    private Button button;
    private GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_custom_event);
        button = (Button) findViewById(R.id.ViewCustomEnventbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("点击事件","onClick execute");
            }
        });
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("TAG", "onTouch execute, action " + event.getAction());
                return false;
            }
        });
        gestureDetector = new GestureDetector(this,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                Log.i("ActivityCustomEvent","双击屏幕");
                return super.onDoubleTap(e);
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.d("ActivityCustomEvent","手指快速滑动");
                return super.onFling(e1, e2, velocityX, velocityY);
            }

            @Override
            public void onLongPress(MotionEvent e) {
                Log.i("ActivityCustomEvent","长时间触摸屏幕");
                super.onLongPress(e);
            }
        });
}
    /**
     * Activity中包含dispatchEvent和onTouchEvent()两个方法。
     ViewGroup包含dispatchEvent和onInterceptEvent以及onTouchEvent三个方法
     View中包含dispatchEvent和onTouchEvent两个方法

     ViewGroup中的onInterceptEvent()方法默认返回false及对事件不进行拦截，onTouchEvent默认返回false，默认不处理事件
     View中的onTouchEvent默认返回true即对事件进行消费。
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("点击事件","activity------------dispatchTouchEvent------");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("点击事件","activity----------onTouchEvent--------");
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
