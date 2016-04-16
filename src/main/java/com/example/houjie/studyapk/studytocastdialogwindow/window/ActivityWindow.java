package com.example.houjie.studyapk.studytocastdialogwindow.window;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.houjie.studyapk.R;

public class ActivityWindow extends AppCompatActivity implements View.OnClickListener{
    private Button button1;
    private PopupWindow mPopupWindow;
    private  View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdw_window);
        init();
    }

    private void init() {
        button1 = (Button) findViewById(R.id.btn1);
        button1.setOnClickListener(ActivityWindow.this);
        view = LayoutInflater.from(ActivityWindow.this)
                .inflate(R.layout.layout_tdw_window_pop,null);
        mPopupWindow = new PopupWindow();
        mPopupWindow.setContentView(view);
        mPopupWindow.setWidth(FrameLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setHeight(FrameLayout.LayoutParams.WRAP_CONTENT);
        TextView textView1 = (TextView) view.findViewById(R.id.TextView1);
        textView1.setOnClickListener(this);
        TextView textView2 = (TextView)view.findViewById(R.id.TextView2);
        textView2.setOnClickListener(this);
        TextView textView3 = (TextView) view.findViewById(R.id.TextView3);
        textView3.setOnClickListener(this);
        TextView textView4 = (TextView) view.findViewById(R.id.TextView4);
        textView4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:button1Click();
                break;
            case R.id.TextView1:
                Toast.makeText(ActivityWindow.this,
                    "文本1",Toast.LENGTH_LONG).show();
                break;
            case R.id.TextView2:Toast.makeText(ActivityWindow.this,
                    "文本2",Toast.LENGTH_LONG).show();
                break;
            case R.id.TextView3:
                Toast.makeText(ActivityWindow.this,
                        "文本3",Toast.LENGTH_LONG).show();
                break;
            case R.id.TextView4:
                mPopupWindow.dismiss();
                Toast.makeText(ActivityWindow.this,
                        "取消",Toast.LENGTH_LONG).show();
                break;

            default:break;
        }
    }
    private void button1Click(){
        mPopupWindow.showAsDropDown(button1);
    }
}
