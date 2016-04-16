package com.example.houjie.studyapk.studytnewknowledge.recycler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studytnewknowledge.recycler.learnrecycler.HorizontalRecycler;
import com.example.houjie.studyapk.studytnewknowledge.recycler.learnrecycler.StagRecycler;
import com.example.houjie.studyapk.studytnewknowledge.recycler.testrecycler.TestRecycler;

public class ActivityRecycler extends AppCompatActivity {
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_knowledge_recycler);
        mButton1 = (Button) findViewById(R.id.open_herizontal_recycler);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityRecycler.this, HorizontalRecycler.class);
                 intent.putExtra("open","horizontal");
                startActivity(intent);
            }
        });
        mButton2 = (Button) findViewById(R.id.open_vertical_recycler);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityRecycler.this, HorizontalRecycler.class);
                intent.putExtra("open","vertical");
                startActivity(intent);
            }
        });
        mButton3 = (Button) findViewById(R.id.open_gradlayout_recycler);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityRecycler.this, HorizontalRecycler.class);
                intent.putExtra("open","gridlayout");
                startActivity(intent);
            }
        });
        mButton3 = (Button) findViewById(R.id.open_stag_recycler);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityRecycler.this, StagRecycler.class);
                startActivity(intent);
            }
        });
        mButton4 = (Button) findViewById(R.id.open_test_recycler);
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityRecycler.this, TestRecycler.class);
                startActivity(intent);
            }
        });
    }
}
