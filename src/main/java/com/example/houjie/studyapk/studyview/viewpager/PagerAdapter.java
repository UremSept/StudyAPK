package com.example.houjie.studyapk.studyview.viewpager;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by houjie on 2016/4/10.
 */
public class PagerAdapter extends android.support.v4.view.PagerAdapter {
    private List<ImageView> list;
    private Context intent;
    public PagerAdapter(List<ImageView> list,Context mintment) {
        this.list = list;
        this.intent =mintment;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==object;
    }
}
