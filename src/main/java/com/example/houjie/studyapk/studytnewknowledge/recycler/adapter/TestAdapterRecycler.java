package com.example.houjie.studyapk.studytnewknowledge.recycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.houjie.studyapk.R;
import com.example.houjie.studyapk.studytnewknowledge.recycler.bean.Student;

import java.util.List;

/**
 * Created by houjie on 2016/4/14.
 */
public class TestAdapterRecycler extends RecyclerView.Adapter<TestAdapterRecycler.RecyclerViewHolder>{
    private List<Student> mList;
    private Context mContext;

    public TestAdapterRecycler(List<Student> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_new_knowledge_recycler,null);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        Student student = mList.get(position);
        holder.imageView.setImageResource(student.getImage());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"图片"+position,Toast.LENGTH_SHORT).show();
            }
        });
        holder.name.setText(student.getName());
        holder.text.setText(student.getText());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class RecyclerViewHolder extends  RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView name,text;
        public RecyclerViewHolder(View itemView){
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.recycler_image);
            name = (TextView)itemView.findViewById(R.id.recycler_textView1);
            text = (TextView)itemView.findViewById(R.id.recycler_textView2);
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"text"+getLayoutPosition(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
