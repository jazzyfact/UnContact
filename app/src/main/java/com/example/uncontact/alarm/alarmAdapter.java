package com.example.uncontact.alarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uncontact.MainReAdapter;
import com.example.uncontact.MainReData;
import com.example.uncontact.R;

import java.util.ArrayList;

public class alarmAdapter extends RecyclerView.Adapter<alarmAdapter.ViewHolder> {

    Context context;
    private ArrayList<alarmData> mData;
    public static String date;

    public alarmAdapter(ArrayList<alarmData> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public alarmAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext() ;
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_alarm, parent, false);
        return new alarmAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull alarmAdapter.ViewHolder holder, int position) {
        holder.tv_alarmText.setText(mData.get(position).getAlarmText());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    // 어댑터 뷰홀더 설정
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_alarmText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_alarmText = itemView.findViewById(R.id.tv_alarmText);
        }
    }

}
