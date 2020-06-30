package com.example.uncontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainReAdapter extends RecyclerView.Adapter<MainReAdapter.ViewHolder> {


    Context context;
    private ArrayList<MainReData> mData;
    public static String date;


    // 어댑터 생성자
    // 어댑터 생성자
    public MainReAdapter(ArrayList<MainReData> mData) {
        this.mData = mData;
    }


    @NonNull
    @Override
    public MainReAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext() ;
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_main, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainReAdapter.ViewHolder holder, int position) {
        holder.tv_main_itemCartegory.setText(mData.get(position).mainReCategory);
        holder.tv_main_itemTitle.setText(mData.get(position).mainReTitle);
        holder.tv_main_itemContent.setText(mData.get(position).mainReContent);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    // 어댑터 뷰홀더 설정
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView tv_main_itemImage;
        TextView tv_main_itemCartegory;
        TextView tv_main_itemTitle;
        TextView tv_main_itemContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_main_itemImage = itemView.findViewById(R.id.tv_main_itemImage);
            tv_main_itemCartegory = itemView.findViewById(R.id.tv_main_itemCartegory);
            tv_main_itemTitle = itemView.findViewById(R.id.tv_main_itemTitle);
            tv_main_itemContent = itemView.findViewById(R.id.tv_main_itemImage);
        }
    }

}
