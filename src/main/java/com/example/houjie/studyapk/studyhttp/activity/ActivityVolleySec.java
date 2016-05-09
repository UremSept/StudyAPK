package com.example.houjie.studyapk.studyhttp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyhttp.Bean.URLNew;
import com.example.houjie.studyapk.studyhttp.Bean.URLNews;
import com.example.houjie.studyapk.studyhttp.adapter.NewsAdapter;

import org.json.JSONObject;

import java.util.List;

public class ActivityVolleySec extends AppCompatActivity {
    private ListView listView;
    private Context mContext;
    private RequestQueue mQueue;
    private List<URLNew> list;
    private static String URL = "http://op.juhe.cn/onebox/news/query?key=b1cccdf6af5cd58b7ed712a9ccb3af46&q=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_only_listview);
        String url = URL+getIntent().getStringExtra("str");
        Log.i("url",url);
        listView = (ListView) findViewById(R.id.OnlyListView);
        mContext =this;
        getDate(url);
    }
    public void getDate(String url) {
        mQueue = Volley.newRequestQueue(mContext);
        JsonObjectRequest requst = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String str = Thread.currentThread().getName();//验证当前线程的名称
                Log.d("Thread",str);
                URLNews news= JSON.parseObject(String.valueOf(response),URLNews.class);
                list =news.getResult();
                NewsAdapter newsAdapter =new NewsAdapter(list,mContext);
                listView.setAdapter(newsAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mQueue.add(requst);
    }
}
