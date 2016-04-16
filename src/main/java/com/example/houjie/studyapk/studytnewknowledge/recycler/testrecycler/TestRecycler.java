package com.example.houjie.studyapk.studytnewknowledge.recycler.testrecycler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studytnewknowledge.recycler.adapter.ImageAdapterRecycle;
import com.example.houjie.studyapk.studytnewknowledge.recycler.adapter.TestAdapterRecycler;
import com.example.houjie.studyapk.studytnewknowledge.recycler.bean.Student;
import com.example.houjie.studyapk.studytnewknowledge.recycler.learnrecycler.HorizontalRecycler;
import com.example.houjie.studyapk.studytnewknowledge.recycler.learnrecycler.StagRecycler;

import java.util.ArrayList;
import java.util.List;

public class TestRecycler extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button button;
    private PopupWindow mPopupWindow;
    private View mView;
    private List<Student> mList;
    private List<Integer> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_knowledge_test_recycler);
        mView = LayoutInflater.from(TestRecycler.this).inflate(R.layout.layout_tdw_window_pop,null);
        mPopupWindow = new PopupWindow();
        mPopupWindow.setContentView(mView);
        mPopupWindow.setWidth(FrameLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setHeight(FrameLayout.LayoutParams.WRAP_CONTENT);

        mList=new ArrayList<>();
        mList.add(new Student("张三","dsifojdfoewio",R.mipmap.ic_launcher));
        mList.add(new Student("张三","dsifojdfoewio",R.mipmap.ic_launcher));
        mList.add(new Student("张三","dsifojdfoewio",R.mipmap.ic_launcher));
        mList.add(new Student("张三","dsifojdfoewio",R.mipmap.ic_launcher));
        mList.add(new Student("张三","dsifojdfoewio",R.mipmap.ic_launcher));
        mList.add(new Student("张三","dsifojdfoewio",R.mipmap.ic_launcher));
        mList.add(new Student("张三","dsifojdfoewio",R.mipmap.ic_launcher));
        mList.add(new Student("张三","dsifojdfoewio",R.mipmap.ic_launcher));

        recyclerView = (RecyclerView) findViewById(R.id.testRecyclerRecyclerView);
        final TestAdapterRecycler adapter = new TestAdapterRecycler(mList,this);

        TextView textView1 = (TextView) mView.findViewById(R.id.TextView1);
        textView1.setText("横放");
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
                LinearLayoutManager linearLayoutManager =new LinearLayoutManager(TestRecycler.this, LinearLayout.HORIZONTAL,false);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(linearLayoutManager);
            }
        });
        TextView textView2 = (TextView)mView.findViewById(R.id.TextView2);
        textView2.setText("竖屏");
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
                LinearLayoutManager linearLayoutManager =new LinearLayoutManager(TestRecycler.this, LinearLayout.VERTICAL,false);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(linearLayoutManager);
            }
        });
        TextView textView3 = (TextView) mView.findViewById(R.id.TextView3);
        textView3.setText("网格");
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
                GridLayoutManager gridLayoutManager =new GridLayoutManager(TestRecycler.this, 2);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(gridLayoutManager);
            }
        });
        TextView textView4 = (TextView) mView.findViewById(R.id.TextView4);
        textView4.setText("瀑布");
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
                list= new ArrayList<>();
                list.add(R.mipmap.picture1);
                list.add(R.mipmap.picture2);
                list.add(R.mipmap.picture3);
                list.add(R.mipmap.picture4);
                list.add(R.mipmap.picture5);
                list.add(R.mipmap.picture23);
                list.add(R.mipmap.picture7);
                list.add(R.mipmap.picture8);
                list.add(R.mipmap.picture9);
                list.add(R.mipmap.picture10);
                ImageAdapterRecycle adapterRecycle = new ImageAdapterRecycle(list,TestRecycler.this);
                StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapterRecycle);
            }
        });

        button = (Button) findViewById(R.id.testRecyclerBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.showAsDropDown(button);
            }
        });

    }
}
