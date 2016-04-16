package com.example.houjie.studyapk.studyfragment.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.houjie.studyapk.R;

public class FragmentActivityTest extends AppCompatActivity {
    private Button button1,button2;
    private FragmentManager manager;
    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_two);
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //frameLayout = (FrameLayout) findViewById(R.id.fragmentlayout);
        fragmentTwo = new FragmentTwo();
        fragmentOne = new FragmentOne();
        transaction.add(R.id.fragmentlayout,fragmentTwo).commit();
        button1= (Button) findViewById(R.id.FragmentBtnUp);
        button2= (Button) findViewById(R.id.FragmentBtnNext);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = manager.beginTransaction();
                //必须写在此处，因为它只执行一次就会销毁
                transaction.replace(R.id.fragmentlayout,fragmentTwo);
                transaction.commit();
                //Toast.makeText(FragmentActivityTest.this, "88888888", Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = manager.beginTransaction();
                //必须写在此处，因为它只执行一次就会销毁
                transaction.replace(R.id.fragmentlayout,fragmentOne);
                transaction.commit();
            }
        });
    }
}
