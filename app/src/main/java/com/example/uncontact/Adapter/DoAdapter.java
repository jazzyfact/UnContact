package com.example.uncontact.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uncontact.Model.DoItem;
import com.example.uncontact.R;

import java.util.ArrayList;

public class DoAdapter extends RecyclerView.Adapter<DoAdapter.ViewHolder> {


    private ArrayList<DoItem> list = new ArrayList<>();
    private Context context;
    private OnItemClickListener mListener;

    public DoAdapter(ArrayList<DoItem> list) {
        this.list = list;
    }

//    public DoAdapter(ArrayList<DoItem> list, Context context) {
//        this.list = list;
//        this.context = context;
//    }


    //클릭리스너/////////////////
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    //클릭리스너끝//////////////////////////////////////



    //
    @NonNull
    @Override
    public DoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_do,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoAdapter.ViewHolder holder, int position) {
        DoItem item = list.get(position);

        holder.ivDoImage.setImageResource(item.getDoImage());
        holder.tvDoTitle.setText(item.getDoTitle());
        holder.tvDoIntro.setText(item.getDoIntro());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivDoImage;
        TextView tvDoTitle;
        TextView tvDoIntro;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivDoImage = itemView.findViewById(R.id.iv_do_image);
            tvDoTitle = itemView.findViewById(R.id.tv_do_title);
            tvDoIntro = itemView.findViewById(R.id.tv_do_intro);

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
