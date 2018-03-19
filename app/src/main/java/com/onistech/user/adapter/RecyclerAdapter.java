package com.onistech.user.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.onistech.user.model.CardItem;
import com.onistech.user.moranmandi.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<CardItem> itemList;

    public RecyclerAdapter(Context mContext, List<CardItem> albumList) {
        this.mContext = mContext;
        this.itemList = albumList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CardItem cardItem = itemList.get(position);
        Glide.with(mContext).load(cardItem.getThumbnail()).into(((MyViewHolder) holder).thumnail);
        ((MyViewHolder) holder).itemText.setText(cardItem.getName());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView thumnail;
        public TextView itemText;

        public MyViewHolder(View itemView) {
            super(itemView);
            thumnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            itemText = (TextView) itemView.findViewById(R.id.title);
        }
    }

   /* public class HeaderViewHolder extends RecyclerView.ViewHolder {
        public SliderLayout sliderLayout;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            sliderLayout = (SliderLayout) itemView.findViewById(R.id.slider);
        }
    }*/

}
