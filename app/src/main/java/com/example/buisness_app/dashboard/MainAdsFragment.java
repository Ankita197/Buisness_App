package com.example.buisness_app.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buisness_app.R;
import com.example.buisness_app.adapter.ItemAdsAdapter;
import com.example.buisness_app.adapter.ItemOnClick;
import com.example.buisness_app.dashboard.subfragment.AdsDetailsFragment;
import com.example.buisness_app.model.ItemAd;

import java.util.ArrayList;

public class MainAdsFragment extends Fragment {

    private RecyclerView rvItemAds;
    private ItemAdsAdapter itemAdsAdapter;
    private ArrayList<ItemAd> itemAdArrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main_ads, container, false);
        init(view);
        setList();
        setAdapter();
        setItemClick();
        return view;
    }

    private void setItemClick() {
        itemAdsAdapter.setItemClick(new ItemOnClick() {
            @Override
            public void OnClick(int position, RecyclerView.ViewHolder holder) {
                getFragmentManager().beginTransaction().replace(R.id.container,new AdsDetailsFragment(),"ads details")
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private void setAdapter() {
        itemAdsAdapter=new ItemAdsAdapter(getActivity(),itemAdArrayList);
        rvItemAds.setAdapter(itemAdsAdapter);
    }

    private void setList() {

       for(int i=0;i<10;i++) {
           itemAdArrayList.add(new ItemAd(R.drawable.school, "For covid 19", "corona se daro na sidhe aarogy setu app par aao na mask banane ki puri jankari apko aarogy setu app par mil jayegi", "By | Amitabh bachan"));
       }
    }

    private void init(View view) {
        rvItemAds=view.findViewById(R.id.rvItemAds);
    }
}
