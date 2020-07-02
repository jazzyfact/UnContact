package com.example.uncontact.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uncontact.Model.GoodsBuyItem;
import com.example.uncontact.R;

import java.util.ArrayList;

public class GoodsBuyAdapter extends RecyclerView.Adapter<GoodsBuyAdapter.ViewHolder> {

    ArrayList<GoodsBuyItem> list = new ArrayList<>();
    Context context;
    private OnItemClickListener mListener;


    public GoodsBuyAdapter(ArrayList<GoodsBuyItem> list) {
        this.list = list;
    }


    //클릭리스너
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }



    @NonNull
    @Override
    public GoodsBuyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_goods_buy,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull GoodsBuyAdapter.ViewHolder holder, int position) {

        GoodsBuyItem item = list.get(position);

        holder.ivGoodsBuyImage.setImageResource(item.getGoodsImage());
        holder.tvGoodsBuyTitle.setText(item.getGoosTitle());
        holder.tvGoodsBuyIntro.setText(item.getGoosIntro());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivGoodsBuyImage;
        TextView tvGoodsBuyTitle;
        TextView tvGoodsBuyIntro;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivGoodsBuyImage = itemView.findViewById(R.id.iv_goods_buy_image);
            tvGoodsBuyTitle = itemView.findViewById(R.id.tv_goods_buy_title);
            tvGoodsBuyIntro = itemView.findViewById(R.id.tv_goods_buy_intro);

            //클릭리스너
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("확인","레스토랑액티비티어댑터 클릭");
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
            ////////////클릭리스너 끝//////////////////////


        }
    }
}
