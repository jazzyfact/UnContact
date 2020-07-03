package com.example.uncontact.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uncontact.Model.ResMenuItem;
import com.example.uncontact.R;

import java.util.ArrayList;

public class RestaurantMenuAdapter extends RecyclerView.Adapter<RestaurantMenuAdapter.ViewHolder> {

   ArrayList<ResMenuItem> list = new ArrayList<>();
    Context context;
    private OnItemClickListener mListener;

    public RestaurantMenuAdapter(ArrayList<ResMenuItem> list) {
        this.list = list;
    }

    //클릭리스너


    //클릭리스너/////////////////
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    //클릭리스너끝//////////////////////////////////////


    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @NonNull
    @Override
    public RestaurantMenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_res_detail, parent, false);

        return new ViewHolder(view);
    }


    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(@NonNull RestaurantMenuAdapter.ViewHolder holder, int position) {

        ResMenuItem item = list.get(position);

        holder.ivResMenuImage.setImageResource(item.getResMenuImage());
        holder.tvResMenuTitle.setText(item.getResMenuTitle());
        holder.tvREsMenuContent.setText(item.getResMenuContent());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivResMenuImage;
        TextView tvResMenuTitle;
        TextView tvREsMenuContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivResMenuImage = itemView.findViewById(R.id.iv_res_menu_image);
            tvResMenuTitle = itemView.findViewById(R.id.tv_res_menu_name);
            tvREsMenuContent = itemView.findViewById(R.id.tv_res_menu_content);

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
