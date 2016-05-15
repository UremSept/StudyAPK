package com.example.houjie.studyapk.studymedia.canvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.houjie.studyapk.R;

public class ActivityMediaXfermode extends AppCompatActivity implements View.OnClickListener{
    /*
    <!--
    在Android的PorterDuff.Mode类中列举了他们制定的规则：
    android.graphics.PorterDuff.Mode.SRC:只绘制源图像
    android.graphics.PorterDuff.Mode.DST:只绘制目标图像
    android.graphics.PorterDuff.Mode.DST_OVER:在源图像的顶部绘制目标图像
    android.graphics.PorterDuff.Mode.DST_IN:只在源图像和目标图像相交的地方绘制目标图像
    android.graphics.PorterDuff.Mode.DST_OUT:只在源图像和目标图像不相交的地方绘制目标图像
    android.graphics.PorterDuff.Mode.DST_ATOP:在源图像和目标图像相交的地方绘制目标图像，在不相交的地方绘制源图像
    android.graphics.PorterDuff.Mode.SRC_OVER:在目标图像的顶部绘制源图像
    android.graphics.PorterDuff.Mode.SRC_IN:只在源图像和目标图像相交的地方绘制源图像
    android.graphics.PorterDuff.Mode.SRC_OUT:只在源图像和目标图像不相交的地方绘制源图像
    android.graphics.PorterDuff.Mode.SRC_ATOP:在源图像和目标图像相交的地方绘制源图像，在不相交的地方绘制目标图像
    android.graphics.PorterDuff.Mode.XOR:在源图像和目标图像重叠之外的任何地方绘制他们，而在不重叠的地方不绘制任何内容
    android.graphics.PorterDuff.Mode.LIGHTEN:获得每个位置上两幅图像中最亮的像素并显示
    android.graphics.PorterDuff.Mode.DARKEN:获得每个位置上两幅图像中最暗的像素并显示
    android.graphics.PorterDuff.Mode.MULTIPLY:将每个位置的两个像素相乘，除以255，然后使用该值创建一个新的像素进行显示。结果颜色=顶部颜色*底部颜色/255
    android.graphics.PorterDuff.Mode.SCREEN:反转每个颜色，执行相同的操作（将他们相乘并除以255），然后再次反转。结果颜色=255-(((255-顶部颜色)*(255-底部颜色))/255)
    -->
    */
    private Button btnSRC,btnDST,btnDST_OVER,btnDST_IN,btnDST_OUT,
    btnDST_ATOP,btnSRC_OVER,btnSRC_IN,btnSRC_OUT,btnSRC_ATOP,btnXOR,
    btnLIGHTEN,btnDARKEN,btnMULTIPLY,btnSCREEN,btnClear;
    private ImageView imageView;
    private int wight;
    private int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_xfermode);
        init();
    }

    private void init() {
        btnSRC = (Button) findViewById(R.id.mediaXfermodeBtnSRC);
        btnDST = (Button) findViewById(R.id.mediaXfermodeBtnDST);
        btnDST_OVER= (Button) findViewById(R.id.mediaXfermodeBtnDST_OVER);
        btnDST_IN = (Button) findViewById(R.id.mediaXfermodeBtnDST_IN);
        btnDST_OUT = (Button) findViewById(R.id.mediaXfermodeBtnDST_OUT);
        btnDST_ATOP= (Button) findViewById(R.id.mediaXfermodeBtnDST_ATOP);
        btnSRC_OVER = (Button) findViewById(R.id.mediaXfermodeBtnSRC_OVER);
        btnSRC_IN = (Button) findViewById(R.id.mediaXfermodeBtnSRC_IN);
        btnSRC_OUT = (Button) findViewById(R.id.mediaXfermodeBtnSRC_OUT);
        btnSRC_ATOP = (Button) findViewById(R.id.mediaXfermodeBtnSRC_ATOP);
        btnXOR = (Button) findViewById(R.id.mediaXfermodeBtnXOR);
        btnLIGHTEN = (Button) findViewById(R.id.mediaXfermodeBtnLIGHTEN);
        btnDARKEN = (Button) findViewById(R.id.mediaXfermodeBtnDARKEN);
        btnMULTIPLY = (Button) findViewById(R.id.mediaXfermodeBtnMULTIPLY);
        btnSCREEN = (Button) findViewById(R.id.mediaXfermodeBtnSCREEN);
        btnClear = (Button) findViewById(R.id.mediaXfermodeBtnCLEAR);
        imageView = (ImageView) findViewById(R.id.mediaXfermodeImage);
        btnSRC.setOnClickListener(this);
        btnDST.setOnClickListener(this);
        btnDST_OVER.setOnClickListener(this);
        btnDST_OUT.setOnClickListener(this);
        btnDST_IN.setOnClickListener(this);
        btnDST_ATOP.setOnClickListener(this);
        btnSRC_OVER.setOnClickListener(this);
        btnSRC_IN.setOnClickListener(this);
        btnSRC_OUT.setOnClickListener(this);
        btnSRC_ATOP.setOnClickListener(this);
        btnXOR.setOnClickListener(this);
        btnLIGHTEN.setOnClickListener(this);
        btnDARKEN.setOnClickListener(this);
        btnMULTIPLY.setOnClickListener(this);
        btnSCREEN.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        wight = imageView.getWidth();
        Log.i("imageView.getWidth","---------------------"+wight);
        height = imageView.getHeight();
        Log.i("imageView.getHeight","---------------------"+height);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mediaXfermodeBtnSRC:
                drawMap(PorterDuff.Mode.SRC);
                break;
            case R.id.mediaXfermodeBtnDST:
                drawMap(PorterDuff.Mode.DST);
                break;
            case R.id.mediaXfermodeBtnDST_OVER:
                drawMap(PorterDuff.Mode.DST_OVER);
                break;
            case R.id.mediaXfermodeBtnDST_OUT:
                drawMap(PorterDuff.Mode.DST_OUT);
                break;
            case R.id.mediaXfermodeBtnDST_IN:
                drawMap(PorterDuff.Mode.DST_IN);
                break;
            case R.id.mediaXfermodeBtnDST_ATOP:
                drawMap(PorterDuff.Mode.DST_ATOP);
                break;
            case R.id.mediaXfermodeBtnSRC_OVER:
                drawMap(PorterDuff.Mode.SRC_OVER);
                break;
            case R.id.mediaXfermodeBtnSRC_IN:
                drawMap(PorterDuff.Mode.SRC_IN);
                break;
            case R.id.mediaXfermodeBtnSRC_OUT:
                drawMap(PorterDuff.Mode.SRC_OUT);
                break;
            case R.id.mediaXfermodeBtnSRC_ATOP:
                drawMap(PorterDuff.Mode.SRC);
                break;
            case R.id.mediaXfermodeBtnXOR:
                drawMap(PorterDuff.Mode.XOR);
                break;
            case R.id.mediaXfermodeBtnLIGHTEN:
                drawMap(PorterDuff.Mode.LIGHTEN);
                break;
            case R.id.mediaXfermodeBtnDARKEN:
                drawMap(PorterDuff.Mode.DARKEN);
                break;
            case R.id.mediaXfermodeBtnMULTIPLY:
                drawMap(PorterDuff.Mode.MULTIPLY);
                break;
            case R.id.mediaXfermodeBtnSCREEN:
                drawMap(PorterDuff.Mode.SCREEN);
                break;
            case R.id.mediaXfermodeBtnCLEAR:
                drawMap(PorterDuff.Mode.CLEAR);
                break;


        }
    }
