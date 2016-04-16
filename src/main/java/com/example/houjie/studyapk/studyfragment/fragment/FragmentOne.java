package com.example.houjie.studyapk.studyfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.houjie.studyapk.R;

/**
 * Created by houjie on 2016/4/10.
 */
public class FragmentOne extends Fragment {
    private ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.layout_only_imageview,null);
        imageView = (ImageView) view.findViewById(R.id.OnlyImageView);
        imageView.setImageResource(R.mipmap.helloword);
        return view;
    }
}
