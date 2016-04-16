package com.example.houjie.studyapk.studyadapter.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyadapter.dao.People;

import java.util.List;

/**
 * Created by houjie on 2016/4/7.
 */
public class ShowPepoleAdapter extends BaseAdapter {
    private List<People> mList;
    private Context mContent;

    public ShowPepoleAdapter(List<People> mList, Context mContent) {
        this.mList = mList;
        this.mContent = mContent;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView ==null){
            Log.e("getView","new ConvertView+++++"+position+"-------"+convertView);
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContent).inflate(R.layout.layout_adapter_show_people,null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.peope_imgae);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.name);
            viewHolder.textView1= (TextView) convertView.findViewById(R.id.autograph);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.AdapterShowPeopleCheckBox);
            //viewHolder.checkBox.setChecked(mList.get(position).isChecked());
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
            Log.e("getView","old ConvertView+++++"+position+"-------"+convertView);
        }
        final People people=mList.get(position);
        viewHolder.imageView.setImageResource(people.getImage());
        viewHolder.textView.setText(people.getName());
        viewHolder.textView1.setText(people.getAutograph());
        viewHolder.checkBox.setChecked(people.isChecked());
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.setChecked(!people.isChecked());
            }
        });

        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView,textView1;
        CheckBox checkBox;
    }
}
