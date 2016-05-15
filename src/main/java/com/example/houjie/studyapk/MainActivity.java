package com.example.houjie.studyapk;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.studyanimation.ActivityAnimation;
import com.example.houjie.studyapk.studyhttp.ActivityStudyHttp;
import com.example.houjie.studyapk.studymedia.ActivityMedia;
import com.example.houjie.studyapk.studyuithread.ActivityUIThread;
import com.example.houjie.studyapk.practicedownload.ActivityDownload;
import com.example.houjie.studyapk.studyadapter.StudyAdapter;
import com.example.houjie.studyapk.studydatastore.ActivityDataStore;
import com.example.houjie.studyapk.studyfragment.StudyFragment;
import com.example.houjie.studyapk.studyintent.StudyIntent;
import com.example.houjie.studyapk.studynotification.ActivityNotification;
import com.example.houjie.studyapk.studymenu.ActivityMenu;
import com.example.houjie.studyapk.studyreceiver.ActivityReceiver;
import com.example.houjie.studyapk.studyservice.ActivityService;
import com.example.houjie.studyapk.studytnewknowledge.ActivityStudyNewKnowledge;
import com.example.houjie.studyapk.studytocastdialogwindow.StudyTDW;
import com.example.houjie.studyapk.studyview.StudyView;
import com.example.houjie.studyapk.studyxml.ActivityXML;

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
    private Button btnbtnStudyReceiver;
    private Button btnPracticedDownload;
    private Button btnStudyUIThread;
    private Button btnStudyDataStore;
    private Button btnStudyXML;
    private Button btnStudyHttp;
    private Button btnStudyAnimation;
    private Button btnStudyMedia;

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
        btnbtnStudyReceiver = (Button) findViewById(R.id.btnStudyReceiver);
        btnbtnStudyReceiver.setOnClickListener(this);
        btnPracticedDownload = (Button) findViewById(R.id.btnPracticedDownload);
        btnPracticedDownload.setOnClickListener(this);
        btnStudyUIThread = (Button) findViewById(R.id.btnStudyUIThread);
        btnStudyUIThread.setOnClickListener(this);
        btnStudyDataStore = (Button) findViewById(R.id.btnStudyDataStore);
        btnStudyDataStore.setOnClickListener(this);
        btnStudyXML = (Button) findViewById(R.id.btnStudyXML);
        btnStudyXML.setOnClickListener(this);
        btnStudyHttp = (Button) findViewById(R.id.btnStudyHttp);
        btnStudyHttp.setOnClickListener(this);
        btnStudyAnimation = (Button) findViewById(R.id.btnStudyAnimation);
        btnStudyAnimation.setOnClickListener(this);
        btnStudyMedia = (Button) findViewById(R.id.btnStudyMedia);
        btnStudyMedia.setOnClickListener(this);
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
            case R.id.btnStudyReceiver:StudyReceiver();break;
            case R.id.btnPracticedDownload:PracticedDownload();break;
            case R.id.btnStudyUIThread:StudyUIThread();break;
            case R.id.btnStudyDataStore:StudyDataStore();break;
            case R.id.btnStudyXML:StudyXML();break;
            case R.id.btnStudyHttp:StudyHttp();break;
            case R.id.btnStudyAnimation:StudyAnimation();break;
            case R.id.btnStudyMedia:StudyMedia();break;
            default:break;
        }
    }

    private void StudyMedia() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,ActivityMedia.class));
        startActivity(intent);
    }

    private void StudyAnimation() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,ActivityAnimation.class));
        startActivity(intent);
    }

    private void StudyHttp() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,ActivityStudyHttp.class));
        startActivity(intent);
    }

    private void StudyXML() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,ActivityXML.class));
        startActivity(intent);
    }

    private void StudyDataStore() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,ActivityDataStore.class));
        startActivity(intent);
    }

    private void StudyUIThread() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,ActivityUIThread.class));
        startActivity(intent);
    }

    private void PracticedDownload() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,ActivityDownload.class));
        startActivity(intent);
    }

    private void StudyReceiver() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainActivity.this,ActivityReceiver.class));
        startActivity(intent);
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
