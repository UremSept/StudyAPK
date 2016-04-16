package com.example.houjie.studyapk.studyadapter;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyadapter.adapter.ActivityArrayAdapter;
import com.example.houjie.studyapk.studyadapter.adapter.ActivityChatAdapter;
import com.example.houjie.studyapk.studyadapter.adapter.ActivityShowPeople;
import com.example.houjie.studyapk.studyadapter.adapter.ActivitySimpleAdapter;
import com.example.houjie.studyapk.studyadapter.adapter.ActivityCustemAdapter;

public class StudyAdapter extends AppCompatActivity implements View.OnClickListener {
    private Button button1;
    private  Button button2;
    private Button button3;
    private Button button4;
    private Button button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_adapter);
        init();
    }

    private void init() {
        button1 = (Button) findViewById(R.id.btnArrayAdapter);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.btnSimpleAdapter);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.btnSimpleCursorAdapter);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.btnShowPeople);
        button4.setOnClickListener(this);
        button5 = (Button) findViewById(R.id.btnChatAdapter);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnArrayAdapter:ArrayAdapter();break;
            case R.id.btnSimpleAdapter:SimpleAdapter();break;
            case R.id.btnSimpleCursorAdapter:SimpleCursorAdapter();break;
            case R.id.btnShowPeople:ShowPeople();break;
            case R.id.btnChatAdapter:ChatAdapter();break;
            default:break;
        }
    }

    private void ShowPeople() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyAdapter.this,ActivityShowPeople.class));
        startActivity(intent);
    }

    private void ArrayAdapter(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyAdapter.this,ActivityArrayAdapter.class));
        startActivity(intent);
    }
    private void SimpleAdapter(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyAdapter.this,ActivitySimpleAdapter.class));
        startActivity(intent);
    }
    private void SimpleCursorAdapter(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyAdapter.this,ActivityCustemAdapter.class));
        startActivity(intent);
    }
    private void ChatAdapter(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyAdapter.this,ActivityChatAdapter.class));
        startActivity(intent);
    }
}
