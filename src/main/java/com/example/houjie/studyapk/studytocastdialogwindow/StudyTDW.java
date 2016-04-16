package com.example.houjie.studyapk.studytocastdialogwindow;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studytocastdialogwindow.dialog.ActivityDialog;
import com.example.houjie.studyapk.studytocastdialogwindow.tocast.ActivityToast;
import com.example.houjie.studyapk.studytocastdialogwindow.window.ActivityWindow;

public class StudyTDW extends AppCompatActivity implements View.OnClickListener{
    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_tdw);
        init();
    }

    private void init() {
        button1 = (Button) findViewById(R.id.window);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.tocast);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.dialog);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.window:Window();break;
            case R.id.tocast:Tocast();break;
            case R.id.dialog:Dialog();break;
            default:break;
        }
    }
    private void Window(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyTDW.this,ActivityWindow.class));
        startActivity(intent);
    }
    private void Tocast(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyTDW.this,ActivityToast.class));
        startActivity(intent);
    }
    private void Dialog(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyTDW.this,ActivityDialog.class));
        startActivity(intent);
    }
}
