package com.example.uncontact.Mypage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uncontact.MainReAdapter;
import com.example.uncontact.R;

import java.util.ArrayList;

public class mypageAdapter extends RecyclerView.Adapter<mypageAdapter.ViewHolder> {
    Context context;
    private ArrayList<mypagePaymentData> mData;
    public static String date;

    // 어댑터 생성자
    public mypageAdapter(ArrayList<mypagePaymentData> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public mypageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_mypagepayment, parent, false);
        return new mypageAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull mypageAdapter.ViewHolder holder, int position) {
        holder.res_mypage_price.setText(String.valueOf(mData.get(position).getPrice()));
        holder.res_mypage_title.setText(mData.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView res_mypage_price;
        TextView res_mypage_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            res_mypage_price = itemView.findViewById(R.id.res_mypage_price);
            res_mypage_title = itemView.findViewById(R.id.res_mypage_title);
        }
    }

}