package com.example.houjie.studyapk.studydatastore.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houjie on 2016/4/24.
 */
public class StudentsDatabase {

    private SQLiteDatabase db;

    public StudentsDatabase(SQLiteDatabase db){
        this.db=db;
    }

    public void update(Student student){
        db.execSQL("update students set age ='" +student.getAge()+"' where name = '"+student.getName()+"'");
    }


    public void delete(Student student){
        db.execSQL("delete from students where name = '"+student.getName()+"'");
    }

    public List<Student> query(){
        List <Student> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from students ",null);
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String sex = cursor.getString(cursor.getColumnIndex("sex"));
            String age =cursor.getString(cursor.getColumnIndex("age"));
            Student student = new Student(name,sex,age);
            list.add(student);
        }
        Log.i("查询成功","==========");
        return list;
    }

    public Cursor cQuery(){
        Cursor cursor = db.rawQuery("select * from students ",null);
        return cursor;
    }

    public void add(Student student){
        db.execSQL("insert into students (name,sex,age) values(?,?,?)",new Object[]{
                student.getName(),student.getSex(),student.getAge()});
    }
}
