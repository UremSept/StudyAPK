package com.example.houjie.studyapk.studyadapter.dao;

/**
 * Created by houjie on 2016/4/7.
 */
public class People {
    private String name;
    private String autograph;
    private int image;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    private boolean checked;

    public People(String name, String autograph, int image, boolean checked) {
        this.name = name;
        this.autograph = autograph;
        this.image = image;
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
