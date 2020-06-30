package com.example.uncontact.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Rating;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uncontact.Model.Travel;
import com.example.uncontact.R;

import java.util.ArrayList;

public class TravelAdapter extends RecyclerView.Adapter<TravelAdapter.ViewHolder> {

    ArrayList<Travel> list = new ArrayList<>();
//    private ArrayList<Travel> list = null;
    Context context;

    public TravelAdapter(ArrayList<Travel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    TravelAdapter(ArrayList<Travel> list) {
        list = list ;
    }


    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @NonNull
    @Override
    public TravelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_eatting, parent, false);

        return new ViewHolder(view);


    }
    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Travel item = list.get(position);

        holder.ivResImage.setImageDrawable(item.getImage());
        holder.tvResName.setText(item.getRestaurantName());
        holder.tvResIntro.setText(item.getRestaurantIntro());
//        holder.rbResStar.setRating(item.getRestaurantStar());


    }
// getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return list.size();
    }
    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView ivResImage;
        TextView tvResName;
        TextView tvResIntro;
        RatingBar rbResStar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // 뷰 객체에 대한 참조. (hold strong reference)
            ivResImage = itemView.findViewById(R.id.iv_res_image);
            tvResName = itemView.findViewById(R.id.tv_res_name);
            tvResIntro = itemView.findViewById(R.id.tv_res_intro);
            rbResStar = itemView.findViewById(R.id.ratingBar);




        }
    }
}
