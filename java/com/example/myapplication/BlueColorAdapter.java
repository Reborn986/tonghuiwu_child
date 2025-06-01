package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BlueColorAdapter extends RecyclerView.Adapter<BlueColorAdapter.ViewHolder> {
    private Context mContext;

    private List<SekaBlue.BlueColor> mColorList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView colorImage;


        public ViewHolder(@NonNull View view) {
            super(view);
            cardView = (CardView) view;
            colorImage = (ImageView) view.findViewById(R.id.color_card_image);
        }
    }

    public BlueColorAdapter(List<SekaBlue.BlueColor> colorList) {
        mColorList = colorList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.color_card_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SekaBlue.BlueColor blueColor = mColorList.get(position);
        holder.colorImage.setImageResource(blueColor.getImageId());
    }

    @Override
    public int getItemCount() {
        return mColorList.size();
    }
}
