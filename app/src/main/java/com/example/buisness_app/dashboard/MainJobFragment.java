package com.example.buisness_app.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buisness_app.R;
import com.example.buisness_app.adapter.ItemMainJobAdapter;
import com.example.buisness_app.model.ItemMainJob;

import java.util.ArrayList;


public class MainJobFragment extends Fragment {

    private RecyclerView rvItemMainJob;
    private ArrayList<ItemMainJob> itemMainJobArrayList=new ArrayList<>();
    private ItemMainJobAdapter itemMainJobAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main_job, container, false);
        init(view);
        setList();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        itemMainJobAdapter=new ItemMainJobAdapter(getActivity(),itemMainJobArrayList);
        rvItemMainJob.setAdapter(itemMainJobAdapter);
    }

    private void setList() {
        for (int i = 0; i < 10; i++) {
            itemMainJobArrayList.add(new ItemMainJob("Android Devloper", "We are looking for enthusiastic fresher candidates to work on android platform ", "04/06/2020", "04/08/2020", 2));
        }
    }

    private void init(View view) {
        rvItemMainJob=view.findViewById(R.id.rvItemMainJob);
    }
}
