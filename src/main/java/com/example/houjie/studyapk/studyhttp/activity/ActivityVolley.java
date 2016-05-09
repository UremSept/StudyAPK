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
import com.example.houjie.studyapk.studyhttp.Bean.News;

import org.json.JSONObject;

import java.util.List;

/**
 * Google2013年I/O大会上推出的轻量级数据交互的框架
 它的设计目标就是非常适合去进行数据量不大，但通信频繁的网络操作，而对于大数据量的网络操作，比如说下载文件等，Volley的表现就会非常糟糕。

 */
public class ActivityVolley extends AppCompatActivity {
    public static final String URLS = "http://op.juhe.cn/onebox/news/words?key=b1cccdf6af5cd58b7ed712a9ccb3af46";
    private ListView mListView;
    private RequestQueue mQueue;
    private List<String> list;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_only_listview);
        mContext =this;
        mListView = (ListView) findViewById(R.id.OnlyListView);
        getDate();
    }

    public void getDate() {
        mQueue = Volley.newRequestQueue(mContext);
        JsonObjectRequest requst = new JsonObjectRequest(Request.Method.GET, URLS, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String str = Thread.currentThread().getName();//验证当前线程的名称
                Log.d("Thread",str);
                News news= JSON.parseObject(String.valueOf(response),News.class);
                list = news.getResult();
                ArrayAdapter arrayAdapter = new ArrayAdapter(mContext,android.R.layout.simple_expandable_list_item_1,list);
                mListView.setAdapter(arrayAdapter);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String str = list.get(position);
                        Intent intent = new Intent(mContext,ActivityVolleySec.class);
                        intent.putExtra("str",str);
                        startActivity(intent);
                    }
                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mQueue.add(requst);
    }
}
