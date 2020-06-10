package com.example.buisness_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buisness_app.adapter.ItemJobAdapter;

import java.util.ArrayList;


public class JobsFragment extends Fragment {
    private RecyclerView rvItemJobs;
    private ArrayList<String> itemJobArrayList=new ArrayList<>();
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
        itemJobArrayList.add("Madical Representative");
        itemJobArrayList.add("HR");
        itemJobArrayList.add("Devloper");
        itemJobArrayList.add("Financial Manager");
        itemJobArrayList.add("Madical Representative");
        itemJobArrayList.add("HR");
        itemJobArrayList.add("Devloper");
        itemJobArrayList.add("Financial Manager");
        itemJobArrayList.add("Devloper");
        itemJobArrayList.add("Financial Manager");
        itemJobArrayList.add("Devloper");
        itemJobArrayList.add("Financial Manager");
        itemJobArrayList.add("Devloper");
        itemJobArrayList.add("Financial Manager");

    }

    private void init(View view) {
        rvItemJobs=view.findViewById(R.id.rvItemJobs);
        itemJobAdapter=new ItemJobAdapter(getActivity(),itemJobArrayList);
        rvItemJobs.setAdapter(itemJobAdapter);
    }
}
