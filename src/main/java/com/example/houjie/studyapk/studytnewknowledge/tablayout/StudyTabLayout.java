package com.example.houjie.studyapk.studytnewknowledge.tablayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import com.example.houjie.studyapk.R;

public class StudyTabLayout extends AppCompatActivity {
    private TabLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_knowledge_tablayout);
        tableLayout= (TabLayout) findViewById(R.id.studyTablayout);
        tableLayout.addTab(tableLayout.newTab().setText("第一个"));
        tableLayout.addTab(tableLayout.newTab().setText("第二个"));
        tableLayout.addTab(tableLayout.newTab().setText("第三个"));
        tableLayout.addTab(tableLayout.newTab().setText("第四个"));


    }
}
