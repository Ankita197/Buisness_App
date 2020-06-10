package com.example.buisness_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.buisness_app.R;

import java.util.ArrayList;

public class ItemImageAdapter extends PagerAdapter {
    ArrayList<Integer> arrayList;
    Context context;

    public ItemImageAdapter(ArrayList<Integer> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public  Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image_viewpager, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.ivPager);
        imageView.setBackgroundResource(arrayList.get(position));
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
