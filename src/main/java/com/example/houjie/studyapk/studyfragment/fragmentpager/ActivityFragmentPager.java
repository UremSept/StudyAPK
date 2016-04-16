package com.example.houjie.studyapk.studyfragment.fragmentpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.houjie.studyapk.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityFragmentPager extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{
    private ViewPager mViewPager;
    private List<Fragment> list;
    private ImageButton button1,button2,button3,button4;
    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_pager);
        mViewPager =(ViewPager)findViewById(R.id.ViewFragmentPagerTest);
        list =  new ArrayList<>();
        list.add(new FragmentPagerOne());
        list.add(new FragmentPagerTwo());
        list.add(new FragmentPagerThree());
        list.add(new FragmentPagerFour());
        manager = getSupportFragmentManager();
        TestFragmentPagerAdapter testFragmentPagerAdapter =new TestFragmentPagerAdapter(manager,list,this);
        mViewPager.setOnPageChangeListener(this);
        mViewPager.setAdapter(testFragmentPagerAdapter);

        init();
    }
    private void init() {
        button1= (ImageButton) findViewById(R.id.FragmentPagerBtn1);
        button1.setOnClickListener(this);
        button2= (ImageButton) findViewById(R.id.FragmentPagerBtn2);
        button2.setOnClickListener(this);
        button3= (ImageButton) findViewById(R.id.FragmentPagerBtn3);
        button3.setOnClickListener(this);
        button4 = (ImageButton) findViewById(R.id.FragmentPagerBtn4);
        button4.setOnClickListener(this);
        button1.setImageResource(R.mipmap.a);
        button2.setImageResource(R.mipmap.bb);
        button3.setImageResource(R.mipmap.cc);
        button4.setImageResource(R.mipmap.dd);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.FragmentPagerBtn1:Fragment1();break;
            case R.id.FragmentPagerBtn2:Fragment2();break;
            case R.id.FragmentPagerBtn3:Fragment3();break;
            case R.id.FragmentPagerBtn4:Fragment4();break;
        }
    }

    private void Fragment1() {
        mViewPager.setCurrentItem(0,true);
    }
    private void Fragment2() {
        mViewPager.setCurrentItem(1,true);
    }
    private void Fragment3() {
        mViewPager.setCurrentItem(2,true);
    }
    private void Fragment4() {
        mViewPager.setCurrentItem(3,true);
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        change(position);
    }

    @Override
    public void onPageSelected(int position) {

        change(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
//        change(state);
    }
    private void change(int pp){
        Toast.makeText(this,"ssdfsdf",Toast.LENGTH_SHORT).show();
        button1.setImageResource(R.mipmap.aa);
        button2.setImageResource(R.mipmap.bb);
        button3.setImageResource(R.mipmap.cc);
        button4.setImageResource(R.mipmap.dd);
        switch (pp){
            case 0: button1.setImageResource(R.mipmap.a);break;
            case 1:button2.setImageResource(R.mipmap.b);break;
            case 2:button3.setImageResource(R.mipmap.c);;break;
            case 3:button4.setImageResource(R.mipmap.d);;break;
        }
    }
}
