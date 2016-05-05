package com.example.houjie.studyapk.studyxml.factory;


import android.util.Log;

import com.example.houjie.studyapk.studyxml.bean.Student;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Administrator on 2016/4/28.
 */
public class DOMStudent {
    public void DomFactory(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder =factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        NodeList nodeList =document.getElementsByTagName("student");
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i <nodeList.getLength() ; i++) {
            Student student = new Student();
            Node node = nodeList.item(i);
            NamedNodeMap map =  node.getAttributes();
            Node major = map.getNamedItem("major");
            Node num = map.getNamedItem("num");
            student.setMajor(major.getNodeValue());
            student.setNum(num.getNodeValue());
            NodeList childList = node.getChildNodes();
            for (int j = 0; j <childList.getLength() ; j++) {
                Node nodeName = childList.item(j);
                if (nodeName.getNodeType() == Node.ELEMENT_NODE){
                    String name = nodeName.getNodeName();
                    String value = nodeName.getFirstChild().getNodeValue();
                    if (nodeName.equals("name")) {
                        Log.i("该学生的名称" + value,"---------------");
                        student.setName(value);
                    } else if (nodeName.equals("age")) {
                        Log.i("该学生的年龄" + value,"----------------");
                        student.setAge(value);
                    } else if (nodeName.equals("sex")) {
                        Log.i("该学生的性别" + value,"-------------------");
                        student.setSex(value);
                    }
                }
            }
            list.add(student);
        }
    }
}
