package com.example.houjie.studyapk.studyview.viewpager;

import android.support.v4.view.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.houjie.studyapk.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityViewPager extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<ImageView> list;
    private  int []image = {R.mipmap.helloword,R.mipmap.ic_launcher};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mViewPager =(ViewPager)findViewById(R.id.ViewPagerTest);
        list =  new ArrayList<>();
        for(int i =0;i<image.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image[i]);
            list.add(imageView);
        }
        android.support.v4.view.PagerAdapter pagerAdapter = new PagerAdapter(list,ActivityViewPager.this);
        mViewPager.setAdapter(pagerAdapter);
    }
}
