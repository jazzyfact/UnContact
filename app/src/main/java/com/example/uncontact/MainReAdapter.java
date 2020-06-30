package com.example.uncontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    // 어댑터 뷰홀더 설정
    public class ViewHolder extends RecyclerView.ViewHolder {




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
