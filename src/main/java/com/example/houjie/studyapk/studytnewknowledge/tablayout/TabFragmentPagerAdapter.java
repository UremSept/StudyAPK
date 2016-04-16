package com.example.houjie.studyapk.studytnewknowledge.tablayout;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by houjie on 2016/4/10.
 */
public class TabFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<TabFragment> list;

    public TabFragmentPagerAdapter(FragmentManager fm, List<TabFragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position).getFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getTitle();
    }
}
