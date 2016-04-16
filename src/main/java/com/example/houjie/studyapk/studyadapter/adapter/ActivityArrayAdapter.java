package com.example.houjie.studyapk.studyadapter.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.houjie.studyapk.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityArrayAdapter extends AppCompatActivity {
    private List<String> mList;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_only_listview);
        mList =new ArrayList<>();
        for (int i=0;i<20;i++){
        String map = "第"+(i+1)+"天的日记";
        mList.add(map);
        }
        ArrayAdapter adapter =new ArrayAdapter(this,
                android.R.layout.simple_expandable_list_item_1,mList);
        mListView = (ListView) findViewById(R.id.OnlyListView);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
