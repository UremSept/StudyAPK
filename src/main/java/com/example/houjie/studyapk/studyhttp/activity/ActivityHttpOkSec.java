package com.example.houjie.studyapk.studyhttp.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyhttp.Bean.Bookss;
import com.example.houjie.studyapk.studyhttp.Bean.PageResult;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ActivityHttpOkSec extends AppCompatActivity {
    private TextView HttpOkSectextview;
    private Button HttpOkSecbtnnext;
    private int count = 1;
    private int code;
    private String novel="";
    private List<String> list;

    //private static String URL="http://japi.juhe.cn/book/recommend.from?key=429c684495acbe8325750af65a064840&cat=1&ranks=1";
    private String url1 = "http://japi.juhe.cn/book/content.from?code=";
    private String url2 = "&cat=2&page=";
    private String url3 = "&key=429c684495acbe8325750af65a064840";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_ok_sec);
        HttpOkSectextview = (TextView) findViewById(R.id.HttpOkSectextview);
        HttpOkSecbtnnext = (Button) findViewById(R.id.HttpOkSecbtnnext);
        HttpOkSecbtnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                String url = url1+code+url2+count+url3;
                Log.i("url",url);
                getData(url);
            }
        });
        code = Integer.parseInt(getIntent().getStringExtra("code"));
        String url = url1+code+url2+count+url3;
        Log.i("url",url);
        getData(url);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

        }
    };

    public void getData(String url) {

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().get().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {


            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse( Response response) throws IOException {
                Gson gson = new Gson();
                final String string = response.body().string();
                Log.i("str",string);

                //Bookss bookss = gson.fromJson(String.valueOf(response), Bookss.class);
                PageResult pageResult = gson.fromJson(string, PageResult.class);
                if(pageResult!=null&&pageResult.getResult()!=null){
                    list = pageResult.getResult().getData();
                    if(pageResult.getResult().equals("Success")) {
                        for (int i = 0; i < list.size(); i++) {
                            novel = novel + list.get(i);
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(ActivityHttpOkSec.this, string, Toast.LENGTH_SHORT).show();
                            }
                        });
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                HttpOkSectextview.setText(novel);
                            }
                        });
                    }else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(ActivityHttpOkSec.this, "pageResult.getResult().equals(\"Success\")", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                }else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ActivityHttpOkSec.this, "pageResult!=null&&pageResult.getResult()!=null", Toast.LENGTH_SHORT).show();
                        }
                    });
                }



            }
        });
    }
}
