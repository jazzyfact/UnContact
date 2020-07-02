package com.example.uncontact.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uncontact.Model.StayItem;
import com.example.uncontact.R;

import java.util.ArrayList;

public class StayAdapter extends RecyclerView.Adapter<StayAdapter.ViewHolder> {

    ArrayList<StayItem> list = new ArrayList<>();
    Context context;

    public StayAdapter(ArrayList<StayItem> list) {
        this.list = list;
    }



    //클릭이벤트
    private RestaurantAdapter.OnItemClickListener mListener = null ;

    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;
    }

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(RestaurantAdapter.OnItemClickListener listener) {
        this.mListener = listener ;
    }

    @NonNull
    @Override
    public StayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_stay,parent,false);

        return new ViewHolder(view);
    }


    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(@NonNull StayAdapter.ViewHolder holder, int position) {

        StayItem item = list.get(position);

        holder.ivStayImage.setImageResource(item.getStayImage());
        holder.tvStayTitle.setText(item.getStayTitle());
        holder.tvStayIntro.setText(item.getStayIntro());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //tv_stay_title iv_stay_image tv_stay_intro
        ImageView ivStayImage;
        TextView tvStayTitle;
        TextView tvStayIntro;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivStayImage =itemView.findViewById(R.id.iv_stay_image);
            tvStayTitle = itemView.findViewById(R.id.tv_stay_title);
            tvStayIntro = itemView.findViewById(R.id.tv_stay_intro);

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
