package com.example.houjie.studyapk.studymedia.canvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.houjie.studyapk.R;

public class ActivityMediaChangeColor extends AppCompatActivity {
    private Button mediaChangeColorBtn1,mediaChangeColorBtn2
            ,mediaChangeColorBtn3,mediaChangeColorBtn4,mediaChangeColorBtn5;
    private ImageView imageView;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_change_color);
        init();
    }

    private void init() {
        mediaChangeColorBtn1 = (Button) findViewById(R.id.mediaChangeColorBtn1);
        mediaChangeColorBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearGradient linearGradient=null;
                if(count>2)count=0;
                if(count==0){
                    linearGradient= new LinearGradient(0,0,200,0, Color.RED,Color.BLUE,
                            Shader.TileMode.CLAMP);
                    mediaChangeColorBtn1.setText("CLAMP");
                }if(count==1){
                    linearGradient= new LinearGradient(0,0,200,0, Color.RED,Color.BLUE,
                            Shader.TileMode.MIRROR);
                    mediaChangeColorBtn1.setText("MIRROR");
                }if(count==2){
                    linearGradient= new LinearGradient(0,0,200,0, Color.RED,Color.BLUE,
                            Shader.TileMode.REPEAT);
                    mediaChangeColorBtn1.setText("REPEAT");
                }
                count++;
                Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(),imageView.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setStrokeWidth(100);
                paint.setShader(linearGradient);
                canvas.drawLine(0,0,imageView.getWidth(),imageView.getHeight(),paint);
                imageView.setImageBitmap(bitmap);
            }
        });
        mediaChangeColorBtn2 = (Button) findViewById(R.id.mediaChangeColorBtn2);
        mediaChangeColorBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadialGradient radialGradient=null;
                /**
                 * 分为三种TileMode
                 TileMode.CLAMP，设置为该Mode时画笔会根据最后一个颜色继续向下绘制
                 TileMode.REPAET，设置为该Mode时，画笔会重复之前的绘制
                 TileMode.MIRROR，设置为该Mode时，画笔会镜像的绘制
                 */
                if(count>2)count=0;
                if(count==0){
                    radialGradient= new RadialGradient(imageView.getWidth()/2,imageView.getHeight()/2,50, Color.RED,Color.BLUE,
                            Shader.TileMode.CLAMP);
                    mediaChangeColorBtn2.setText("CLAMP");
                }if(count==1){
                    radialGradient= new RadialGradient(imageView.getWidth()/2,imageView.getHeight()/2,50, Color.RED,Color.BLUE,
                            Shader.TileMode.MIRROR);
                    mediaChangeColorBtn2.setText("MIRROR");
                }if(count==2){
                    radialGradient= new RadialGradient(imageView.getWidth()/2,imageView.getHeight()/2,50, Color.RED,Color.BLUE,
                            Shader.TileMode.REPEAT);
                    mediaChangeColorBtn2.setText("REPEAT");
                }
                count++;
                Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(),imageView.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setStrokeWidth(100);
                paint.setShader(radialGradient);
                canvas.drawCircle(imageView.getWidth()/2,imageView.getHeight()/2,200,paint);
                imageView.setImageBitmap(bitmap);
            }
        });
        mediaChangeColorBtn3 = (Button) findViewById(R.id.mediaChangeColorBtn3);
        mediaChangeColorBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SweepGradient sweepGradient=null;
                sweepGradient= new SweepGradient(imageView.getWidth()/2,imageView.getHeight()/2, Color.RED,Color.BLUE);
                Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(),imageView.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setStrokeWidth(100);
                paint.setShader(sweepGradient);
                canvas.drawCircle(imageView.getWidth()/2,imageView.getHeight()/2,100,paint);
                imageView.setImageBitmap(bitmap);
            }
        });
        mediaChangeColorBtn4 = (Button) findViewById(R.id.mediaChangeColorBtn4);
        mediaChangeColorBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mediaChangeColorBtn5 = (Button) findViewById(R.id.mediaChangeColorBtn5);
        mediaChangeColorBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imageView = (ImageView) findViewById(R.id.mediaChangeColorImage);
    }
}
