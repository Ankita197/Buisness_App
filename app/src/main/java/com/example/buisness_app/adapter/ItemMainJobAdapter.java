package com.example.buisness_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buisness_app.R;
import com.example.buisness_app.model.ItemMainJob;

import java.util.ArrayList;

public class ItemMainJobAdapter extends RecyclerView.Adapter<ItemMainJobAdapter.ItemMainJobHolder> {

    private Context context;
    private ArrayList<ItemMainJob> itemMainJobArrayList;
    private ItemOnClick itemOnClick;

    public ItemMainJobAdapter(Context context, ArrayList<ItemMainJob> itemMainJobArrayList) {
        this.context = context;
        this.itemMainJobArrayList = itemMainJobArrayList;
    }

    @NonNull
    @Override
    public ItemMainJobHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mainjob,parent,false);
        return new ItemMainJobHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemMainJobHolder holder, final int position) {
        ItemMainJob itemMainJob=itemMainJobArrayList.get(position);
        holder.tvJobTitle.setText(itemMainJob.getJobTitle());
        holder.tvJobDescription.setText(itemMainJob.getJobDescription());
        holder.tvJobPostedPn.setText("Job Posted On  "+itemMainJob.getJobPostedOn());
        holder.tvLastDateToApply.setText("Last Date to Apply "+itemMainJob.getLastDateToApply());
        holder.tvNoOfVacancy.setText("No Of Vacancy "+String.valueOf(itemMainJob.getNoOfVacancy()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemOnClick.OnClick(position,holder);
            }
        });
    }
    public void setClick(ItemOnClick itemOnClick){
        this.itemOnClick=itemOnClick;
    }

    @Override
    public int getItemCount() {
        return itemMainJobArrayList.size();
    }

    public class ItemMainJobHolder extends RecyclerView.ViewHolder {
        TextView tvJobTitle,tvJobDescription,tvJobPostedPn,tvLastDateToApply,tvNoOfVacancy;
        public ItemMainJobHolder(@NonNull View itemView) {
            super(itemView);
            tvJobTitle=itemView.findViewById(R.id.tvJobTitle);
            tvJobDescription=itemView.findViewById(R.id.tvJobDescription);
            tvJobPostedPn=itemView.findViewById(R.id.tvPostedOn);
            tvLastDateToApply=itemView.findViewById(R.id.tvLastDateApply);
            tvNoOfVacancy=itemView.findViewById(R.id.tvNoOfVacancy);


        }
    }
}
