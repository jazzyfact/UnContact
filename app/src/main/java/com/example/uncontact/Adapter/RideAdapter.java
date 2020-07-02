package com.example.uncontact.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uncontact.Model.RideItem;
import com.example.uncontact.R;

import java.util.ArrayList;

public class RideAdapter extends RecyclerView.Adapter<RideAdapter.ViewHolder> {

    ArrayList<RideItem> list = new ArrayList<>();
    Context context;
    private OnItemClickListener mListener;

    public RideAdapter(ArrayList<RideItem> list) {
        this.list = list;
    }

    //클릭리스너/////////////////
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    //클릭리스너끝//////////////////////////////////////



    @NonNull
    @Override
    public RideAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_ride, parent, false);
        return new ViewHolder(view);
    }


    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(@NonNull RideAdapter.ViewHolder holder, int position) {

        RideItem item = list.get(position);

        holder.ivRideImage.setImageResource(item.getRideImage());
        holder.tvRideTitle.setText(item.getRideTitle());
        holder.tvRideIntro.setText(item.getRideIntro());

    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return list.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivRideImage;
        TextView tvRideTitle;
        TextView tvRideIntro;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivRideImage = itemView.findViewById(R.id.iv_ride_image);
            tvRideTitle = itemView.findViewById(R.id.tv_ride_title);
            tvRideIntro = itemView.findViewById(R.id.tv_ride_intro);

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
