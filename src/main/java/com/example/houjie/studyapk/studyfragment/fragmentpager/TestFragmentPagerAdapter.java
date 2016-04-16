package com.example.houjie.studyapk.studyfragment.fragmentpager;


import android.content.Context;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import java.util.List;

/**
 * Created by houjie on 2016/4/10.
 */
public class TestFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> list;
    private Context intent;

    public TestFragmentPagerAdapter(FragmentManager fm, List<Fragment> list, Context intent) {
        super(fm);
        this.list = list;
        this.intent = intent;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }
}
