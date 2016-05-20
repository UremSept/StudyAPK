package com.example.houjie.studyapk.studyview;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyview.custom.ActivityCustomView;
import com.example.houjie.studyapk.studyview.spinner.ViewSpinner;
import com.example.houjie.studyapk.studyview.view.Login;
import com.example.houjie.studyapk.studyview.view.PickerSwitcher;
import com.example.houjie.studyapk.studyview.view.RichText;
import com.example.houjie.studyapk.studyview.viewpager.ActivityViewPager;
import com.example.houjie.studyapk.studyview.viewpager.ActivityViewPagerLoop;
import com.example.houjie.studyapk.studyview.viewscroll.ViewScroll;
import com.example.houjie.studyapk.studyview.webview.ActivityWebView;
import com.example.houjie.studyapk.studyview.webview.ActivityWebViewLocal;

public class StudyView extends AppCompatActivity implements View.OnClickListener{
    private Button btnRichText;
    private  Button btnPickerSwitcher;
    private Button btnLogin;
    private Button btnViewPager;
    private Button btnScroll;
    private Button btnSpinner;
    private Button btnViewPagerLoop;
    private Button btnViewWeb;
    private Button btnViewWebLocal;
    private Button btnViewCustom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_view);
        init();
    }
    private void init() {
        btnRichText = (Button) findViewById(R.id.btnRichText);
        btnRichText.setOnClickListener(this);
        btnPickerSwitcher = (Button) findViewById(R.id.btnPickerSwitcher);
        btnPickerSwitcher.setOnClickListener(this);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        btnViewPager = (Button) findViewById(R.id.btnViewPager);
        btnViewPager.setOnClickListener(this);
        btnViewPagerLoop = (Button) findViewById(R.id.btnViewPagerLoop);
        btnViewPagerLoop.setOnClickListener(this);
        btnScroll = (Button) findViewById(R.id.btnViewScroll);
        btnScroll.setOnClickListener(this);
        btnSpinner = (Button) findViewById(R.id.btnViewSpinner);
        btnSpinner.setOnClickListener(this);
        btnViewWeb = (Button) findViewById(R.id.btnViewWeb);
        btnViewWeb.setOnClickListener(this);
        btnViewWebLocal = (Button) findViewById(R.id.btnViewWebLocal);
        btnViewWebLocal.setOnClickListener(this);
        btnViewCustom = (Button) findViewById(R.id.btnViewCustom);
        btnViewCustom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRichText:RichText();break;
            case R.id.btnPickerSwitcher:PikerSwitcher();break;
            case R.id.btnLogin:Login();break;
            case R.id.btnViewPager:TestViewPager();break;
            case R.id.btnViewScroll:TestViewScroll();break;
            case R.id.btnViewSpinner:TestViewSpinner();break;
            case R.id.btnViewPagerLoop:ViewPagerLoop();break;
            case R.id.btnViewWeb:ViewWeb();break;
            case R.id.btnViewWebLocal:ViewWebLocal();break;
            case R.id.btnViewCustom:ViewCustom();break;
            default:break;
        }
    }

    private void ViewCustom() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyView.this,ActivityCustomView.class));
        startActivity(intent);
    }

    private void ViewWebLocal() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyView.this,ActivityWebViewLocal.class));
        startActivity(intent);
    }

    private void ViewWeb() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyView.this,ActivityWebView.class));
        startActivity(intent);
    }

    private void ViewPagerLoop() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyView.this,ActivityViewPagerLoop.class));
        startActivity(intent);
    }

    private void TestViewSpinner() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyView.this,ViewSpinner.class));
        startActivity(intent);
    }

    private  void RichText(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyView.this,RichText.class));
        startActivity(intent);
    }
    private  void PikerSwitcher(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyView.this,PickerSwitcher.class));
        startActivity(intent);
    }
    private  void Login(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyView.this,Login.class));
        startActivity(intent);
    }
    private  void TestViewPager(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyView.this,ActivityViewPager.class));
        startActivity(intent);
    }
    private  void TestViewScroll(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(StudyView.this,ViewScroll.class));
        startActivity(intent);
    }
}
