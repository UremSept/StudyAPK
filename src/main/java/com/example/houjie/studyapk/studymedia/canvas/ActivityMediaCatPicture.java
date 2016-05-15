package com.example.houjie.studyapk.studymedia.canvas;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.IconMarginSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.houjie.studyapk.R;

public class ActivityMediaCatPicture extends AppCompatActivity {
    private Button mediaCatPictureBtn;
    private ImageView mediaCatPictureImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_cat_picture);
        mediaCatPictureImage = (ImageView) findViewById(R.id.mediaCatPictureImage);
        mediaCatPictureBtn = (Button) findViewById(R.id.mediaCatPictureBtn);
        mediaCatPictureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);//调用系统相册
                /**
                 * 其实在4.3或以下可以直接用ACTION_GET_CONTENT的
                 * ,在4.4或以上,官方建议用ACTION_OPEN_DOCUMENT,主要区别是
                 * 他们返回的Uri.4.3返回的是带文件路径的,而4.4返回的却是
                 * content://com.android.providers.media.documents/document/image:3951这样的
                 * ,没有路径,只有图片编号的uri.可以通过以下方式，处理URI。
                 */
                startActivityForResult(intent,1);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // if(resultCode!=RESULT_CANCELED){
            switch (requestCode){
                case 1:
                    //从相册中选取的图片的uri保存在data中
                    startPhotoZoom(data.getData());
                    break;
                case 2:
                    Log.i("=================","========================");
                    //截取完图片的数据保存在data中；
                    viewToImage(data);
       //     }
        }
    }

    private void startPhotoZoom(Uri uri){
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri,"image/*");
        //设置裁剪
        intent.putExtra("crop","true");
        //设置宽高比例
        intent.putExtra("aspectX",1);
        intent.putExtra("aspectY",1);
        //裁剪图片宽高
        intent.putExtra("outputX",320);
        intent.putExtra("outputY",320);
        intent.putExtra("return-data",true);
        startActivityForResult(intent,2);


    }
    private void viewToImage(Intent data){
        Bundle bundle = data.getExtras();
        if(bundle!=null){
            Bitmap bitmap = bundle.getParcelable("data");
            int wight = bitmap.getWidth();
            int height = bitmap.getHeight();

            Bitmap output = Bitmap.createBitmap(wight,height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);
            Paint paint = new Paint();
            paint.setColor(0xff595956);
            paint.setAntiAlias(true);
//            Rect rect =new Rect(0,0,wight,height);
//            RectF rectF = new RectF(rect);
//            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//            canvas.drawRoundRect(rectF,50,50,paint);
//            mediaCatPictureImage.setImageBitmap(output);
            //画椭圆
            canvas.drawOval(new RectF(0,0,bitmap.getWidth(),bitmap.getHeight()),paint);
            //设置模式
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            //画图片
            canvas.drawBitmap(bitmap,0,0,paint);
            mediaCatPictureImage.setImageBitmap(output);

        }else{
            Log.i("TAG------","数据为空");
        }
    }
}
