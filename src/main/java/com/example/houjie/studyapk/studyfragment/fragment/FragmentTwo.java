package com.example.houjie.studyapk.studyfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.houjie.studyapk.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houjie on 2016/4/10.
 */
public class FragmentTwo extends Fragment{
    private ListView mListView;
    private List<String> mList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.layout_only_listview,null);
        mListView = (ListView) view.findViewById(R.id.OnlyListView);
        mList =new ArrayList<>();
        mList.add("你好");
        mList.add("我好");
        mList.add("大家好");
        mList.add("你好");
        mList.add("我好");
        mList.add("大家好");
        mList.add("你好");
        mList.add("我好");
        mList.add("大家好");
        mList.add("你好");
        mList.add("我好");
        mList.add("大家好");
        mList.add("你好");
        mList.add("我好");
        mList.add("大家好");
        mList.add("你好");
        mList.add("我好");
        mList.add("大家好");
        ArrayAdapter adapter =  new ArrayAdapter(getActivity(),android.R.layout.simple_expandable_list_item_1,mList);
        mListView.setAdapter(adapter);
        return view;
    }
}
