package com.example.houjie.studyapk.studyxml.json;
import com.example.houjie.studyapk.studyxml.bean.Clazz;
import com.example.houjie.studyapk.studyxml.bean.Student;
import com.example.houjie.studyapk.studyxml.bean.Teacher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/28.
 */
public class FromJson {
    public Clazz json(String string){
        Clazz clazz = new Clazz();
        try {
            JSONObject jsonObject = new JSONObject(string);
            clazz.setClazzName(jsonObject.getString("clazzName"));
            clazz.setClazzNum(jsonObject.getString("clazzNum"));
            Teacher teacher = new Teacher();
            JSONObject object = jsonObject.getJSONObject("teacher");
            teacher.setName(object.getString("name"));
            teacher.setMajor(object.getString("major"));
            teacher.setPosition(object.getString("position"));
            clazz.setTeacher(teacher);
            List<Student>studentList = new ArrayList<>();
            JSONArray jsonArray = jsonObject.getJSONArray("student");
            for (int i = 0; i <jsonArray.length() ; i++) {
                Student s = new Student();
                JSONObject student = jsonArray.getJSONObject(i);
                s.setName(student.getString("name"));
                s.setAge(student.getString("age"));
                s.setSex(student.getString("sex"));
                studentList.add(s);
            }
            clazz.setStudents(studentList);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return clazz;
    }
}
