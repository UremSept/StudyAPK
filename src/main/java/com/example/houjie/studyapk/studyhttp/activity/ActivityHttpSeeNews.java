package com.example.houjie.studyapk.studyhttp.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyhttp.Bean.News;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class ActivityHttpSeeNews extends AppCompatActivity {
    private ListView httpSeeNewsListView;
    private String s = "http://op.juhe.cn/onebox/news/words?key=b1cccdf6af5cd58b7ed712a9ccb3af46";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_only_listview);
        httpSeeNewsListView = (ListView) findViewById(R.id.OnlyListView);
        MyThread myThread = new MyThread();
        myThread.start();
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            List<String> list= (List<String>) msg.obj;
            if(list!=null){
                ArrayAdapter arrayAdapter = new ArrayAdapter(ActivityHttpSeeNews.this,android.R.layout.simple_expandable_list_item_1,list);
                httpSeeNewsListView.setAdapter(arrayAdapter);
                httpSeeNewsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                });
            }

        }
    };



    class MyThread extends Thread{
        @Override
        public void run() {
            try {
                URL url = new URL(s);
                URLConnection connection =url.openConnection();
                HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setRequestProperty("Accept-Charset","utf-8");

                int code = httpURLConnection.getResponseCode();
                if(code ==HttpURLConnection.HTTP_OK){
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    String buffer ="";
                    String line = reader.readLine();
                    while (line != null) {
                        buffer =buffer+line;
                        line = reader.readLine();
                    }


//                    String line = reader.readLine();
//                    while (reader.readLine() != null) {
//                        line = line+reader.readLine();
//
//                        Log.i("---------","ddddddddddddddddddddddddddddddddddddd");
//                    }
                    Gson gson = new Gson();
                    Log.i("line",buffer);
                    News news = gson.fromJson(buffer,News.class);
                    List<String> list = news.getResult();
                    Message message = handler.obtainMessage();
                    message.obj = list;
                    handler.sendMessage(message);
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
