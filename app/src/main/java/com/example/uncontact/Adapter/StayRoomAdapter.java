package com.example.uncontact.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uncontact.Model.StayRoomItem;
import com.example.uncontact.R;

import java.util.ArrayList;

public class StayRoomAdapter extends RecyclerView.Adapter<StayRoomAdapter.ViewHolder> {

   ArrayList<StayRoomItem> list = new ArrayList<>();
   Context context;


    public StayRoomAdapter(ArrayList<StayRoomItem> list) {
        this.list = list;
    }

    //클릭리스너
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
    public StayRoomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_stay_detail,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StayRoomAdapter.ViewHolder holder, int position) {

        StayRoomItem item = list.get(position);

        holder.ivStayRoomImage.setImageResource(item.getStayRoomImage());
        holder.tvStayRoomName.setText(item.getStayRoomitle());
        holder.tvStayRoomContent.setText(item.getStayRoomContent());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //tv_stay_room_name, tv_stay_room_content, iv_stay_room_image
        ImageView ivStayRoomImage;
        TextView tvStayRoomName;
        TextView tvStayRoomContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivStayRoomImage = itemView.findViewById(R.id.iv_stay_room_image);
            tvStayRoomName = itemView.findViewById(R.id.tv_stay_room_name);
            tvStayRoomContent = itemView.findViewById(R.id.tv_stay_room_content);


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
        }
    }
}
