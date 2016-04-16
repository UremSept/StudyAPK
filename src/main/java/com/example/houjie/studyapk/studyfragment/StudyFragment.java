package com.example.houjie.studyapk.studyfragment;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyfragment.fragment.FragmentActivityTest;
import com.example.houjie.studyapk.studyfragment.fragment.LifecycleActivity;
import com.example.houjie.studyapk.studyfragment.fragmentpager.ActivityFragmentPager;

public class StudyFragment extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_fragment);
        button1 = (Button) findViewById(R.id.FragmentStudy1);
        button2 = (Button) findViewById(R.id.FragmentStudy2);
        button3 = (Button) findViewById(R.id.FragmentStudy3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(StudyFragment.this,LifecycleActivity.class));
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(StudyFragment.this,FragmentActivityTest.class));
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(StudyFragment.this,ActivityFragmentPager.class));
                startActivity(intent);
            }
        });

    }
}
