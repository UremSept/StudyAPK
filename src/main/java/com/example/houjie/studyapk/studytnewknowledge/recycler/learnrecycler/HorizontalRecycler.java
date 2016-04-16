package com.example.houjie.studyapk.studytnewknowledge.recycler.learnrecycler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studytnewknowledge.recycler.adapter.TestAdapterRecycler;
import com.example.houjie.studyapk.studytnewknowledge.recycler.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class HorizontalRecycler extends AppCompatActivity {
    private List<Student> mList;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_knowledge_horizontal_recycler);
        Intent intent=getIntent();
        String str = intent.getStringExtra("open");
        recyclerView = (RecyclerView) findViewById(R.id.herizontal_recycler);
        mList=new ArrayList<>();
        mList.add(new Student("张三","dsifojdfoewio",R.mipmap.ic_launcher));
        mList.add(new Student("张三","dsifojdfoewio",R.mipmap.ic_launcher));
        mList.add(new Student("张三","dsifojdfoewio",R.mipmap.ic_launcher));
        mList.add(new Student("张三","dsifojdfoewio",R.mipmap.ic_launcher));
        mList.add(new Student("张三","dsifojdfoewio",R.mipmap.ic_launcher));
        mList.add(new Student("张三","dsifojdfoewio",R.mipmap.ic_launcher));
        mList.add(new Student("张三","dsifojdfoewio",R.mipmap.ic_launcher));
        mList.add(new Student("张三","dsifojdfoewio",R.mipmap.ic_launcher));

        TestAdapterRecycler adapter = new TestAdapterRecycler(mList,this);
        if(str.equals("horizontal")){
            LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        if(str.equals("vertical")){
            LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this, LinearLayout.VERTICAL,false);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        if(str.equals("gridlayout")){
            GridLayoutManager gridLayoutManager =new GridLayoutManager(this, 2);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(gridLayoutManager);
        }

    }
}
