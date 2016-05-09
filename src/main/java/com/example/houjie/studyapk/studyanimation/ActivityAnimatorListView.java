package com.example.houjie.studyapk.studyanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.houjie.studyapk.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityAnimatorListView extends AppCompatActivity {
    private ListView listView;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_only_listview);
        listView = (ListView) findViewById(R.id.OnlyListView);
        list = new ArrayList<>();
        list.add("测试数据");
        list.add("测试数据");
        list.add("测试数据");
        list.add("测试数据");
        list.add("测试数据");
        list.add("测试数据");
        list.add("测试数据");
        list.add("测试数据");
        list.add("测试数据");
        list.add("测试数据");
        list.add("测试数据");
        list.add("测试数据");
        list.add("测试数据");
        list.add("测试数据");
        list.add("测试数据");
        //在布局文件中添加         android:layoutAnimation="@anim/list_item_translate"
        //即可加载Animation
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,list);


        //在程序加载animation
        Animation animator = AnimationUtils.loadAnimation(ActivityAnimatorListView.this,R.anim.translatelistview);
        LayoutAnimationController layoutAnimationController= new LayoutAnimationController(animator);
        layoutAnimationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
        layoutAnimationController.setDelay(0.7f);
        listView.setLayoutAnimation(layoutAnimationController);
        listView.setAdapter(arrayAdapter);
    }
}
