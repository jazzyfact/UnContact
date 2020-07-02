package com.example.uncontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uncontact.Adapter.DoAdapter;

import java.util.ArrayList;

public class MainReAdapter extends RecyclerView.Adapter<MainReAdapter.ViewHolder> {


    Context context;
    private ArrayList<MainReData> mData;
    public static String date;

    //클릭리스너
    private OnItemClickListener mListener;

    //클릭리스너/////////////////
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    //클릭리스너끝//////////////////////////////////////




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
//
//        if(mData.get(position).mainReImage.equals("R.drawable.citytour")) {
//            holder.tv_main_itemImage.setImageResource(R.drawable.citytour);
//        } else if (mData.get(position).mainReImage.equals("R.drawable.toto")){
//            holder.tv_main_itemImage.setImageResource(R.drawable.toto);
//        } else if (mData.get(position).mainReImage.equals("R.drawable.tashu")){
//            holder.tv_main_itemImage.setImageResource(R.drawable.tashu);
//        } else if(mData.get(position).mainReImage.equals("R.drawable.manbal")){
//            holder.tv_main_itemImage.setImageResource(R.drawable.manbal);
//        } else if(mData.get(position).mainReImage.equals("R.drawable.onchun")){
//            holder.tv_main_itemImage.setImageResource(R.drawable.onchun);
//        } else if(mData.get(position).mainReImage.equals("R.drawable.untact")){
//            holder.tv_main_itemImage.setImageResource(R.drawable.untact);
//        } else {
//            holder.tv_main_itemImage.setImageResource(R.drawable.deachung);
//        }

        holder.tv_main_itemImage.setImageResource(mData.get(position).mainReImage);
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
            tv_main_itemContent = itemView.findViewById(R.id.tv_main_itemContent);

            //클릭리스너
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){

                        if(mListener != null){
                            mListener.onItemClick(position);

                        }
                    }
                }
            });

            ////////////클릭이번트 끝
        }
    }

}
