package com.example.houjie.studyapk.studyxml.bean;

/**
 * Created by Administrator on 2016/4/28.
 */
public class Teacher {
    private String name;
    private String major;
    private String position;
    public Teacher(){}

    public Teacher(String name, String major, String position) {
        this.name = name;
        this.major = major;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
