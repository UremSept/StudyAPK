package com.example.houjie.studyapk.studyxml.json;

import android.util.Log;

import com.example.houjie.studyapk.studyxml.bean.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Administrator on 2016/4/28.
 */
public class ToJson {
    public String createJson(Clazz clazz){
        String clazztoSting = null;
        Teacher teacher = clazz.getTeacher();
        List<Student> list = clazz.getStudents();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("clazzName",clazz.getClazzName());
            jsonObject.put("clazzNum",clazz.getClazzNum());
            JSONObject object = new JSONObject();
            object.put("name",teacher.getName());
            object.put("major",teacher.getMajor());
            object.put("position",teacher.getPosition());
            jsonObject.put("teacher",object);
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i <list.size() ; i++) {
                JSONObject student = new JSONObject();
                student.put("name",list.get(i).getName());
                student.put("age",list.get(i).getAge());
                student.put("sex",list.get(i).getSex());
                jsonArray.put(student);
            }
            jsonObject.put("student",jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("toJson",jsonObject.toString());
        clazztoSting = jsonObject.toString();
        return clazztoSting;
    }
}
