package com.example.uncontact.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uncontact.Model.GoodsCartItem;
import com.example.uncontact.R;

import java.util.ArrayList;

public class GoodsCartListAdapter extends RecyclerView.Adapter<GoodsCartListAdapter.ViewHolder> {

    ArrayList<GoodsCartItem> list = new ArrayList<>();
    Context context;

    public GoodsCartListAdapter(ArrayList<GoodsCartItem> list) {
        this.list = list;
    }

    //클릭리스너
    private GoodsCartListAdapter.OnItemClickListener mListener = null ;

    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;
    }

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(GoodsCartListAdapter.OnItemClickListener listener) {
        this.mListener = listener ;
    }


    @NonNull
    @Override
    public GoodsCartListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_goosbuy_cart,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsCartListAdapter.ViewHolder holder, int position) {

        GoodsCartItem item = list.get(position);

        holder.itemTvGoodsBuyCartTitle.setText(item.getItemTvGoodsBuyCartTitle());
        holder.itemTvGoodsBuyCartPrice.setText(String.valueOf(item.getItemTvGoodsBuyCartPrice()));
        holder.itemTvGoodsBuyCartDelete.setText(item.getItemTvGoodsBuyCartDelete());
        holder.itemTvGoodsBuyCartTotalPrice.setText(String.valueOf(item.getItemTvGoodsBuyCartTotalPrice()));
        holder.itemGoodsBuyCartMinus.setImageResource(item.getItemGoodsBuyCartMinus());
        holder.itemGoodsBuyCartCountNum.setText(String.valueOf(item.getItemGoodsBuyCartCountNum()));
        holder.itemGoodsBuyCartPlus.setImageResource(item.getItemGoodsBuyCartPlus());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView itemTvGoodsBuyCartTitle;
        TextView itemTvGoodsBuyCartPrice;
        TextView itemTvGoodsBuyCartDelete;
        TextView itemTvGoodsBuyCartTotalPrice;
        ImageView itemGoodsBuyCartMinus;
        TextView itemGoodsBuyCartCountNum;
        ImageView itemGoodsBuyCartPlus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemTvGoodsBuyCartTitle = itemView.findViewById(R.id.item_tv_goodsbuy_cart_title);
            itemTvGoodsBuyCartPrice = itemView.findViewById(R.id.item_tv_goodsbuy_cart_price);
            itemTvGoodsBuyCartDelete = itemView.findViewById(R.id.item_tv_goodsbuy_cart_delete);
            itemTvGoodsBuyCartTotalPrice = itemView.findViewById(R.id.item_tv_goodsbuy_cart_price);
            itemGoodsBuyCartMinus =itemView.findViewById(R.id.item_goodsbuy_cart_minus);
            itemGoodsBuyCartCountNum = itemView.findViewById(R.id.item_goodsbuy_cart_count_num);
            itemGoodsBuyCartPlus = itemView.findViewById(R.id.item_goodsbuy_cart_plus);


            //클릭리스너
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){

                        if(mListener != null){
                            mListener.onItemClick(v,position);


                        }

                    }
                }
            });

        }
    }
}
