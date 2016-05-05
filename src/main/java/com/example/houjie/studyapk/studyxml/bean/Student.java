package com.example.houjie.studyapk.studyxml.bean;

/**
 * Created by Administrator on 2016/4/27.
 */
public class Student {
    private String major;
    private String num;
    private String name;
    private String age;
    private String sex;

    public Student(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public Student(){

    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "major='" + major + '\'' +
                ", num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
