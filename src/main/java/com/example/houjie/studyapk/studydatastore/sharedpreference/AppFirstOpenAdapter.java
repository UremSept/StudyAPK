package com.example.houjie.studyapk.studydatastore.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by houjie on 2016/4/23.
 */
public class AppFirstOpenAdapter extends PagerAdapter{

    private ImageView[] imageViews;
    private Context context;

    public AppFirstOpenAdapter(ImageView[] imageViews, Context context) {
        this.imageViews = imageViews;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageViews.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(View container, int position) {
        ((ViewPager)container).addView(imageViews[position]);
        if(position==imageViews.length-1){
            imageViews[position].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,ActivitySharedPreference.class);
                    context.startActivity(intent);
                }
            });
        }
        return imageViews[position];
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager)container).removeView(imageViews[position]);
    }
}
