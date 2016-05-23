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
    private Paint paintCircle,paintText,paintLine;//三个画笔，
    private int r,width,height;//加速球的半径，view的宽和高
    private int dWidth,dHeight,bCount = 5,bHeight=50;//贝塞尔曲线的一些决定量，可以自己设置，我不太会用
    private Random random;//产生随机数，加速球的波浪效果
    private Path path;//
    private final int maxProgress = 100;//当前的进度
    private int progress=0;
    private Bitmap bitmap;//位图
    private Canvas bitmapCanvas;//位图画板
    public int getProgress() {
        return progress;
    }//

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();//实时更新进度
    }

    public int getMaxProgress() {
        return maxProgress;
    }


    //构造器，必须实现
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
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)//取消版本限制
    public CustomViewAccBall(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        //初始化圆的画笔
        paintCircle = new Paint();
        paintCircle.setStrokeWidth(1);
        paintCircle.setAntiAlias(true);
        paintCircle.setColor(Color.argb(0xff,0x2b,0x84,0x62));
        paintCircle.setStyle(Paint.Style.FILL);
        //初始化文字的画笔
        paintText = new Paint();
        paintText.setTextSize(50f);
        paintText.setAntiAlias(true);
        paintText.setTextAlign(Paint.Align.CENTER);
        paintText.setColor(Color.WHITE);

        //初始化波浪线的画笔
        paintLine = new Paint();
        paintLine.setStyle(Paint.Style.FILL);
        paintLine.setColor(Color.argb(0xff,0x4e,0xc8,0x63));
        paintLine.setStrokeWidth(1);
        paintLine.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        // android.graphics.PorterDuff.Mode.SRC_IN:只在源图像和目标图像相交的地方绘制源图像

        path = new Path();
        //初始化path
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bitmapCanvas.drawCircle(width/2,height/2,r,paintCircle);//绘制圆
        //通过Path绘制贝塞尔曲线，此处贝塞尔曲线不是太懂，所以画的东西不是太好，望高手指点
        path.reset();//清除path内容
        path.moveTo(0, height);
        path.lineTo(0, ((float) maxProgress-progress)/100*height);//此处若在定义时若是int,则必须强制转换，否则结果为零，聪明的你一定能理解。
        for (int i = 0; i < bCount; i++) {
            path.rQuadTo(random.nextFloat()*bHeight, random.nextFloat()*dWidth/2,random.nextFloat()*dWidth, 0);
//            path.rQuadTo(20, -5, 40, 0);//可以是这样的固定值
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
//    Handler handler = new Handler(){//这个可以没有，用来验证可增加的效果
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what){
//                case 1:
//                    //更新进度
//                    progress += 5;
//                    if (progress > 100) {
//                        progress = 0;
//                    }//让进度自增
//                    invalidate();
//                    sendEmptyMessageDelayed(1, 1000);
//                    break;
//            }
//        }
//    };
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = this.getMeasuredWidth();//得到宽和高
        height = this.getMeasuredWidth();
        setMeasuredDimension(width, height);
        r = width/2;//设置圆的半径
        dHeight = height/5;
        dWidth = width/5;
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);//设置图片的大小
        bitmapCanvas = new Canvas(bitmap);
        random = new Random();
    }
//    public void sendMassage(){
//        handler.sendEmptyMessageDelayed(1, 1000);
//    }
}
