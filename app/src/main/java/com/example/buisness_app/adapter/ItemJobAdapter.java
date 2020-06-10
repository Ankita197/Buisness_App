package com.example.buisness_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buisness_app.R;

import java.util.ArrayList;

public class ItemJobAdapter extends RecyclerView.Adapter<ItemJobAdapter.ItemJobHolder> {

    private Context context;
    private ArrayList<String> listItemJob;

    public ItemJobAdapter(Context context, ArrayList<String> listItemJob) {
        this.context = context;
        this.listItemJob = listItemJob;
    }

    @NonNull
    @Override
    public ItemJobHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jobs,parent,false);
        return new ItemJobHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemJobHolder holder, int position) {
        holder.tvJobs.setText(listItemJob.get(position));
    }

    @Override
    public int getItemCount() {
        return listItemJob.size();
    }

    public class ItemJobHolder extends RecyclerView.ViewHolder {
        TextView tvJobs;
        public ItemJobHolder(@NonNull View itemView) {
            super(itemView);
            tvJobs=itemView.findViewById(R.id.tvJob);
        }
    }
}
