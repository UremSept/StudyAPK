package com.example.houjie.studyapk.studyxml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.fastjson.JSON;
import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyxml.bean.Clazz;
import com.example.houjie.studyapk.studyxml.bean.Student;
import com.example.houjie.studyapk.studyxml.bean.Teacher;
import com.example.houjie.studyapk.studyxml.factory.DOMStudent;
import com.example.houjie.studyapk.studyxml.factory.MySAXHandler;
import com.example.houjie.studyapk.studyxml.factory.PullSutdent;
import com.example.houjie.studyapk.studyxml.json.FromJson;
import com.example.houjie.studyapk.studyxml.json.ToJson;
import com.google.gson.Gson;

import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ActivityXML extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonDom,mButtonSax,mButtonPull,mButtonToJson,mButtonFromJson;
    private InputStream inputStream;
    private String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_xml);
        mButtonDom = (Button)findViewById(R.id.dom_button);
        mButtonSax = (Button)findViewById(R.id.sax_button);
        mButtonPull = (Button)findViewById(R.id.pull_button);
        mButtonToJson = (Button)findViewById(R.id.tojson_button);
        mButtonFromJson = (Button)findViewById(R.id.fromjson_button);
        mButtonDom.setOnClickListener(this);
        mButtonSax.setOnClickListener(this);
        mButtonPull.setOnClickListener(this);
        mButtonToJson.setOnClickListener(this);
        mButtonFromJson.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        try {
            inputStream = getAssets().open("clazz.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (v.getId()){
            case R.id.dom_button:
                try {
                    DOMStudent dom = new DOMStudent();
                    dom.DomFactory(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.sax_button:
                SAXParserFactory factory = SAXParserFactory.newInstance();
                try {
                    SAXParser parser = factory.newSAXParser();
                    MySAXHandler mySAXHandler = new MySAXHandler();
                    parser.parse(inputStream,mySAXHandler);
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.pull_button:
                PullSutdent pullSutdent = new PullSutdent();
                try {
                    pullSutdent.pull(inputStream);
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.tojson_button:
                //1-----传统JSON
//                ToJson toJson = new ToJson();
//                str = toJson.createJson(addClazz());
                //2-----谷歌GSON
//                Gson gson = new Gson();
//                str = gson.toJson(addClazz(),Clazz.class);

                //3-----阿里巴巴json
                str = JSON.toJSONString(addClazz());
                Log.i("--------gson--------",str);
                break;
            case R.id.fromjson_button:
                //1------传统JSON
//                frmoJson();
                //2-----谷歌GSON
                    //frmoJson();
                //3-----阿里巴巴json
                Clazz clazz = JSON.parseObject(str,Clazz.class);
                Log.i("--------gson--------",clazz.toString());
                break;
        }
    }
    private Clazz addClazz(){
        Teacher teacher = new Teacher("李老师","数学","班主任");
        Student student1 = new Student("张三","20","男");
        Student student2 = new Student("小瑜","21","女");
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        Clazz clazz = new Clazz("1年1班","20160511",teacher,list);
        return clazz;
    }

    private void frmoJson(){
        //1------传统JSON
//        if (str!=null){
//            FromJson fromJson = new FromJson();
//            Clazz clazz = fromJson.json(str);
//            Log.d("clazz",clazz.toString());
//        }
        //2------谷歌GSon
        if(str!=null){
            Gson gson = new Gson();
            Clazz clazz = gson.fromJson(str,Clazz.class);
            Log.i("clazz",clazz.toString());
        }
    }
}
