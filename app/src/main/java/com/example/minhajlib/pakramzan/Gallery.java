package com.example.minhajlib.pakramzan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Intent intent = getIntent();
        int resId = intent.getIntExtra("res",R.drawable.dua);
        ImageView imageView  = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(resId);
    }
}
