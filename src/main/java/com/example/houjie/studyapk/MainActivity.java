package com.example.houjie.studyapk;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.studyadapter.StudyAdapter;
import com.example.houjie.studyapk.studyfragment.StudyFragment;
import com.example.houjie.studyapk.studyintent.StudyIntent;
import com.example.houjie.studyapk.studynotification.ActivityNotification;
import com.example.houjie.studyapk.studymenu.ActivityMenu;
import com.example.houjie.studyapk.studyservice.ActivityService;
import com.example.houjie.studyapk.studytnewknowledge.ActivityStudyNewKnowledge;
import com.example.houjie.studyapk.studytocastdialogwindow.StudyTDW;
import com.example.houjie.studyapk.studyview.StudyView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnStudyIntent;
    private Button btnStudyAdapter;
    private Button btnStudyView;
    private Button btnStudyTDW;
    private Button btnStudyNotified;
    private Button btnStudyNotification;
    private Button btnStudyService;
    private Button btnStudyFragment;
    private Button btnStudyNewKnowledge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btnStudyIntent= (Button) findViewById(R.id.btnStudyIntent);
        btnStudyIntent.setOnClickListener(this);
        btnStudyAdapter = (Button) findViewById(R.id.btnStudyAdapter);
        btnStudyAdapter.setOnClickListener(this);
        btnStudyView = (Button) findViewById(R.id.btnStudyView);
        btnStudyView.setOnClickListener(this);
        btnStudyTDW = (Button) findViewById(R.id.btnStudyTDW);
        btnStudyTDW.setOnClickListener(this);
        btnStudyNotification = (Button) findViewById(R.id.btnStudyNotification);
        btnStudyNotification.setOnClickListener(this);
        btnStudyNotified = (Button) findViewById(R.id.btnStudyNotified);
        btnStudyNotified.setOnClickListener(this);
        btnStudyFragment = (Button) findViewById(R.id.btnStudyFragment);
        btnStudyFragment.setOnClickListener(this);
        btnStudyNewKnowledge = (Button) findViewById(R.id.btnStudyNewKnowledge);
        btnStudyNewKnowledge.setOnClickListener(this);
        btnStudyService = (Button) findViewById(R.id.btnStudyService);
        btnStudyService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStudyIntent:StudyIntent();break;
            case R.id.btnStudyAdapter:StudyAdapter();break;
            case R.id.btnStudyView:StudyView();break;
            case R.id.btnStudyTDW:StudyTDW();break;
            case R.id.btnStudyNotification:StudyNotification();break;
            case R.id.btnStudyNotified:StudyNotified();break;
            case R.id.btnStudyFragment:StudyFragment();break;
            case R.id.btnStudyNewKnowledge:StudyNewKnowledge();break;
            case R.id.btnStudyService:StudyService();break;
            default:break;
        }
    }

    private void StudyService() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,ActivityService.class));
        startActivity(intent);
    }

    private void StudyIntent() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,StudyIntent.class));
        startActivity(intent);
    }
    private void StudyAdapter(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,StudyAdapter.class));
        startActivity(intent);
    }
    private void StudyView(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,StudyView.class));
        startActivity(intent);
    }
    private void StudyTDW(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,StudyTDW.class));
        startActivity(intent);
    }
    private void StudyNotification(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,ActivityNotification.class));
        startActivity(intent);
    }
    private void StudyNotified(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,ActivityMenu.class));
        startActivity(intent);
    }
    private void StudyFragment(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,StudyFragment.class));
        startActivity(intent);
    }
    private void StudyNewKnowledge(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,ActivityStudyNewKnowledge.class));
        startActivity(intent);
    }

}
