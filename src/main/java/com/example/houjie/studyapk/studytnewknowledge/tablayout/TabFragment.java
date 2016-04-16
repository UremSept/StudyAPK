package com.example.houjie.studyapk.studytnewknowledge.tablayout;

import android.support.v4.app.Fragment;

/**
 * Created by houjie on 2016/4/13.
 */
public class TabFragment {
    private  String title;
    private Fragment fragment;

    public TabFragment(String title, Fragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
