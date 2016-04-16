package com.example.houjie.studyapk.studytnewknowledge.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyfragment.fragmentpager.FragmentPagerFour;
import com.example.houjie.studyapk.studyfragment.fragmentpager.FragmentPagerOne;
import com.example.houjie.studyapk.studyfragment.fragmentpager.FragmentPagerThree;
import com.example.houjie.studyapk.studyfragment.fragmentpager.FragmentPagerTwo;

import java.util.ArrayList;
import java.util.List;

public class ActivityTabFragment extends AppCompatActivity {
    private TabLayout tableLayout;
    private List<TabFragment> mList;
    private ViewPager mViewPager;
    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_knowledge_tab_fragment);
        tableLayout= (TabLayout) findViewById(R.id.studyTablayoutFragment);
        mViewPager = (ViewPager) findViewById(R.id.TabPager);
        mList = new ArrayList<>();
        mList.add(new TabFragment("第一个页面",new FragmentPagerOne()));
        mList.add(new TabFragment("第二个页面",new FragmentPagerTwo()));
        mList.add(new TabFragment("第三个页面",new FragmentPagerThree()));
        mList.add(new TabFragment("第四个页面",new FragmentPagerFour()));
        FragmentManager manager = getSupportFragmentManager();
        TabFragmentPagerAdapter adapter = new TabFragmentPagerAdapter(manager,mList);
        mViewPager.setAdapter(adapter);
        tableLayout.setupWithViewPager(mViewPager);
        one = tableLayout.getTabAt(0);
        two = tableLayout.getTabAt(1);
        three = tableLayout.getTabAt(2);
        four = tableLayout.getTabAt(3);
        one.setIcon(R.mipmap.a);
        two.setIcon(R.mipmap.bb);
        three.setIcon(R.mipmap.cc);
        four.setIcon(R.mipmap.dd);
        tableLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int count = 0;
                if(tab ==tableLayout.getTabAt(0)){
                    count = 0;
                }
                if(tab ==tableLayout.getTabAt(1)){
                    count = 1;
                }
                if(tab ==tableLayout.getTabAt(2)){
                    count = 2;
                }
                if(tab ==tableLayout.getTabAt(3)){
                    count = 3;
                }
                change(count);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void change(int pp){
        Toast.makeText(this,"ssdfsdf",Toast.LENGTH_SHORT).show();
        one.setIcon(R.mipmap.aa);
        two.setIcon(R.mipmap.bb);
        three.setIcon(R.mipmap.cc);
        four.setIcon(R.mipmap.dd);
        switch (pp){
            case 0: one.setIcon(R.mipmap.a);mViewPager.setCurrentItem(0,true);break;
            case 1:two.setIcon(R.mipmap.b);mViewPager.setCurrentItem(1,true);break;
            case 2:three.setIcon(R.mipmap.c);mViewPager.setCurrentItem(2,true);break;
            case 3:four.setIcon(R.mipmap.d);mViewPager.setCurrentItem(3,true);break;
        }
    }
}
