package com.example.houjie.studyapk.studyview.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.houjie.studyapk.R;

import java.util.Calendar;

public class PickerSwitcher extends AppCompatActivity implements ViewSwitcher.ViewFactory{
    private DatePicker date;
    private ImageButton mImageButton;
    private  int i = 0;
    private TextSwitcher mTextSwitcher;
    private TextView textView;
    private ImageSwitcher imageSwitcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_picker_switcher);
        textView= (TextView) findViewById(R.id.SwitcherText1);
        mImageButton = (ImageButton) findViewById(R.id.imageButton);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(this);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                i++;
//                mTextSwitcher.setText(i+"");
//                textView.setText(i+"");
                imageSwitcher.setImageResource(R.mipmap.helloword);
            }
        });
        mTextSwitcher = (TextSwitcher) findViewById(R.id.text_switch);
        //mTextSwitcher.setFactory(this);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int monthOfYear = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        date= (DatePicker) findViewById(R.id.date);
        date.init(year, monthOfYear, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(PickerSwitcher.this,""+year+"年"+(monthOfYear+1)+"月"+dayOfMonth+"日",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public View makeView() {
//        TextView textView = new TextView(this);
//        textView.setText(i+"");
//        return textView;
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
        imageView.setImageResource(R.mipmap.ic_launcher);
        return imageView;
    }
}
