package com.example.houjie.studyapk.studyview.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.houjie.studyapk.R;

/**
 * Created by houjie on 2016/3/27.
 */
public class LoginFinsh extends AppCompatActivity{
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_login_finsh);
        textView = (TextView) findViewById(R.id.loginfish);
        Intent intent =getIntent();
        String userNameStr = intent.getStringExtra("username");
        String passwordStr = intent.getStringExtra("password");
        textView.setText("用户名："+userNameStr+"\n密码："+passwordStr);
        Intent inten =new Intent(LoginFinsh.this,ViewSeekBar.class);
        startActivity(inten);
    }
}
