package com.example.houjie.studyapk.studymedia.mipmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studymedia.util.MipmapUtils;

public class ActivityMediaMipmap extends AppCompatActivity {
    private Button button;
    private Button button1;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_mipmap);
        button = (Button) findViewById(R.id.MeidaMipmapBtn1);
        button1 = (Button) findViewById(R.id.MeidaMipmapBtn2);
        imageView = (ImageView) findViewById(R.id.MeidaMipmapImageView1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS)+"/aaa.jpg");
                Log.i("原图大小","++++++++++++++++++++++++++++++++++"+bitmap.getByteCount());
                imageView.setImageBitmap(bitmap);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = MipmapUtils.ZipBitmap(Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS)+"/aaa.jpg");
                Log.i("压缩大小","++++++++++++++++++++++++++++++++++"+bitmap.getByteCount());
                imageView.setImageBitmap(bitmap);
            }
        });
    }

}
