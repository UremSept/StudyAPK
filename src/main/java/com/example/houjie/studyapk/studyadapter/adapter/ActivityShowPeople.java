package com.example.houjie.studyapk.studyadapter.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyadapter.dao.People;

import java.util.ArrayList;

public class ActivityShowPeople extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ArrayList<People> mList;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_only_listview);
        mListView = (ListView) findViewById(R.id.OnlyListView);
        mList =new ArrayList<>();
        for (int i=0;i<50;i++){
            People people = new People("第"+i+"个人","这个人很懒，什么都没留下",R.mipmap.ic_launcher,false);
            mList.add(people);
        }
        ShowPepoleAdapter showPepoleAdapter = new ShowPepoleAdapter(mList,this);
        mListView.setAdapter(showPepoleAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(ActivityShowPeople.this, ""+position, Toast.LENGTH_SHORT).show();
        mList.get(position).setName("张三");
    }
}
