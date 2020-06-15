package com.example.buisness_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buisness_app.R;
import com.example.buisness_app.model.ItemJob;

import java.util.ArrayList;

public class ItemJobAdapter extends RecyclerView.Adapter<ItemJobAdapter.ItemJobHolder> {

    private Context context;
    private ArrayList<ItemJob> listItemJob;

    public ItemJobAdapter(Context context, ArrayList<ItemJob> listItemJob) {
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
        ItemJob itemJob=listItemJob.get(position);
        holder.ivJobs.setImageResource(itemJob.getImgId());
        holder.tvJobs.setText(itemJob.getJobType());
    }

    @Override
    public int getItemCount() {
        return listItemJob.size();
    }

    public class ItemJobHolder extends RecyclerView.ViewHolder {
        ImageView ivJobs;
        TextView tvJobs;
        public ItemJobHolder(@NonNull View itemView) {
            super(itemView);
            tvJobs=itemView.findViewById(R.id.tvJob);
            ivJobs=itemView.findViewById(R.id.ivJob);
        }
    }
}
