package com.example.houjie.studyapk.studyadapter.dao;


import com.example.houjie.studyapk.studyadapter.adapter.ChatAdapter;
import com.example.houjie.studyapk.studyadapter.bean.Type;

/**
 * Created by houjie on 2016/4/8.
 */
public class RightType implements Type {
    private int mImage;
    private String mText;

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public RightType(int mImage, String mText) {

        this.mImage = mImage;
        this.mText = mText;
    }

    @Override
    public int getType() {
        return ChatAdapter.RIGHTTYPE;
    }
}
