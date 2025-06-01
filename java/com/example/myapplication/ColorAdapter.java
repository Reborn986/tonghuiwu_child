package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

//继承自 RecyclerView.Adapter 用于MainActivity中的色卡RecyclerView
//只要是RecyclerView基本都需要写这个适配器
public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {
    private Context mContext;

    private List<MainActivity.Color> mColorList;

    class ViewHolder extends RecyclerView.ViewHolder {
        //也是RecyclerView必要的函数，简单的说这里就是绑定一下页面组件
        CardView cardView;
        ImageView colorImage;
        public ViewHolder(@NonNull View view) {
            super(view);
            cardView = (CardView) view;
            colorImage = (ImageView) view.findViewById(R.id.color_image);
        }
    }

    public ColorAdapter(List<MainActivity.Color> colorList) {
        mColorList = colorList;
    }//构造函数

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        //这里绑定了布局文件color_item.xml
        View view = LayoutInflater.from(mContext).inflate(R.layout.color_item, parent, false);
        //创建 ViewHolder 实例并将加载的视图传递给它
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainActivity.Color color = mColorList.get(position);
        Glide.with(mContext).load(color.getImageId()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.colorImage);
    }

    @Override
    public int getItemCount() {

        return mColorList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
