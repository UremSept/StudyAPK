package com.example.houjie.studyapk.studydatastore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studydatastore.database.ActivityDatabase;
import com.example.houjie.studyapk.studydatastore.filesystem.ActivityDataStoreFileSystem;
import com.example.houjie.studyapk.studydatastore.sharedpreference.ActivitySharedPreference;

public class ActivityDataStore extends AppCompatActivity implements View.OnClickListener {
    private Button buttonSharedPreference;
    private Button buttonFileSystem;

    private Button buttonStoreDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_data_store);
        init();
    }
    private void init() {
        buttonSharedPreference = (Button) findViewById(R.id.BtnStudyDataStoreSharedPreference);
        buttonSharedPreference.setOnClickListener(this);
        buttonFileSystem = (Button) findViewById(R.id.BtnStudyDataStoreFileSystem);
        buttonFileSystem.setOnClickListener(this);
        buttonStoreDataBase = (Button) findViewById(R.id.BtnStudyDataStoreDataBase);
        buttonStoreDataBase.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BtnStudyDataStoreSharedPreference:OpenSharedPreference();break;
            case R.id.BtnStudyDataStoreFileSystem:OpenFileSystem();break;
            case R.id.BtnStudyDataStoreDataBase:OpenDataBase();break;
        }
    }

    private void OpenDataBase() {
        Intent intent = new Intent(ActivityDataStore.this, ActivityDatabase.class);
        startActivity(intent);
    }

    private void OpenFileSystem() {
        Intent intent = new Intent(ActivityDataStore.this, ActivityDataStoreFileSystem.class);
        startActivity(intent);
    }

    private void OpenSharedPreference() {
        Intent intent = new Intent(ActivityDataStore.this, ActivitySharedPreference.class);
        startActivity(intent);
    }
}
