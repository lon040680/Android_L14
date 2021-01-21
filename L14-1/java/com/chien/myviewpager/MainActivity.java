package com.chien.myviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    Context context;
    SlideAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        adapter = new SlideAdapter(context);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                //super.onPageSelected(position);
                Toast.makeText(context, "Check.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}