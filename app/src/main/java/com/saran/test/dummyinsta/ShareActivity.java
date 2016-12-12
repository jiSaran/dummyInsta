package com.saran.test.dummyinsta;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by core I5 on 12/1/2016.
 */

public class ShareActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageshare);
        if(getIntent().getExtras()!=null) {
            Bundle data = getIntent().getExtras();
            Bitmap bitmap = (Bitmap) data.get("data");
            imageView = (ImageView) findViewById(R.id.shareimg);
            imageView.setImageBitmap(bitmap);
        }
    }
}
