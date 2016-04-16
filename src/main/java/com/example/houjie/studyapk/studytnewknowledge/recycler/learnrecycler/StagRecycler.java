package com.example.houjie.studyapk.studytnewknowledge.recycler.learnrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studytnewknowledge.recycler.adapter.ImageAdapterRecycle;

import java.util.ArrayList;
import java.util.List;

public class StagRecycler extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Integer> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_knowledge_vertical_recycler);
        list= new ArrayList<>();
        list.add(R.mipmap.picture1);
        list.add(R.mipmap.picture2);
        list.add(R.mipmap.picture3);
        list.add(R.mipmap.picture4);
        list.add(R.mipmap.picture5);
        list.add(R.mipmap.picture24);
        list.add(R.mipmap.picture7);
        list.add(R.mipmap.picture8);
        list.add(R.mipmap.picture9);
        list.add(R.mipmap.picture10);

        ImageAdapterRecycle adapterRecycle = new ImageAdapterRecycle(list,this);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView = (RecyclerView) findViewById(R.id.stagRecyler);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapterRecycle);



    }
}