//创建一个矩形图片
    private Bitmap getRectangle(){
        Log.i("imageView.getWidth","---------------------"+wight);
        Log.i("imageView.getHeight","---------------------"+height);
        Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(),imageView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        canvas.drawRect(0,0,imageView.getWidth()/2,imageView.getHeight()/2,paint);
        return bitmap;
    }
    //创建一个圆形图片
    private Bitmap getCircle(){
        Bitmap bitmap = Bitmap.createBitmap(100,100, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
//        //用对角线创建一个矩形，数据为浮点型
//        RectF rectF = new RectF(0,0,imageView.getWidth()/2,imageView.getHeight()/2);
//        //按照矩形来画一个椭圆
//        canvas.drawOval(rectF,paint);
        canvas.drawCircle(100/2,100/2,50,paint);
        return bitmap;
    }
    private void drawMap(PorterDuff.Mode mode){
        Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(),imageView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.GRAY);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        int sc = canvas.saveLayer(0,0,imageView.getWidth(),imageView.getHeight(),paint,Canvas.ALL_SAVE_FLAG|
                Canvas.CLIP_SAVE_FLAG|Canvas.CLIP_TO_LAYER_SAVE_FLAG|Canvas.FULL_COLOR_LAYER_SAVE_FLAG|Canvas.HAS_ALPHA_LAYER_SAVE_FLAG
        |Canvas.MATRIX_SAVE_FLAG);
        //用对角线创建一个矩形，数据为浮点型
//        RectF rectF = new RectF(0,0,wight*3/4,height*3/4);
//        //按照矩形来画一个椭圆
//        canvas.drawOval(rectF,paint);
        canvas.drawBitmap(getRectangle(),0,0,paint);
        if(mode!=null){
            paint.setXfermode(new PorterDuffXfermode(mode));
        }
        canvas.drawBitmap(getCircle(),imageView.getWidth()/4,imageView.getHeight()/4,paint);
        canvas.restoreToCount(sc);
        imageView.setImageBitmap(bitmap);
    }
}
