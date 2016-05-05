package com.example.houjie.studyapk.studyxml.factory;

import android.util.Log;


import com.example.houjie.studyapk.studyxml.bean.Student;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/28.
 */
public class MySAXHandler extends DefaultHandler{
    private List<Student> studentList;
    private Student student;
    private String tagName;
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        Log.d("Tag","开始读取文档");
        studentList = new ArrayList<>();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        Log.d("Tag","结束读取文档");
        for (Student s:studentList) {
            Log.d("student",s.toString());
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        Log.d("Tag","读到的开始标签"+qName);
        if ("student".equals(qName)){
            student = new Student();
            student.setMajor(attributes.getValue("major"));
            student.setNum(attributes.getValue("num"));
        }
        tagName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        Log.d("Tag","读到的结束标签"+qName);
        if ("student".equals(qName)){
            studentList.add(student);
        }
        tagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        super.characters(ch, start, length);
        String value = new String(ch,start,length);
        Log.d("Tag","读到的元素的值"+value);
        if ("name".equals(tagName)){
            student.setName(value);
        }else if ("age".equals(tagName)){
            student.setAge(value);
        }else if ("sex".equals(tagName)){
            student.setSex(value);
        }
    }
}
