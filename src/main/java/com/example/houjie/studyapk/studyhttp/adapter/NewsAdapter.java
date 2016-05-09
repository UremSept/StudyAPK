package com.example.houjie.studyapk.studyhttp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studyhttp.Bean.URLNew;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


import java.util.List;

/**
 * Created by houjie on 2016/5/5.
 */
public class NewsAdapter extends BaseAdapter {
    private List<URLNew> list;
    private Context context;
    ImageLoader imageLoader = ImageLoader.getInstance();
    public NewsAdapter(List<URLNew> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
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
        if(convertView ==null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_http_volley_news,null);
            viewHolder.title = (TextView) convertView.findViewById(R.id.httpvolleynewstitle);
            viewHolder.content= (TextView) convertView.findViewById(R.id.httpvolleynewscontent);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.httpvolleynewsimage);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        URLNew news = list.get(position);
        viewHolder.title.setText(news.getTitle());
        viewHolder.content.setText(news.getContent());

        if(news.getImg().isEmpty()){
            viewHolder.imageView.setVisibility(View.GONE);
        }else{
            ImageLoader imageLoader =ImageLoader.getInstance();
            imageLoader.init(ImageLoaderConfiguration.createDefault(context));
            imageLoader.displayImage(news.getImg(),viewHolder.imageView);
        }
        return convertView;
    }

    class ViewHolder{
        TextView title,content;
        ImageView imageView;
    }
}
