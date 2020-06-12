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

        itemFunctionArrayList.add(new DataItem("1", R.drawable.allcatagories,"All Catagories"));
        itemFunctionArrayList.add(new DataItem("2", R.drawable.b2b,"B2b"));
        itemFunctionArrayList.add(new DataItem("3", R.drawable.shopping,"Shopping"));
        itemFunctionArrayList.add(new DataItem("4", R.drawable.daily_needs,"Daily needs"));
        itemFunctionArrayList.add(new DataItem("5", R.drawable.restrurent,"restruant"));
        itemFunctionArrayList.add(new DataItem("6", R.drawable.diagnostic,"Diagnostic Center"));
        itemFunctionArrayList.add(new DataItem("7", R.drawable.virus,"Virus"));
        itemFunctionArrayList.add(new DataItem("8", R.drawable.aurvadicdoctor,"Doctor"));
        itemFunctionArrayList.add(new DataItem("9", R.drawable.movies,"Movies"));
        itemFunctionArrayList.add(new DataItem("10", R.drawable.repairs,"Repair"));
        itemFunctionArrayList.add(new DataItem("11", R.drawable.bill,"Recharge"));
        itemFunctionArrayList.add(new DataItem("12", R.drawable.travell,"Travelling"));
        itemFunctionArrayList.add(new DataItem("13", R.drawable.astrology,"Astrologers"));
        itemFunctionArrayList.add(new DataItem("14", R.drawable.automobile,"Automobiles"));
        itemFunctionArrayList.add(new DataItem("15", R.drawable.aurvadicdoctor,"Aurvadic Doctors"));
        itemFunctionArrayList.add(new DataItem("16", R.drawable.babycare,"Baby Care Center"));
        itemFunctionArrayList.add(new DataItem("17", R.drawable.beauty,"Beauty"));
        itemFunctionArrayList.add(new DataItem("18", R.drawable.bone_doctor,"Bone"));
        itemFunctionArrayList.add(new DataItem("19", R.drawable.borewell_constructor,"Borewell Constructor"));
        itemFunctionArrayList.add(new DataItem("20", R.drawable.builder,"Builder& Constructor"));
        itemFunctionArrayList.add(new DataItem("21", R.drawable.chate_icon,"message& Services"));
        itemFunctionArrayList.add(new DataItem("22", R.drawable.cake_shop,"Cake Shop"));
        itemFunctionArrayList.add(new DataItem("23", R.drawable.cardiologist,"Cardiologist"));
        itemFunctionArrayList.add(new DataItem("24", R.drawable.person,"Charter Accountant"));
        itemFunctionArrayList.add(new DataItem("25", R.drawable.child_specialist_doctor,"Child Specialist"));
        itemFunctionArrayList.add(new DataItem("26", R.drawable.courier_services,"Courier Service"));
        itemFunctionArrayList.add(new DataItem("27", R.drawable.crane_services,"Crane Service"));
        itemFunctionArrayList.add(new DataItem("28", R.drawable.cricket,"Cricket"));
        itemFunctionArrayList.add(new DataItem("29", R.drawable.dthprovider,"DTH providers"));
        itemFunctionArrayList.add(new DataItem("30", R.drawable.dance_class,"Dance Classes"));
        itemFunctionArrayList.add(new DataItem("31", R.drawable.dentist,"Dentist"));
        itemFunctionArrayList.add(new DataItem("32", R.drawable.diabetologist,"Diabetologist"));
        itemFunctionArrayList.add(new DataItem("33", R.drawable.diatician,"Dietitians"));
        itemFunctionArrayList.add(new DataItem("34", R.drawable.aurvadicdoctor,"ENT Doctors"));
        itemFunctionArrayList.add(new DataItem("35", R.drawable.education_training,"Education & Trainings"));
        itemFunctionArrayList.add(new DataItem("36", R.drawable.electrical_goods,"Electronic Gooda"));

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
