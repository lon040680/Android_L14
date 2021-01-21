package com.chien.myviewpager2;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    Context context;
    String title, des;
    TextView tv;

    MyFragment(String title, String des) {
        this.title = title;
        this.des = des;
    }

    //自訂方法 傳出 title 做 tab 標題
    public String getTitle(){
        return title;
    }
    //綁定 Context
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }
    //初始化元件
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        tv = new TextView(context);
        tv.setTextSize(36);
        tv.setTextColor(Color.BLACK);
        return tv;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv.setText(des);
    }
}
