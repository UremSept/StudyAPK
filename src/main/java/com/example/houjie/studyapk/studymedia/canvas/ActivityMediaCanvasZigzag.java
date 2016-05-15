package com.example.houjie.studyapk.studymedia.canvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.houjie.studyapk.R;

public class ActivityMediaCanvasZigzag extends AppCompatActivity {
    private Button canvasZigzagBtn1;
    private ImageView canvasZigzagImage;
    private PathEffect[] pathEffects = new PathEffect[7];
    private Paint mPaint;
    private Path mPath;
    private int [] mColor;
    private float mPhase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_canvas_zigzag);
        init();

        canvasZigzagImage= (ImageView) findViewById(R.id.canvasZigzagImage);
        canvasZigzagBtn1= (Button) findViewById(R.id.canvasZigzagBtn1);
        canvasZigzagBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = Bitmap.createBitmap(canvasZigzagImage.getWidth(),canvasZigzagImage.getHeight(),Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.drawColor(Color.WHITE);
                /**
                 * setPathEffect设置Piant的填充效果
                 CornerPathEffect可以使用圆角来代替尖锐的角从而对基本图形的形状尖锐的边角进行平滑
                 DashPathEffect创建一个虚线的轮廓(短横线/小圆点)，而不是使用实线
                 DiscretePathEffect与DashPathEffect相似，但是添加了随机性。当绘制它的时候，需要指定每一段的长度和与原始路径的偏离度
                 PathDashPathEffect 定义一个新的形状(路径)并将其用作原始路径的轮廓标记
                 ComposePathEffect 将两种效果组合起来应用，先使用第一种效果，然后在这种效果的基础上应用第二种效果
                 SumPathEffect   顺序地在一条路径中添加两种效果，这样每一种效果都可以应用到原始路径中，而且两种结果可以结合起来

                 */
                //第一种效果，默认
                pathEffects[0] = null;
                //第二种，圆角   ----CornerPathEffect可以使用圆角来代替尖锐的角从而对基本图形的形状尖锐的边角进行平滑
                pathEffects[1] = new CornerPathEffect(10);//传入的参数为圆角半径
                //第三种效果，segmentLength 短横线的长度 mPhase  ----DashPathEffect创建一个虚线的轮廓(短横线/小圆点)，而不是使用实线
                pathEffects[2] = new DashPathEffect(new float[]{1,3,6,3},mPhase);//
                //第四种效果 ，segmentLength 短横线的长度 deviation与原路径的偏离度
                //----DiscretePathEffect与DashPathEffect相似，但是添加了随机性。当绘制它的时候，需要指定每一段的长度和与原始路径的偏离度

                pathEffects[3] = new DiscretePathEffect(3,5);
                Path path = new Path();
                //CCW轮廓
                path.addRect(0,0,8,8, Path.Direction.CCW);
                //第五种效果，----PathDashPathEffect 定义一个新的形状(路径)并将其用作原始路径的轮廓标记
                pathEffects[4] = new PathDashPathEffect(path,12,mPhase, PathDashPathEffect.Style.ROTATE);
                //第六种效果，----将两种效果组合起来应用，先使用第一种效果，然后在这种效果的基础上应用第二种效果
                pathEffects[5] = new ComposePathEffect(pathEffects[3],pathEffects[4]);
                //第七种效果 ----顺序地在一条路径中添加两种效果，这样每一种效果都可以应用到原始路径中，而且两种结果可以结合起来
                pathEffects[6] = new SumPathEffect(pathEffects[4],pathEffects[2]);
                canvas.translate(8,8);
                for (int i=0;i<pathEffects.length;i++){
                    mPaint.setPathEffect(pathEffects[i]);
                    mPaint.setColor(mColor[i]);
                    canvas.drawPath(mPath,mPaint);
                    canvas.translate(0,60);
                }
                canvasZigzagImage.setImageBitmap(bitmap);
            }
        });
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        mPath = new Path();
        for(int i = 1;i<15;i++){
            mPath.lineTo(i*40,(float)(Math.random()*60));
        }
        mColor = new int[]{
                Color.BLACK,Color.BLUE,Color.CYAN,Color.DKGRAY,
                Color.GRAY,Color.GREEN,Color.LTGRAY
        };
    }
}
