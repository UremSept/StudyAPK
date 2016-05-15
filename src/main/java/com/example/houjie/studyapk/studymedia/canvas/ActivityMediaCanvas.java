package com.example.houjie.studyapk.studymedia.canvas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.houjie.studyapk.R;

public class ActivityMediaCanvas extends AppCompatActivity {
    private Button MediaCanvasBtn1;
    private Button MediaCanvasBtn2;
    private Button MediaCanvasBtn3;
    private Button MediaCanvasBtn4;
    private Button MediaCanvasBtn5;
    private ImageView MediaCanvasImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_canvas);
        MediaCanvasImageView = (ImageView) findViewById(R.id.MediaCanvasImage);
        MediaCanvasBtn1 = (Button) findViewById(R.id.MediaCanvasBtn1);
        //在画布上画背景颜色
        MediaCanvasBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = Bitmap.createBitmap(MediaCanvasImageView.getWidth(),MediaCanvasImageView.getHeight(),Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.drawColor(Color.BLUE);
                MediaCanvasImageView.setImageBitmap(bitmap);

            }
        });
        //用画笔在画布上绘制一条线
        MediaCanvasBtn2 = (Button) findViewById(R.id.MediaCanvasBtn2);
        MediaCanvasBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = Bitmap.createBitmap(MediaCanvasImageView.getWidth(),MediaCanvasImageView.getHeight(),Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawLine(0,0,MediaCanvasImageView.getWidth(),MediaCanvasImageView.getHeight(),paint);
                MediaCanvasImageView.setImageBitmap(bitmap);

            }
        });
        //画圆
        MediaCanvasBtn3 = (Button) findViewById(R.id.MediaCanvasBtn3);
        MediaCanvasBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = Bitmap.createBitmap(MediaCanvasImageView.getWidth(),MediaCanvasImageView.getHeight(),Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setColor(Color.RED);
                paint.setStrokeWidth(10);
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawCircle(MediaCanvasImageView.getWidth()/2,MediaCanvasImageView.getHeight()/2,300,paint);
                MediaCanvasImageView.setImageBitmap(bitmap);
            }
        });
        MediaCanvasBtn4 = (Button) findViewById(R.id.MediaCanvasBtn4);
        MediaCanvasBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = Bitmap.createBitmap(MediaCanvasImageView.getWidth(),MediaCanvasImageView.getHeight(),Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.helloword),0,0,null);
                MediaCanvasImageView.setImageBitmap(bitmap);
            }
        });
        MediaCanvasBtn5 = (Button) findViewById(R.id.MediaCanvasBtn5);
        MediaCanvasBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int width = MediaCanvasImageView.getWidth();
                int height =MediaCanvasImageView.getHeight();
                Bitmap bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                /**
                 * Paint即画笔，在画布中绘制内容时使用Paint paint=new Paint();创建新的画笔
                 paint.setColor()设置画笔的颜色
                 paint.setAlpha()设置画笔的透明度
                 paint.setAntiAlias()设置是否抗锯齿
                 paint.setDither()设置图片抖动
                 paint.setStrokeWidth()设置画笔的宽度
                 paint.setAlign设置绘制文本时文本的位置
                 paint.setStyle设置绘制时是否充满
                 */
                paint.setColor(Color.RED);
                paint.setStrokeWidth(2);
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawCircle(width/2,height/2,
                        (width>height?height:width)/2-10,paint);
                canvas.save();
                for (int i=1;i<=12;i++){
                    canvas.rotate(360/12,width/2,height/2);//设置旋转角度
                    canvas.drawLine(width/2,20,width/2,40,paint);
                    canvas.drawText(i+"",width/2,80,paint);
                }
                canvas.restore();
                MediaCanvasImageView.setImageBitmap(bitmap);
            }
        });
    }
}


















