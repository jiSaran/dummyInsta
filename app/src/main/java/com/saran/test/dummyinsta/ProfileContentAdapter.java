package com.saran.test.dummyinsta;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by core I5 on 11/30/2016.
 */

public class ProfileContentAdapter extends RecyclerView.Adapter<ProfileContentAdapter.CustomViewHolder> {

    private List<Profile_content> list;
    private Context context;
    public ProfileContentAdapter(Context parent, List<Profile_content> l) {
        this.list = l;
        this.context = parent;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View profileContentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_content,parent,false);
        return new CustomViewHolder(profileContentView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Profile_content content = list.get(position);
        Glide.with(context).load(content.getImage()).placeholder(R.drawable.ic_feed_top).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private ImageButton img;
        public CustomViewHolder(View itemView) {
            super(itemView);
            img = (ImageButton)itemView.findViewById(R.id.img_profile);
        }
    }
}
