package com.example.buisness_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.buisness_app.adapter.ItemImageAdapter;

import java.util.ArrayList;

public class ItemDetailsActivity extends AppCompatActivity {

    private ItemImageAdapter itemImageAdapter;
    private ArrayList<Integer> arrayList=new ArrayList<>();
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private TextView[] dot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        init();
        addDatainList();
        addDot(0);
        itemImageAdapter=new ItemImageAdapter(arrayList,this);
        viewPager.setAdapter(itemImageAdapter);
        pageChanges();
    }

    private void pageChanges() {
        // whenever the page changes
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }
            @Override
            public void onPageSelected(int i) {
                addDot(i);
            }
            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    public void addDot(int page_position) {
        dot = new TextView[arrayList.size()];
        linearLayout.removeAllViews();

        for (int i = 0; i < dot.length; i++) {;
            dot[i] = new TextView(this);
            dot[i].setText(Html.fromHtml("&#9679;"));
            dot[i].setTextSize(15);
            dot[i].setPadding(0,0,10,0);
            dot[i].setTextColor(getResources().getColor(R.color.colorGray));
            linearLayout.addView(dot[i]);
        }
        //active dot
        dot[page_position].setTextColor(getResources().getColor(R.color.colorPrimary));
    }

    private void addDatainList() {
        arrayList.add(R.drawable.college);
        arrayList.add(R.drawable.school);
        arrayList.add(R.drawable.college);
        arrayList.add(R.drawable.school);
        arrayList.add(R.drawable.college);
        arrayList.add(R.drawable.school);
    }

    private void init() {
        viewPager=findViewById(R.id.viewPager);
        linearLayout=findViewById(R.id.layout_dot);
    }
}
