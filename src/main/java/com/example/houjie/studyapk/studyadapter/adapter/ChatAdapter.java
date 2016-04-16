package com.example.houjie.studyapk.studyadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyadapter.bean.Type;
import com.example.houjie.studyapk.studyadapter.dao.*;

import java.util.List;

/**
 * Created by houjie on 2016/4/8.
 */
public class ChatAdapter extends BaseAdapter {
    public static final int TIMETYPE =0;
    public static final int RIGHTTYPE =1;
    public static final int LEFTTYPE=2;

    private Context mContent;

    public ChatAdapter(Context mContent, List<Type> mList) {
        this.mContent = mContent;
        this.mList = mList;
    }

    private List<Type> mList;
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
        ViewHolderTime viewHolderTime = null;
        ViewHolderLeft viewHolderLeft =null;
        ViewHolderRight viewHolderRight = null;
        int type =mList.get(position).getType();
        if(convertView == null){
            switch (type){
                case TIMETYPE:
                    viewHolderTime = new ViewHolderTime();
                    convertView = LayoutInflater.from(mContent).inflate(R.layout.layout_adapter_chat_time,null);
                    viewHolderTime.textView = (TextView) convertView.findViewById(R.id.chat_time);
                    convertView.setTag(viewHolderTime);
                    break;
                case LEFTTYPE:
                    viewHolderLeft = new ViewHolderLeft();
                    convertView = LayoutInflater.from(mContent).inflate(R.layout.layout_adapter_chat_left,null);
                    viewHolderLeft.imageView= (ImageView) convertView.findViewById(R.id.chat_left_image);
                    viewHolderLeft.imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(mContent,"点击了左边的图片",Toast.LENGTH_SHORT).show();
                        }
                    });
                    viewHolderLeft.button = (Button) convertView.findViewById(R.id.chat_left_button);
                    viewHolderLeft.button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(mContent,"点击了左边的按钮",Toast.LENGTH_SHORT).show();
                        }
                    });
                    viewHolderLeft.textView = (TextView) convertView.findViewById(R.id.chat_left_text);
                    convertView.setTag(viewHolderLeft);
                    break;
                case RIGHTTYPE:
                    viewHolderRight = new ViewHolderRight();
                    convertView = LayoutInflater.from(mContent).inflate(R.layout.layout_adapter_chat_right,null);
                    viewHolderRight.imageView= (ImageView) convertView.findViewById(R.id.char_right_image);
                    viewHolderRight.imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(mContent,"点击了右边的图片",Toast.LENGTH_SHORT).show();
                        }
                    });

                    viewHolderRight.textView = (TextView) convertView.findViewById(R.id.char_right_text);
                    convertView.setTag(viewHolderRight);
                    break;
                default:break;

            }
        }else {
            switch (type){
                case TIMETYPE:
                        viewHolderTime= (ViewHolderTime) convertView.getTag();

                    break;
                case LEFTTYPE:
                    viewHolderLeft= (ViewHolderLeft) convertView.getTag();
                    break;
                case RIGHTTYPE:
                    viewHolderRight= (ViewHolderRight) convertView.getTag();

                    break;
                default:break;

            }
        }
        switch (type){
            case TIMETYPE:
                TimeType timeType= (TimeType) mList.get(position);
                viewHolderTime.textView.setText(timeType.getTime());
                break;
            case LEFTTYPE:
                LeftType leftType = (LeftType) mList.get(position);
                viewHolderLeft.imageView.setImageResource(leftType.getImage());
                viewHolderLeft.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContent,"点击了左边的图片",Toast.LENGTH_SHORT).show();
                    }
                });
                viewHolderLeft.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContent,"点击了左边的按钮",Toast.LENGTH_SHORT).show();
                    }
                });
                viewHolderLeft.textView.setText(leftType.getmText());
                break;
            case RIGHTTYPE:
                RightType rightType= (RightType) mList.get(position);
                viewHolderRight.imageView.setImageResource(rightType.getmImage());
                viewHolderRight.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContent,"点击了右边的图片",Toast.LENGTH_SHORT).show();
                    }
                });
                viewHolderRight.textView.setText(rightType.getmText());
                break;
            default:break;

        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getType();
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    class ViewHolderLeft{
        private ImageView imageView;
        private TextView textView;
        private Button button;
    }
    class ViewHolderRight{
        private ImageView imageView;
        private TextView textView;
    }
    class ViewHolderTime{
        private TextView textView;
    }
}
