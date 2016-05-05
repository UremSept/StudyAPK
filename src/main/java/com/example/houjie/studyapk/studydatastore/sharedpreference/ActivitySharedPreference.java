package com.example.houjie.studyapk.studydatastore.sharedpreference;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.houjie.studyapk.R;

public class ActivitySharedPreference extends AppCompatActivity {
    private EditText editText;
    private EditText editText1;
    private Button button;
    private ViewPager viewPager;
    private Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int count = viewPager.getCurrentItem();
            if(count<image.length){
                viewPager.setCurrentItem(count+1);
                sendEmptyMessageDelayed(1,2000);
            }

        }
    };
    private int []image ={R.mipmap.picture1,R.mipmap.picture2,R.mipmap.picture3,R.mipmap.picture4,
            R.mipmap.picture5};
    private ImageView[] imageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_store_shared_preference);
        editText = (EditText) findViewById(R.id.SharedPreferenceEditText1);
        editText1 = (EditText) findViewById(R.id.SharedPreferenceEditText2);
        button = (Button) findViewById(R.id.SharedPreferenceBtn1);

        final SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        String name = sharedPreferences.getString("name",null);
        String psw = sharedPreferences.getString("psw",null);
        boolean first = sharedPreferences.getBoolean("first",true);
        if (first){
            getViewPager();
        }
        if(name!=null&&psw!=null){
            editText.setText(name);
            editText1.setText(psw);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 =editText.getText().toString();
                String psw1 = editText1.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",name1);
                editor.putString("psw",psw1);
                editor.commit();
                Toast.makeText(ActivitySharedPreference.this, "保存成功", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getImage(){
        imageViews = new ImageView[image.length];
        for(int i= 0;i<image.length;i++){
            ImageView imageView =new ImageView(this);
            imageView.setImageResource(image[i]);
            imageViews[i] =imageView;
        }
    }

    private void getViewPager(){
        getImage();
        viewPager = (ViewPager) findViewById(R.id.AppFirstViewPager);
        PagerAdapter pagerAdapter = new AppFirstOpenAdapter(imageViews,ActivitySharedPreference.this);
        viewPager.setAdapter(pagerAdapter);
        handler.sendEmptyMessage(1);
        SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("first",false);
        editor.commit();
    }
}
