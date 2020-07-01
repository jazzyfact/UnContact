package com.example.uncontact.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uncontact.Model.ResCartItem;
import com.example.uncontact.R;

import java.util.ArrayList;

public class ResCartListAdapter extends RecyclerView.Adapter<ResCartListAdapter.ViewHolder> {

    ArrayList<ResCartItem> list = new ArrayList<>();
    Context context;

    public ResCartListAdapter(ArrayList<ResCartItem> list) {
        this.list = list;
    }


    //클릭리스너
    private ResCartListAdapter.OnItemClickListener mListener = null ;

    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;
    }

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(ResCartListAdapter.OnItemClickListener listener) {
        this.mListener = listener ;
    }

    @NonNull
    @Override
    public ResCartListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_res_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResCartListAdapter.ViewHolder holder, int position) {

        ResCartItem item = list.get(position);

        holder.itemTvResPayTitle.setText(item.getItemTvResPayTitle());
        holder.itemTvResPayPrice.setText(String.valueOf(item.getItemTvResPayPrice()));
        holder.itemTvResPayDelete.setText(item.getItemTvResPayDelete());
        holder.itemTvResPayTotalPrice.setText(String.valueOf(item.getItemTvResPayTotalPrice()));
        holder.itemResPayMinus.setImageResource(item.getItemResPayMinus());
        holder.itemResPayCountNum.setText(String.valueOf(item.getItemResPayCountNum()));
        holder.itemResPayPlus.setImageResource(item.getItemResPayPlus());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView itemTvResPayTitle;
        TextView itemTvResPayPrice;
        TextView itemTvResPayDelete;
        TextView itemTvResPayTotalPrice;
        ImageView itemResPayMinus;
        TextView itemResPayCountNum;
        ImageView itemResPayPlus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemTvResPayTitle = itemView.findViewById(R.id.item_tv_res_pay_title);
            itemTvResPayPrice = itemView.findViewById(R.id.item_tv_res_pay_price);
            itemTvResPayDelete = itemView.findViewById(R.id.item_tv_res_pay_delete);
            itemTvResPayTotalPrice = itemView.findViewById(R.id.item_tv_res_pay_total_price);
            itemResPayMinus = itemView.findViewById(R.id.item_res_pay_minus);
            itemResPayCountNum = itemView.findViewById(R.id.item_res_pay_count_num);
            itemResPayPlus = itemView.findViewById(R.id.item_res_pay_plus);

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
