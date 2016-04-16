package com.example.houjie.studyapk.studyintent.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.houjie.studyapk.R;

/**
 * Created by houjie on 2016/3/16.
 */
public class SecActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_sec);
        Intent intent  =  getIntent();
        String text = intent.getStringExtra("text");
        Bundle bundle = intent.getBundleExtra("student");
        String name = (String)bundle.getCharSequence("name");
        String age = (String)bundle.getCharSequence("age");
        String sex = (String)bundle.getCharSequence("sex");
        TextView textView = (TextView)findViewById(R.id.textView);
        Student zhangsan = (Student)intent.getParcelableExtra("zhangsan");
        textView.setText(text+name+age+sex+zhangsan.getName()+zhangsan.getAge()+zhangsan.getSex());
        System.out.println("运行到SecActivity的onCreate方法");
    }
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("运行到SecActivity的onStart方法");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("运行到SecActivity的onResume方法");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("运行到SecActivity的onPause方法");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("运行到SecActivity的onStop方法");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("运行到SecActivity的onDestroy方法");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("运行到SecActivitys的onRestart方法");
    }
}
