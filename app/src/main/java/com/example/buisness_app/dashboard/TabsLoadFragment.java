package com.example.buisness_app.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.buisness_app.ListFragMent;
import com.example.buisness_app.R;
import com.example.buisness_app.adapter.TabChangeAdapter;
import com.google.android.material.tabs.TabLayout;


public class TabsLoadFragment extends Fragment {
    private TabLayout tlItem;
    private ViewPager viewPager;
    private TabChangeAdapter tabChangeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tabs_load, container, false);
        tlItem = view.findViewById(R.id.tlItem);
        viewPager=view.findViewById(R.id.container);
        setTabs();
        tabChangeAdapter=new TabChangeAdapter(getChildFragmentManager(),3);
        viewPager.setAdapter(tabChangeAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tlItem));
        setOnTabSelect();
        switchFragment(new ListFragMent(),"list Fragment");
        tlItem.setSelected(true);
        return view;
    }
    private void setTabs() {
        TabLayout.Tab firstTab = tlItem.newTab(); // Create a new Tab names "First Tab"
        firstTab.setText("list"); // set the Text for the first Tab
        tlItem.addTab(firstTab,true);
        TabLayout.Tab secondTab = tlItem.newTab();
        secondTab.setText("map"); // set the Text for the second Tab
        tlItem.addTab(secondTab);
        TabLayout.Tab thirdTab = tlItem.newTab();
        thirdTab.setText("jobs"); // set the Text for the third Tab
        tlItem.addTab(thirdTab);
    }

    private void switchFragment(Fragment fragment,String fragmentId) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, fragmentId)
                .addToBackStack(fragmentId);
        fragmentTransaction.commit();
    }

    private void setOnTabSelect() {
        tlItem.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // setTab(tab.getPosition());
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

    }
}
