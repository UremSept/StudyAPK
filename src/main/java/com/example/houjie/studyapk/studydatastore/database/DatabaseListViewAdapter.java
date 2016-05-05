package com.example.houjie.studyapk.studydatastore.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.houjie.studyapk.R;

import java.util.List;

/**
 * Created by houjie on 2016/4/24.
 */
public class DatabaseListViewAdapter extends BaseAdapter{

    private Context context;
    private List<Student> mList;

    public DatabaseListViewAdapter(Context context, List<Student> mList) {
        this.context = context;
        this.mList = mList;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder =null;
        if(convertView==null){
            viewHolder =new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_data_store_database_listview_adapter,null);
            viewHolder.name = (TextView) convertView.findViewById(R.id.databaselistname);
            viewHolder.sex = (TextView) convertView.findViewById(R.id.databaselistsex);
            viewHolder.age = (TextView) convertView.findViewById(R.id.databaselistage);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        //viewHolder
        viewHolder.name.setText(mList.get(position).getName());
        viewHolder.sex.setText(mList.get(position).getSex());
        viewHolder.age.setText(mList.get(position).getAge());
        return convertView;
    }

    class ViewHolder {
        TextView name,sex,age;
    }
}
