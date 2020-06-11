package com.example.buisness_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buisness_app.adapter.ItemListAdapter;
import com.example.buisness_app.adapter.ItemOnClick;
import com.example.buisness_app.model.ItemList;

import java.util.ArrayList;


public class ListFragMent extends Fragment{

    private RecyclerView rvItemList;
    private ArrayList<ItemList> itemListArrayList=new ArrayList<>();
    private ItemListAdapter itemListAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_list_frag_ment, container, false);
        init(view);
        setList();
        setClick();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    private void init(View view) {
        rvItemList=view.findViewById(R.id.rvItemList);
        itemListAdapter=new ItemListAdapter(getActivity(),itemListArrayList);
        rvItemList.setAdapter(itemListAdapter);
    }
    private void setClick() {
        itemListAdapter.setClick(new ItemOnClick() {
            @Override
            public void OnClick(int position, RecyclerView.ViewHolder holder) {
                startActivity(new Intent(getActivity(),ItemDetailsActivity.class));
            }
        });
    }

    private void setList() {
        itemListArrayList.add(new ItemList(R.drawable.school,"primary school","Rajkot,near hanuman ..",(float) 4.1));
        itemListArrayList.add(new ItemList(R.drawable.college,"primary school","Rajkot,near hanuman ..",(float) 5));
        itemListArrayList.add(new ItemList(R.drawable.school,"primary school","Rajkot,near hanuman ..",(float) 4.3));
        itemListArrayList.add(new ItemList(R.drawable.college,"primary school","Rajkot,near hanuman ..",(float) 4.2));
        itemListArrayList.add(new ItemList(R.drawable.school,"primary school","Rajkot,near hanuman ..",(float) 4.1));
        itemListArrayList.add(new ItemList(R.drawable.school,"primary school","Rajkot,near hanuman ..",(float) 4.1));
        itemListArrayList.add(new ItemList(R.drawable.college,"primary school","Rajkot,near hanuman ..",(float) 5));
        itemListArrayList.add(new ItemList(R.drawable.school,"primary school","Rajkot,near hanuman ..",(float) 4.3));
        itemListArrayList.add(new ItemList(R.drawable.college,"primary school","Rajkot,near hanuman ..",(float) 4.2));
        itemListArrayList.add(new ItemList(R.drawable.school,"primary school","Rajkot,near hanuman ..",(float) 4.1));

    }
}
