package com.example.buisness_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buisness_app.R;
import com.example.buisness_app.model.ItemList;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemHolder> {

    private Context context;
    private ArrayList<ItemList> itemListArrayList;
    private ItemOnClick onClick;

    public ItemListAdapter(Context context, ArrayList<ItemList> itemListArrayList) {
        this.context = context;
        this.itemListArrayList = itemListArrayList;
    }
    public void setClick(ItemOnClick onClick){
        this.onClick=onClick;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dial_list,parent,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemHolder holder, final int position) {
        ItemList item=itemListArrayList.get(position);
        holder.ivPlace.setImageResource(item.getImgId());
        holder.tvName.setText(item.getName());
        holder.tvAddress.setText(item.getAddress());
        holder.rbRating.setRating(item.getRating());
        holder.tvRating.setText(String.valueOf(item.getRating()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.OnClick(position,holder);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemListArrayList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        ImageView ivPlace;
        TextView tvName,tvAddress,tvRating;
        RatingBar rbRating;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            ivPlace=itemView.findViewById(R.id.ivPlace);
            tvName=itemView.findViewById(R.id.tvName);
            tvAddress=itemView.findViewById(R.id.tvAddress);
            rbRating=itemView.findViewById(R.id.rbRating);
            tvRating=itemView.findViewById(R.id.tvRating);

        }
    }
}
