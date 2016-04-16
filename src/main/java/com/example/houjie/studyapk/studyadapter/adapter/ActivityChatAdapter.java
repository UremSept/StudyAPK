package com.example.houjie.studyapk.studyadapter.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyadapter.bean.*;
import com.example.houjie.studyapk.studyadapter.dao.*;

import java.util.ArrayList;
import java.util.List;

public class ActivityChatAdapter extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private List<Type> mlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_chat);
        listView = (ListView) findViewById(R.id.activity_chat_adapter);
        mlist = new ArrayList<>();
        mlist.add(new TimeType("19:00"));
        mlist.add(new LeftType(R.mipmap.helloword,"你好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"2222222222223333h333h2h2ohoi34h234o23hoioihi"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"ooiho334i234hio23423o4i234oi23h4o2i3ih23o4h234ohoihoi好"));
        mlist.add(new TimeType("19:01"));
        mlist.add(new LeftType(R.mipmap.helloword,"你好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"我好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"大家好"));
        mlist.add(new TimeType("19:02"));
        mlist.add(new LeftType(R.mipmap.helloword,"你好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"我好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"大家好"));
        mlist.add(new TimeType("19:03"));
        mlist.add(new LeftType(R.mipmap.helloword,"你好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"我好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"大家好"));
        mlist.add(new TimeType("19:04"));
        mlist.add(new LeftType(R.mipmap.helloword,"你好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"我好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"大家好"));
        mlist.add(new TimeType("19:05"));
        mlist.add(new LeftType(R.mipmap.helloword,"你好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"我好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"大家好"));
        mlist.add(new TimeType("19:06"));
        mlist.add(new LeftType(R.mipmap.helloword,"你好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"我好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"大家好"));
        mlist.add(new TimeType("19:07"));
        mlist.add(new LeftType(R.mipmap.helloword,"你好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"我好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"大家好"));
        mlist.add(new TimeType("19:08"));
        mlist.add(new LeftType(R.mipmap.helloword,"你好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"我好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"大家好"));
        mlist.add(new TimeType("19:09"));
        mlist.add(new LeftType(R.mipmap.helloword,"你好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"我好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"大家好"));
        mlist.add(new TimeType("20:00"));
        mlist.add(new LeftType(R.mipmap.helloword,"你好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"我好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"大家好"));
        mlist.add(new TimeType("21:00"));
        mlist.add(new LeftType(R.mipmap.helloword,"你好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"我好"));
        mlist.add(new RightType(R.mipmap.ic_launcher,"大家好"));
        ChatAdapter chatAdapter =new ChatAdapter(this,mlist);
        listView.setAdapter(chatAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"点击了"+position,Toast.LENGTH_SHORT).show();
    }
}
