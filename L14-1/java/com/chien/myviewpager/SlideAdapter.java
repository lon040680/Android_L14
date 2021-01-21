package com.chien.myviewpager;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideAdapter extends PagerAdapter {
    //定義資源與變數
    int[] imgs = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4};
    String[] titles = {"太空人","衛星","黑洞","火箭"};
    int[] bgcolor = {Color.rgb(8,60,99), Color.rgb(219, 161, 110),
                     Color.rgb(10, 71, 116), Color.rgb(8, 49, 87)};
    Context context;
    LayoutInflater inflater;

    //建構方法
    SlideAdapter(Context c){
        context = c;
    }

    //產生頁面的迴圈,要知道迴圈次數 所以用.length
    @Override
    public int getCount() {
        return imgs.length;
    }

    //載入指定版面並初始化元件
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //重要段落 要記得 (LayoutInflater) 轉換物件
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        //實作
        View view = inflater.inflate(R.layout.slide, container,false);

        //初始化
        LinearLayout layout = view.findViewById(R.id.layout);
        ImageView img = view.findViewById(R.id.imageView);
        TextView title = view.findViewById(R.id.textView);

        //放東西
        layout.setBackgroundColor(bgcolor[position]);
        img.setImageResource(imgs[position]);
        title.setText(titles[position]);

        container.addView(view);

        return view;
    }

    //判斷是否需要產生新頁面
    //View view 去比較是否在 Object object 記憶體裡
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout)object);
    }

    //刪除多餘的頁面 避免佔用記憶體
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object); 取其一寫 下面這個效率較好
        container.removeView((LinearLayout)object);
    }
}
