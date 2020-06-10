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
import com.example.buisness_app.model.ItemAd;

import java.util.ArrayList;

public class ItemAdsAdapter extends RecyclerView.Adapter<ItemAdsAdapter.ItemAdHolder> {

    Context context;
    ArrayList<ItemAd> itemAdArrayList;

    public ItemAdsAdapter(Context context, ArrayList<ItemAd> itemAdArrayList) {
        this.context = context;
        this.itemAdArrayList = itemAdArrayList;
    }

    @NonNull
    @Override
    public ItemAdHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ads,parent,false);
        return new ItemAdHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdHolder holder, int position) {
    ItemAd itemAd=itemAdArrayList.get(position);
    holder.tvAdsTitle.setText(itemAd.getAdsTitle());
    holder.tvAdsDescription.setText(itemAd.getAdsDescription());
    holder.tvAdBy.setText(itemAd.getAdsBy());
    holder.ivAds.setImageResource(itemAd.getImgId());
    }

    @Override
    public int getItemCount() {
        return itemAdArrayList.size();
    }

    public class ItemAdHolder extends RecyclerView.ViewHolder {
        TextView tvAdsTitle,tvAdsDescription,tvAdBy;
        ImageView ivAds;
        public ItemAdHolder(@NonNull View itemView) {
            super(itemView);
            ivAds=itemView.findViewById(R.id.ivAds);
            tvAdsTitle=itemView.findViewById(R.id.tvAdsTitle);
            tvAdsDescription=itemView.findViewById(R.id.tvAdsDescription);
            tvAdBy=itemView.findViewById(R.id.tvAdBy);
        }
    }
}
