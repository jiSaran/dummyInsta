package com.saran.test.dummyinsta;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Main_content> contents = new ArrayList<>();
    private RecyclerView recyclerView;
    private MainFeedAdapter adapter;
    private NavigationView naview;
    private DrawerLayout layout;
    static int REQUEST_IMAGE_CAPTURE = 1;
    private ImageButton img_btn1,img_btn2,btndirect;
    private FloatingActionButton fabbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (DrawerLayout)findViewById(R.id.activity_main);
        img_btn1 = (ImageButton)findViewById(R.id.menu_btn);
        add_content();


        final Intent fab_intent = new Intent(MainActivity.this,ShareActivity.class);
        fabbtn = (FloatingActionButton)findViewById(R.id.fab);
        fabbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(fab_intent);
            }
        });

        btndirect = (ImageButton)findViewById(R.id.directbtn);
        btndirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePictureIntent.resolveActivity(getPackageManager())!= null)
                {
                    startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
                }
            }
        });

        img_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.openDrawer(Gravity.LEFT);
            }
        });

        final Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
        naview = (NavigationView)findViewById(R.id.navigation);
        View view = naview.getHeaderView(0);
        img_btn2 = (ImageButton)view.findViewById(R.id.nav_head_search);
        img_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(intent);
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.content_recycler);
        adapter = new MainFeedAdapter(getApplicationContext(),contents);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }

    @Override
    protected void onPause() {
//        if(layout.isDrawerOpen(GravityCompat.START))
//        {
//            layout.closeDrawer(GravityCompat.START);
//        }
        super.onPause();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK )
        {
            Intent nextactivity = new Intent(MainActivity.this,ShareActivity.class);
            nextactivity.putExtras(data.getExtras());
            MainActivity.this.startActivity(nextactivity);
        }
    }

    @Override
    public void onBackPressed() {
        if (layout.isDrawerOpen(GravityCompat.START))
        {
            layout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    private void add_content()
    {
        Main_content content = new Main_content(R.drawable.img_feed_center_1,R.drawable.img_feed_bottom_1);
        contents.add(content);
        content = new Main_content(R.drawable.img_feed_center_2,R.drawable.img_feed_bottom_2);
        contents.add(content);
    }
}
