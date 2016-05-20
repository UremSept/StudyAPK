package com.example.houjie.studyapk.studyview.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.utils.DpUtils;

/**
 * Created by hj on 2016/5/19.
 */
public class CustomViewEditview extends EditText{
    private Paint mPaint;
    private float width,height;
    private Context mContext;

    public CustomViewEditview(Context context) {
        super(context);
        init(context);
    }

    public CustomViewEditview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        mPaint = new Paint();
        if(attrs!=null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomViewEditview);
            int color= typedArray.getColor(R.styleable.CustomViewEditview_count_color,Color.GREEN);
            mPaint.setColor(color);
        }else {
            mPaint.setColor(Color.BLACK);
        }
        mPaint.setStrokeWidth(20f);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(30);
    }

    public CustomViewEditview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomViewEditview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }
    //测量控件的宽高
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getWidth();
        height = getHeight();
    }

    //绘制控件的方法
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String string = getText().length()+"/100";
        //canvas.drawText(string,width-DpUtils.dip2px(mContext,60) ,height-DpUtils.dip2px(mContext,10),mPaint);
        canvas.drawText(string,width-mPaint.measureText(string),height+getScaleY()-mPaint.measureText(string),mPaint);
    }
    private void init(Context context){
        mContext = context;
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(20f);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(30);
    }
}
