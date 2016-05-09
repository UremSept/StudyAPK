package com.example.houjie.studyapk.studyhttp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyhttp.Bean.Book;
import com.example.houjie.studyapk.studyhttp.Bean.Bookss;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class ActivityHttpOk extends AppCompatActivity {
    private ListView listView;
    private List<Book> list;
    private static String URL="http://japi.juhe.cn/book/recommend.from?key=429c684495acbe8325750af65a064840&cat=1&ranks=1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_only_listview);
        listView = (ListView) findViewById(R.id.OnlyListView);
        getData();
    }

    public void getData() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().get().url(URL).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {


            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse( Response response) throws IOException {
              // Log.d("response",response.body().string());
                Gson gson = new Gson();
                String string = response.body().string();
                Log.i("str",string);

                //Bookss bookss = gson.fromJson(String.valueOf(response), Bookss.class);
                Bookss bookss = gson.fromJson(string, Bookss.class);
                list = bookss.getResult().getData();

                final List<String> strList = new ArrayList<String>();

                for(int i=0;i<list.size();i++){
                    strList.add(list.get(i).getTitle());
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(list!=null){
                            ArrayAdapter arrayAdapter = new ArrayAdapter(ActivityHttpOk.this,android.R.layout.simple_expandable_list_item_1,strList);
                            listView.setAdapter(arrayAdapter);
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(ActivityHttpOk.this,ActivityHttpOkSec.class);
                                    intent.putExtra("code",list.get(position).getCode());
                                    startActivity(intent);
                                }
                            });
                        }
                    }
                });
            }
        });
    }
}
