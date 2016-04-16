package com.example.houjie.studyapk.studytnewknowledge.recycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.houjie.studyapk.R;

import java.util.List;

/**
 * Created by houjie on 2016/4/14.
 */
public class ImageAdapterRecycle extends RecyclerView.Adapter<ImageAdapterRecycle.ImageViewHolder>{
    private List<Integer> list;
    private Context context;

    public
    ImageAdapterRecycle(List<Integer> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_only_imageview,null);
        ImageViewHolder holder = new ImageViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.OnlyImageView);
        }
    }
}
