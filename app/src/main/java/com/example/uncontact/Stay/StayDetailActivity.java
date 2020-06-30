package com.example.uncontact.Stay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.uncontact.Adapter.RestaurantAdapter;
import com.example.uncontact.Adapter.RestaurantMenuAdapter;
import com.example.uncontact.Adapter.StayRoomAdapter;
import com.example.uncontact.Model.StayRoomItem;
import com.example.uncontact.R;
import com.example.uncontact.Res.ResSelectMenuActivity;
import com.example.uncontact.Res.RestaurantDetailActivity;

import java.util.ArrayList;

public class StayDetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<StayRoomItem> list;
    private StayRoomAdapter adapter;


    RecyclerView.LayoutManager mLayoutManager;
    String TAG = "StayDetailActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stay_detail);


        //리사이클러뷰 set
        recyclerView = findViewById(R.id.stay_detail_recylcerview);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        //리사이클러뷰 아이템 불러오기
        getData();

    }

    private void getData() {
        ArrayList<StayRoomItem> list = new ArrayList<>();
        list.add(new StayRoomItem(R.drawable.ic_bed,"룸1","룸 설명"));
        list.add(new StayRoomItem(R.drawable.ic_bed,"룸2","룸 설명"));
        list.add(new StayRoomItem(R.drawable.ic_bed,"룸3","룸 설명"));


        adapter = new StayRoomAdapter(list);
        recyclerView.setAdapter(adapter);

        //어댑터클릭리스너
        adapter.setOnItemClickListener(new RestaurantAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                // 클릭했을때 원하는데로 처리해주는 부분
                Toast myToast = Toast.makeText(getApplicationContext(),"포지션 눌렀다" + position, Toast.LENGTH_SHORT);
                myToast.show();
                Intent intentDetail = new Intent(StayDetailActivity.this, StayRoomSelectActivity.class);
                startActivity(intentDetail);
            }
        });

    }
}
