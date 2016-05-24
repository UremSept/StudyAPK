package com.example.houjie.studyapk.studytnewknowledge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studytnewknowledge.new5_0.ActivityNewKnowledge5_0;
import com.example.houjie.studyapk.studytnewknowledge.recycler.ActivityRecycler;
import com.example.houjie.studyapk.studytnewknowledge.tablayout.ActivityTabFragment;
import com.example.houjie.studyapk.studytnewknowledge.tablayout.StudyTabLayout;
import com.example.houjie.studyapk.studytnewknowledge.viewcard.ActivityViewCard;

public class ActivityStudyNewKnowledge extends AppCompatActivity {
    private Button mButton;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button studyNewKnowledge5_0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_new_knowledge);
        mButton = (Button) findViewById(R.id.studyTablayoutBtn1);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStudyNewKnowledge.this, StudyTabLayout.class);
                startActivity(intent);
            }
        });
        mButton1 = (Button) findViewById(R.id.studyTablayoutBtn2);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStudyNewKnowledge.this, ActivityTabFragment.class);
                startActivity(intent);
            }
        });
        mButton2 = (Button) findViewById(R.id.studyViewCard);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStudyNewKnowledge.this, ActivityViewCard.class);
                startActivity(intent);
            }
        });
        mButton3 = (Button) findViewById(R.id.studyViewRecycler);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStudyNewKnowledge.this, ActivityRecycler.class);
                startActivity(intent);
            }
        });
        studyNewKnowledge5_0 = (Button) findViewById(R.id.studyNewKnowledge5_0);
        studyNewKnowledge5_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStudyNewKnowledge.this, ActivityNewKnowledge5_0.class);
                startActivity(intent);
            }
        });
    }
}
