package com.example.houjie.studyapk.studyxml.factory;

import android.util.Log;


import com.example.houjie.studyapk.studyxml.bean.Student;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/28.
 */
public class PullSutdent {
    public void pull(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(inputStream,"utf-8");
        List<Student>studentList = null;
        Student student = null;
        String tagName = null;
        //判断读到的是标签还是元素
        int event = parser.getEventType();
        while (event != XmlPullParser.END_DOCUMENT){
            if (event == XmlPullParser.START_DOCUMENT){
                Log.d("Tag","文档开始");
                studentList = new ArrayList<>();
            }else if (event == XmlPullParser.START_TAG){
                if ("student".equals(parser.getName())){
                    student.setMajor(parser.getAttributeValue(null,"major"));
                    student.setName(parser.getAttributeValue(null,"num"));
                }
                tagName = parser.getName();
            }else if (event == XmlPullParser.END_TAG){
                if ("student".equals(parser.getName())){
                    studentList.add(student);
                }
                tagName = null;
            }else if(event == XmlPullParser.TEXT){
                if ("name".equals(tagName)){
                    student.setName(parser.getText());
                }else if("age".equals(tagName)){
                    student.setAge(parser.getText());
                }else if ("sex".equals(tagName)){
                    student.setSex(parser.getText());
                }
            }
            event = parser.next();
        }

    }
}
