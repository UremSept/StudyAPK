package com.example.houjie.studyapk.studyadapter.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.houjie.studyapk.R;

import java.util.List;

/**
 * Created by houjie on 2016/4/7.
 */
public class CustemAdapter extends BaseAdapter {
    private List<String> mList;
    private Context mContent;

    public CustemAdapter(List<String> mList, Context mContent) {
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
        View view = LayoutInflater.from(mContent).inflate(R.layout.layout_adapter_custem,null);
        TextView textView = (TextView) view.findViewById(R.id.mtext);
        ImageView imageView = (ImageView) view.findViewById(R.id.mimage);
        textView.setText(mList.get(position));
        imageView.setImageResource(R.mipmap.ic_launcher);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContent,mList.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(mContent,mList.get(position),Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                LinearLayout toastView = (LinearLayout) toast.getView();
                ImageView imageView1 = new ImageView(mContent);
                imageView1.setImageResource(R.mipmap.ic_launcher);
                toastView.addView(imageView1);
                toast.show();
            }
        });
        return view;
    }
}
