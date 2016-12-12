package com.saran.test.dummyinsta;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by core I5 on 11/25/2016.
 */

public class MainFeedAdapter extends RecyclerView.Adapter<MainFeedAdapter.MyViewHolder> {

    private List<Main_content> contentList;
    private Context context;

    public MainFeedAdapter(Context parent, List<Main_content> list)
    {
        this.contentList = list;
        this.context = parent ;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_content,parent,false);
        return new MyViewHolder(contentView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Main_content content = contentList.get(position);
        Glide.with(context).load(content.getMain_feed_img()).into(holder.mainfeed_view);
        Glide.with(context).load(content.getBottom_feed_img()).into(holder.bottomfeed_view);
    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView mainfeed_view, bottomfeed_view;

        public MyViewHolder(View view)
        {
            super(view);
            mainfeed_view = (ImageView)view.findViewById(R.id.feed_center_img);
            bottomfeed_view = (ImageView)view.findViewById(R.id.feed_bottom_img);
        }
    }
}
