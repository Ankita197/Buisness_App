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
        itemFunctionArrayList.add(new DataItem("36", R.drawable.electrical_goods,"Electronic Goods"));
        itemFunctionArrayList.add(new DataItem("37", R.drawable.event_organizer,"Event Organizer"));
        itemFunctionArrayList.add(new DataItem("38", R.drawable.eye_doctor,"Eye Doctor"));
        itemFunctionArrayList.add(new DataItem("39", R.drawable.fabricator,"Fabricator"));
        itemFunctionArrayList.add(new DataItem("40", R.drawable.fitness,"Fitness"));
        itemFunctionArrayList.add(new DataItem("41", R.drawable.genral_surgon,"General Surgon"));
        itemFunctionArrayList.add(new DataItem("42", R.drawable.groceries,"Groceries"));
        itemFunctionArrayList.add(new DataItem("43", R.drawable.gynacologist,"Gynecologist"));
        itemFunctionArrayList.add(new DataItem("44", R.drawable.hearing_dealer,"Hearing Aid Dealers"));
        itemFunctionArrayList.add(new DataItem("45", R.drawable.home_service,"Home Service"));
        itemFunctionArrayList.add(new DataItem("46", R.drawable.homyopathic_doctor,"Homepatic Doctor"));
        itemFunctionArrayList.add(new DataItem("47", R.drawable.images,"Images"));
        itemFunctionArrayList.add(new DataItem("48", R.drawable.insurance,"Insurance"));
        itemFunctionArrayList.add(new DataItem("49", R.drawable.interiors,"Interiors"));
        itemFunctionArrayList.add(new DataItem("50", R.drawable.internet_providers,"Internet Providers"));
        itemFunctionArrayList.add(new DataItem("51", R.drawable.person,"jobs"));
        itemFunctionArrayList.add(new DataItem("52", R.drawable.laproscopy,"Laproscopy"));
        itemFunctionArrayList.add(new DataItem("53", R.drawable.lawyer,"Lawyer"));
        itemFunctionArrayList.add(new DataItem("54", R.drawable.tv,"Live TV"));
        itemFunctionArrayList.add(new DataItem("55", R.drawable.home_loans,"Loans"));
        itemFunctionArrayList.add(new DataItem("56", R.drawable.school,"Motor Training School"));
        itemFunctionArrayList.add(new DataItem("57", R.drawable.music,"Music"));
        itemFunctionArrayList.add(new DataItem("58", R.drawable.ngos,"NGO"));
        itemFunctionArrayList.add(new DataItem("59", R.drawable.neurologist,"Neurologist"));
        itemFunctionArrayList.add(new DataItem("60", R.drawable.news,"News"));
        itemFunctionArrayList.add(new DataItem("61", R.drawable.bone_doctor,"Orthopadic"));
        itemFunctionArrayList.add(new DataItem("62", R.drawable.packers_movers,"Packers & Movers"));
        itemFunctionArrayList.add(new DataItem("63", R.drawable.paediatriction,"Padiatrician"));
        itemFunctionArrayList.add(new DataItem("64", R.drawable.party,"Party"));
        itemFunctionArrayList.add(new DataItem("65", R.drawable.pets,"Pets"));
        itemFunctionArrayList.add(new DataItem("66", R.drawable.printing_services,"Printing Services"));
        itemFunctionArrayList.add(new DataItem("67", R.drawable.account_icon,"Professional Services"));
        itemFunctionArrayList.add(new DataItem("68", R.drawable.real_estate,"Real Estate"));
        itemFunctionArrayList.add(new DataItem("69", R.drawable.sign_board,"Registration Consultant"));
        itemFunctionArrayList.add(new DataItem("70", R.drawable.taxi,"Rent or Hire"));
        itemFunctionArrayList.add(new DataItem("71", R.drawable.scrap_buyers,"Scrap Buyers"));
        itemFunctionArrayList.add(new DataItem("72", R.drawable.sign_board,"Sign Board Dealers"));
        itemFunctionArrayList.add(new DataItem("73", R.drawable.skin_hair_doctor,"Skin&Hair Doctors"));
        itemFunctionArrayList.add(new DataItem("74", R.drawable.aurvadicdoctor,"Skin Doctors"));
        itemFunctionArrayList.add(new DataItem("75", R.drawable.social,"Social"));
        itemFunctionArrayList.add(new DataItem("76", R.drawable.stock_quotes,"Stock Quotes"));
        itemFunctionArrayList.add(new DataItem("77", R.drawable.taxi,"Taxi"));
        itemFunctionArrayList.add(new DataItem("78", R.drawable.towing_service,"Towing Service"));
        itemFunctionArrayList.add(new DataItem("79", R.drawable.transportation,"Transporters"));
        itemFunctionArrayList.add(new DataItem("80", R.drawable.tyre_dealer,"Tyre Dealers"));
        itemFunctionArrayList.add(new DataItem("81", R.drawable.video,"Videos"));
        itemFunctionArrayList.add(new DataItem("82", R.drawable.wallpaper,"Wallpapers Dealers"));
        itemFunctionArrayList.add(new DataItem("83", R.drawable.website,"Website Designers"));
        itemFunctionArrayList.add(new DataItem("84", R.drawable.wedding,"Wedding"));
        itemFunctionArrayList.add(new DataItem("85", R.drawable.yoga_classes,"Yoga Classes"));




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
            dot[i].setTextSize(8);
            dot[i].setPadding(0,0,10,0);
            dot[i].setTextColor(getResources().getColor(R.color.colorAccent));
            layout_dot.addView(dot[i]);
        }
        //active dot
        dot[page_position].setTextColor(getResources().getColor(R.color.colorPrimary));
    }
}
