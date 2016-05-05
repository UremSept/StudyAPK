package com.example.houjie.studyapk.studyview.viewpager;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.houjie.studyapk.R;

public class ActivityViewPagerLoop extends AppCompatActivity {
    private ViewPager viewPager;
    private ViewGroup viewGroup;
    private int []image ={R.mipmap.picture1,R.mipmap.picture2,R.mipmap.picture3,R.mipmap.picture4,
            R.mipmap.picture5};
    private ImageView [] imageViews;
    private ImageView [] tips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_loop);
        viewGroup = (ViewGroup) findViewById(R.id.viewgroup);
        viewPager = (ViewPager) findViewById(R.id.viewPagerLoop);
        getImageView();
        getTips();

        ViewPagerLoopAdapter viewPagerLoopAdapter =new ViewPagerLoopAdapter(imageViews);
        viewPager.setAdapter(viewPagerLoopAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                itemSelect(position % image.length);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(image.length*100);

        testHander.sendEmptyMessageDelayed(1,5000);
    }
    private Handler testHander = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int index  =viewPager.getCurrentItem();
            viewPager.setCurrentItem(index+1);
            testHander.sendEmptyMessageDelayed(1,5000);
        }
    };
    //把图片数组添加进ImageView
    private void getImageView(){
        imageViews = new ImageView[image.length];
        for (int i=0;i<imageViews.length;i++){
            ImageView imageView =new ImageView(this);
            imageView.setBackgroundResource(image[i]);
            imageViews[i]=imageView;
        }
    }
    //圆点数组
    private void getTips(){
        tips = new ImageView[image.length];
        for(int i=0;i<tips.length;i++){
            ImageView imageView = new ImageView(this);
            tips[i] =imageView;
            if(i==0){
                tips[i].setBackgroundResource(R.mipmap.item08);
            }else {
                tips[i].setBackgroundResource(R.mipmap.item07);
            }
            LinearLayout.LayoutParams layoutParams =new LinearLayout.LayoutParams(50,50);
            layoutParams.rightMargin =5;
            layoutParams.leftMargin =5;
            viewGroup.addView(tips[i],layoutParams);

        }
    }
    private void itemSelect(int item){
        for (int i = 0; i <tips.length ; i++) {
            if (item == i){
                tips[i].setBackgroundResource(R.mipmap.item08);
            }else {
                tips[i].setBackgroundResource(R.mipmap.item07);
            }
        }
    }
}
