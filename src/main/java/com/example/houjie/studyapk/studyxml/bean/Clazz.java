package com.example.houjie.studyapk.studyxml.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/4/28.
 */
public class Clazz {
    private String clazzName;
    private String clazzNum;
    private Teacher teacher;
    private List<Student> students;

    public Clazz(){}

    public Clazz(String clazzName, String clazzNum, Teacher teacher, List<Student> students) {
        this.clazzName = clazzName;
        this.clazzNum = clazzNum;
        this.teacher = teacher;
        this.students = students;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getClazzNum() {
        return clazzNum;
    }

    public void setClazzNum(String clazzNum) {
        this.clazzNum = clazzNum;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "clazzName='" + clazzName + '\'' +
                ", clazzNum='" + clazzNum + '\'' +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }
}
