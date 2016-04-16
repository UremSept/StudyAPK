package com.example.houjie.studyapk.studyview.view;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.example.houjie.studyapk.R;

import java.lang.reflect.Field;

public class RichText extends AppCompatActivity {
    private TextView ee=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_rich_text);
        ee = (TextView)findViewById(R.id.hello);
        String html = "你好<img src='ic_launcher'></img>,我也有图片，这有另一张图片，<img src='helloword'></img>";
        Spanned s = Html.fromHtml(html,new Html.ImageGetter(){
            public Drawable getDrawable(String source){
                Drawable drawable = null;
                Class clazz = R.mipmap.class;
                try{
                    Field field = clazz.getDeclaredField(source);
                    int id = field.getInt(null);//使用反射机制得到R.mipmap.header的值
                    drawable = getResources().getDrawable(id);//使用资源id得到图片
                    //设置图片的高宽
                    drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());

                }catch(Exception e){

                }

                return drawable;
            }
        },null);
        ee.setText(s);
    }
}
