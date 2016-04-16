package com.example.houjie.studyapk.studyintent.intent;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by houjie on 2016/3/19.
 */
public class Student implements Parcelable {
    private String name;
    private String age;
    private String sex;
    public Student(){

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
    protected Student(Parcel in) {
        name = in.readString();
        age = in.readString();
        sex = in.readString();
    }
    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };





    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(age);
        dest.writeString(sex);
    }
}
