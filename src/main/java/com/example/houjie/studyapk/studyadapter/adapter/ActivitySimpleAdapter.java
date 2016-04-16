package com.example.houjie.studyapk.studyadapter.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.houjie.studyapk.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivitySimpleAdapter extends AppCompatActivity {
    private ListView mListView;
    private List<Map<String,Object>> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_only_listview);
        mListView = (ListView) findViewById(R.id.OnlyListView);
        mList =new ArrayList<>();
        for (int i=0;i<20;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("icon",R.mipmap.ic_launcher);
            //String map = "第"+(i+1)+"天的日记";
            map.put("text","第"+(i+1)+"天的日记");
            mList.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,mList,
                R.layout.layout_adapter_simple,new String []{"icon","text"},
                new int []{R.id.image,R.id.text});
        mListView.setAdapter(adapter);
    }
}
