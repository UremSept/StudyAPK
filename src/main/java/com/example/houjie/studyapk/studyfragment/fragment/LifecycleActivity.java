package com.example.houjie.studyapk.studyfragment.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;

public class LifecycleActivity extends AppCompatActivity {
    private final String TAG ="LifecycleActivity";
    private FragmentManager fragmentManager;
    private Button button1;
    private Button button2;
    private LifecycleFragment lifecycleFragment;
    private int page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_lifecycle);
        Log.i(TAG,"Activity onCreate");
        button1= (Button) findViewById(R.id.FragmentBtnClear);

        button2= (Button) findViewById(R.id.FragmentBtnCreate);

        fragmentManager=getSupportFragmentManager();
        lifecycleFragment =(LifecycleFragment)fragmentManager.findFragmentById(R.id.Fragmentfragment);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.remove(lifecycleFragment);
                transaction.commit();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"Activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"Activity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"Activity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"Activity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Activity onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"Activity onRestart");
    }
}
