package com.example.houjie.studyapk.studyadapter.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.houjie.studyapk.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityCustemAdapter extends AppCompatActivity {
    private ListView mListView;
    private List<String> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_only_listview);
        mListView = (ListView) findViewById(R.id.OnlyListView);
        mList =new ArrayList<>();
        for (int i=0;i<50;i++){
            String map = "第"+(i+1)+"天的日记";
            mList.add(map);
        }
        CustemAdapter custemAdapter =new CustemAdapter(mList,this);
        mListView.setAdapter(custemAdapter);
    }
}
