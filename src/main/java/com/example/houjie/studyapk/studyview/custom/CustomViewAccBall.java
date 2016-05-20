package com.example.houjie.studyapk.studyview.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

/**
 * 仿360加速球的自定义控件
 * Created by hj on 2016/5/19.
 */
public class CustomViewAccBall extends View{
    private Paint paintCircle,paintText,paintLine;
    private int r,width,height,dWidth,dHeight;
    private int bHeight=50;
    private int bCount = 5;
    private Random random;
 //   private int count=0,offset,num2,num1;
    private Path path;
    private final int maxProgress = 100;
    private int progress=0;
    private Bitmap bitmap;
    private Canvas bitmapCanvas;
    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();//实时更新进度
    }

    public int getMaxProgress() {
        return maxProgress;
    }

    public CustomViewAccBall(Context context) {
        super(context);
        init();
    }

    public CustomViewAccBall(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomViewAccBall(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomViewAccBall(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        paintCircle = new Paint();
        paintCircle.setStrokeWidth(1);
        paintCircle.setAntiAlias(true);
        paintCircle.setColor(Color.argb(0xff,0x2b,0x84,0x62));
        paintCircle.setStyle(Paint.Style.FILL);

        paintText = new Paint();
        paintText.setTextSize(50f);
        paintText.setAntiAlias(true);
        paintText.setTextAlign(Paint.Align.CENTER);
        paintText.setColor(Color.WHITE);

        paintLine = new Paint();
        paintLine.setStyle(Paint.Style.FILL);
        paintLine.setColor(Color.argb(0xff,0x4e,0xc8,0x63));
        paintLine.setStrokeWidth(1);
        paintLine.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bitmapCanvas.drawCircle(width/2,height/2,r,paintCircle);//绘制圆
        //通过Path绘制贝塞尔曲线
        path.reset();
        path.moveTo(0, height);
        path.lineTo(0, ((float) maxProgress-progress)/100*height);
        for (int i = 0; i < bCount; i++) {
            path.rQuadTo(random.nextFloat()*bHeight, random.nextFloat()*dWidth/2,random.nextFloat()*dWidth, 0);
//            path.rQuadTo(20, -5, 40, 0);
        }
        path.lineTo(width, ((float) maxProgress-progress)/100*((float)height));
        Log.e("(maxProgrerogressheight","----------------"+((float) maxProgress-progress)/100*height);
        path.lineTo(width, height);
        path.close();
        //将贝塞尔曲线绘制到Bitmap的Canvas上
        bitmapCanvas.drawPath(path, paintLine);
        //将Bitmap绘制到View的Canvas上
        bitmapCanvas.drawText(progress * 100f / maxProgress + "%", width / 2, height / 2, paintText);
        canvas.drawBitmap(bitmap, 0, 0, null);
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    //更新进度
                    progress += 5;
                    if (progress > 100) {
                        progress = 0;
                    }
                    invalidate();
                    sendEmptyMessageDelayed(1, 1000);
                    break;
            }
        }
    };
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = this.getMeasuredWidth();
        height = this.getMeasuredWidth();
        setMeasuredDimension(width, height);
        r = width/2;
        dHeight = height/5;
        dWidth = width/5;
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmapCanvas = new Canvas(bitmap);
        random = new Random();
    }
    public void sendMassage(){
        handler.sendEmptyMessageDelayed(1, 1000);
    }
    public void setAnimation(){

    }
}
