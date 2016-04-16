package com.example.houjie.studyapk.studyadapter.dao;

import com.example.houjie.studyapk.studyadapter.adapter.ChatAdapter;
import com.example.houjie.studyapk.studyadapter.bean.Type;

/**
 * Created by houjie on 2016/4/8.
 */
public class TimeType implements Type{
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public TimeType(String time) {

        this.time = time;
    }

    @Override
    public int getType() {
        return ChatAdapter.TIMETYPE;
    }
}
