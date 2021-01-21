package com.chien.myviewpager2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context;
    TabLayout tabLayout;
    ArrayList<MyFragment> fragments;
    MyAdapter adapter;
    ViewPager viewPager;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        fragments = new ArrayList<>();
        for(int i=1; i<6; i++){
            fragments.add(new MyFragment("Tab" + i, "歪歪的內容 : " + i));
            adapter = new MyAdapter(getSupportFragmentManager(), fragments);
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    //MyAdapter 內部類
    public class MyAdapter extends FragmentPagerAdapter {
        ArrayList<MyFragment> list;
        public MyAdapter(@NonNull FragmentManager fm, ArrayList<MyFragment> list){
            super(fm);
            this.list = list;
        }

        //取得項目引數參數
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        // 返回size() 這樣就知道執行次數了
        @Override
        public int getCount() {
            return list.size();
        }

        //取得 MyFragment裡的title給tab
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragments.get(position).getTitle();
        }
    }
}