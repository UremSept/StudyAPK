package com.example.houjie.studyapk.studyview.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hj on 2016/5/19.
 */
public class CustomViewGroup extends ViewGroup {
    public CustomViewGroup(Context context) {
        super(context);
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int wF = getMeasuredWidth();
        int countWidth = 0;
        int countHeight = 0;
        for (int i = 0;i<getChildCount();i++){
            View childView = getChildAt(i);
            int width = childView.getMeasuredWidth();
            int height = childView.getMeasuredHeight();
            countWidth += width;
            if(wF>=countWidth){
                //左 上 右 下
                childView.layout(countWidth-width,countHeight,countWidth,countHeight+height);

            }else {
                countWidth=0;
                countHeight=countHeight+height+20;
                childView.layout(0,countHeight,width,countHeight+height);


            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
    }
}
