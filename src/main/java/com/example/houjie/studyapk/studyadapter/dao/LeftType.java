package com.example.houjie.studyapk.studyadapter.dao;


import com.example.houjie.studyapk.studyadapter.adapter.ChatAdapter;
import com.example.houjie.studyapk.studyadapter.bean.Type;

/**
 * Created by houjie on 2016/4/8.
 */
public class LeftType implements Type {
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public LeftType(int image, String mText) {

        this.image = image;
        this.mText = mText;
    }

    private String mText;
    @Override
    public int getType() {
        return ChatAdapter.LEFTTYPE;
    }
}
