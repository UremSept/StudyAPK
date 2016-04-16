package com.example.houjie.studyapk.studyintent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyintent.intent.BackActivity;
import com.example.houjie.studyapk.studyintent.intent.SecActivity;
import com.example.houjie.studyapk.studyintent.intent.Student;

public class StudyIntent extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_study_intent);

        System.out.println("运行到MainActivity的onCreate方法");
        Button button1 = (Button) findViewById(R.id.IntentButton1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                Intent intent = new Intent();//MainActivity.this,SecActivity.class
                //显式地启动activity ，使用的是component属性指定了要启动的组件的名称
                intent.setComponent(new ComponentName(StudyIntent.this,SecActivity.class));
                intent.putExtra("text","改变后的数据内容");
                Bundle bundle = new Bundle();
                bundle.putCharSequence("name","张三");
                bundle.putCharSequence("age","20");
                bundle.putCharSequence("sex","男");
                intent.putExtra("student",bundle);
                Student zhangsan = new Student();
                zhangsan.setName("张三");
                zhangsan.setAge("18");
                zhangsan.setSex("女");
                intent.putExtra("zhangsan",zhangsan);
                startActivity(intent);
            }
        });
        Button button2= (Button)findViewById(R.id.IntentButton2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("shofahfohfo");
                startActivity(intent);
                //隐式地启动activity
            }
        });
        Button button3= (Button)findViewById(R.id.IntentButton3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:110"));
                startActivity(intent);
                //隐式地启动activity
            }
        });
        Button button4= (Button)findViewById(R.id.IntentButton4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:110"));
                startActivity(intent);
                //隐式地启动activity
            }
        });
        Button button5 = (Button) findViewById(R.id.IntentButton);
        textView= (TextView) findViewById(R.id.IntenttextView);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(StudyIntent.this,BackActivity.class);
                startActivityForResult(intent,0x33);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("运行到MainActivity的onStart方法");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("运行到MainActivity的onResume方法");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("运行到MainActivity的onPause方法");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("运行到MainActivity的onStop方法");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("运行到MainActivity的onDestroy方法");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("运行到MainActivity的onRestart方法");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            switch (requestCode){
                case 0x33: String str = data.getStringExtra("text");
                    textView.setText(str);
                    break;
                default:break;
            }

        }else{

        }
    }
}
