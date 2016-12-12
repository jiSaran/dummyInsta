package com.saran.test.dummyinsta;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by core I5 on 11/30/2016.
 */

public class ProfileContentFragment extends Fragment {
    private List<Profile_content> contents = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProfileContentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment,container,false);

        getImages();

        recyclerView = (RecyclerView)view.findViewById(R.id.profile_recycle);
        adapter = new ProfileContentAdapter(getActivity().getApplicationContext(),contents);
        StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void getImages()
    {
        contents.add(new Profile_content(R.drawable.img_feed_bottom_1));
        contents.add(new Profile_content(R.drawable.img_feed_bottom_2));
        contents.add(new Profile_content(R.drawable.img_feed_center_1));
        contents.add(new Profile_content(R.drawable.img_feed_center_2));
        contents.add(new Profile_content(R.drawable.ic_launcher));
        contents.add(new Profile_content(R.drawable.ic_global_menu_direct));
        contents.add(new Profile_content(R.drawable.ic_global_menu_feed));
        contents.add(new Profile_content(R.drawable.ic_global_menu_likes));
        contents.add(new Profile_content(R.drawable.ic_global_menu_news));
        contents.add(new Profile_content(R.drawable.ic_global_menu_popular));
    }
}
