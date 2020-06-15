package com.example.buisness_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buisness_app.adapter.ItemJobAdapter;
import com.example.buisness_app.model.ItemJob;

import java.util.ArrayList;


public class JobsFragment extends Fragment {
    private RecyclerView rvItemJobs;
    private ArrayList<ItemJob> itemJobArrayList=new ArrayList<>();
    private ItemJobAdapter itemJobAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_jobs, container, false);
        setList();
        init(view);
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    private void setList() {
        itemJobArrayList.add(new ItemJob(R.drawable.accountant_job,"Accounts"));
        itemJobArrayList.add(new ItemJob(R.drawable.alljobs_job,"All Jobs"));
        itemJobArrayList.add(new ItemJob(R.drawable.bpo_job,"BPO"));
        itemJobArrayList.add(new ItemJob(R.drawable.bankofficer_job,"Bank Officer"));
        itemJobArrayList.add(new ItemJob(R.drawable.banks_job,"Bank"));
        itemJobArrayList.add(new ItemJob(R.drawable.callcenter_job,"Call Center"));
        itemJobArrayList.add(new ItemJob(R.drawable.driver_job,"Driver"));
        itemJobArrayList.add(new ItemJob(R.drawable.money,"Finance"));
        itemJobArrayList.add(new ItemJob(R.drawable.hr_job,"HR"));
        itemJobArrayList.add(new ItemJob(R.drawable.it_industry_icon,"IT industry"));
        itemJobArrayList.add(new ItemJob(R.drawable.mechanical_job,"Mechanical Engineer"));
        itemJobArrayList.add(new ItemJob(R.drawable.mechanical_indu_job,"Mechanical Industry"));
        itemJobArrayList.add(new ItemJob(R.drawable.jewellery_job,"Jewellery Industry"));
        itemJobArrayList.add(new ItemJob(R.drawable.security_staff_job,"Security Staff"));
        itemJobArrayList.add(new ItemJob(R.drawable.tuter_job,"Tutor"));
        itemJobArrayList.add(new ItemJob(R.drawable.marketing_executive_job,"Marketing Executive"));
        itemJobArrayList.add(new ItemJob(R.drawable.hotelindustries_job,"Hotal Industry"));
        itemJobArrayList.add(new ItemJob(R.drawable.work_from_hom_job,"Work From Home"));


    }

    private void init(View view) {
        rvItemJobs=view.findViewById(R.id.rvItemJobs);
        itemJobAdapter=new ItemJobAdapter(getActivity(),itemJobArrayList);
        rvItemJobs.setAdapter(itemJobAdapter);
    }
}
