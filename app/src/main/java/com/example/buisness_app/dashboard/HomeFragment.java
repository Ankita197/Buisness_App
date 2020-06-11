package com.example.buisness_app.dashboard;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.buisness_app.R;
import com.happy.widget.DataItem;
import com.happy.widget.DynamicPagerAdapter;
import com.happy.widget.DynamicViewPager;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ArrayList<DataItem> itemFunctionArrayList;
    private TextView tvMyApp;
    EditText edtSearch;
    private DynamicViewPager viewPager;
    LinearLayout layout_dot;
    TextView[] dot;
    int dotNumber=2;
    DynamicPagerAdapter dynamicPagerAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        addItemInList();
        if(itemFunctionArrayList.size()%(viewPager.getCol()*viewPager.getRow())==0){
            dotNumber=(int) Math.floor((itemFunctionArrayList.size()/(viewPager.getCol()*viewPager.getRow())));
        }
        else {
            dotNumber = (int) Math.floor((itemFunctionArrayList.size() / (viewPager.getCol() * viewPager.getRow()))) + 1;
        }
        dynamicPagerAdapter = new DynamicPagerAdapter(getActivity(),viewPager,R.layout.item_list,R.layout.item_appfunction,itemFunctionArrayList);

        viewPager.setAdapter(dynamicPagerAdapter);
        setPageItemClick();
        addDot(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("___@___",""+position);

            }

            @Override
            public void onPageSelected(int position) {
                addDot(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }
    private void setPageItemClick() {
        viewPager.setPageItemClickListener(new DynamicViewPager.OnPageItemClickListener() {
            @Override
            public void onPageItemClick(int page, int position, String tag, DataItem item) {
                getFragmentManager().beginTransaction().replace(R.id.container,new TabsLoadFragment(),"tabs load fragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private void addItemInList() {
        for (int i=0;i<26;i++) {
            itemFunctionArrayList.add(new DataItem("" + i, R.drawable.chate_icon,String.valueOf((char) (65+i))));
        }
    }

    private void init(View view) {
        viewPager=view.findViewById(R.id.viewPager);
        itemFunctionArrayList=new ArrayList<>();
        layout_dot=view.findViewById(R.id.layout_dot);
        tvMyApp=view.findViewById(R.id.tvMyApp);
        edtSearch=view.findViewById(R.id.edtSearch);
    }
    public void addDot(int page_position) {
        dot = new TextView[dotNumber];
        layout_dot.removeAllViews();

        for (int i = 0; i < dot.length; i++) {;
            dot[i] = new TextView(getActivity());
            dot[i].setText(Html.fromHtml("&#9679;"));
            dot[i].setTextSize(15);
            dot[i].setPadding(0,0,10,0);
            dot[i].setTextColor(getResources().getColor(R.color.colorAccent));
            layout_dot.addView(dot[i]);
        }
        //active dot
        dot[page_position].setTextColor(getResources().getColor(R.color.colorPrimary));
    }
}
