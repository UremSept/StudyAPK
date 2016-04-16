package com.example.houjie.studyapk.studytnewknowledge.recycler.bean;

import android.media.Image;

/**
 * Created by houjie on 2016/4/14.
 */
public class Student {
    private String name;
    private String text;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Student(String name, String text, int image) {

        this.name = name;
        this.text = text;
        this.image = image;
    }
}
