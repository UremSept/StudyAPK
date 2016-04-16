package com.example.houjie.studyapk.studyview.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.houjie.studyapk.R;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private Button login;
    private TextView noLogin;
    private TextView newPeople;
    private EditText userName;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_login);
        init();
    }
    private void init(){
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        noLogin = (TextView) findViewById(R.id.noLogin);
        noLogin.setOnClickListener(this);
        newPeople = (TextView) findViewById(R.id.newPeople);
        newPeople.setOnClickListener(this);
        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    @Override
    public void onClick(View v) {
        System.out.print("进入了");
        switch (v.getId()){
            case R.id.login:login();break;
            case R.id.noLogin: noLogin();break;
            case R.id.newPeople:newPeople();break;
        }
    }
    private void login(){
        Intent intent =new Intent(Login.this,LoginFinsh.class);
        String userNameStr = userName.getText().toString();
        String passwordStr = password.getText().toString();
        intent.putExtra("username",userNameStr);
        intent.putExtra("password",passwordStr);
        startActivity(intent);
    }
    private void noLogin(){
        Intent intent =new Intent(Login.this,ForgetPassword.class);
        startActivity(intent);
    }
    private void newPeople(){
        Intent intent =new Intent(Login.this,Register.class);
        startActivity(intent);
    }
}
