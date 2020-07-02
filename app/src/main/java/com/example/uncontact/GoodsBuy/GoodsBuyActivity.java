package com.example.uncontact.GoodsBuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uncontact.Adapter.GoodsBuyAdapter;
import com.example.uncontact.Adapter.RestaurantAdapter;
import com.example.uncontact.Do.DoActivity;
import com.example.uncontact.MainActivity;
import com.example.uncontact.Model.GoodsBuyItem;
import com.example.uncontact.Mypage.mypage;
import com.example.uncontact.R;
import com.example.uncontact.Res.RestaurantActivity;
import com.example.uncontact.Res.RestaurantDetailActivity;
import com.example.uncontact.Ride.RideActivity;
import com.example.uncontact.Stay.StayActivity;

import java.util.ArrayList;

public class GoodsBuyActivity extends AppCompatActivity implements GoodsBuyAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private ArrayList<GoodsBuyItem> list;
    private GoodsBuyAdapter adapter;
    private TextView btnGoosBuyRecomm,  btnGoodsBuyTravel,  tvGoodsBuyRes, tvGoodsBuyStay, tvGoodsBuyRide,btnGoodsBuyMypageSend, tvGoodsBuyDo;

    RecyclerView.LayoutManager mLayoutManager;
    String TAG = "GoodsBuyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_buy);

        btnGoosBuyRecomm = findViewById(R.id.btn_goos_buy_recomm);
        btnGoodsBuyMypageSend = findViewById(R.id.btn_goods_buy_mypageSend);
        tvGoodsBuyRes = findViewById(R.id.tv_goods_buy_res);
        tvGoodsBuyDo= findViewById(R.id.tv_goods_buy_do);
        tvGoodsBuyStay = findViewById(R.id.tv_goods_buy_stay);
        tvGoodsBuyRide = findViewById(R.id.tv_goods_buy_ride);


        //리사이클러뷰
        //리사이클러뷰 set
        recyclerView = findViewById(R.id.goods_buy_recyclerview);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);


        //리사이클러뷰 아이템 불러오기
        getData();

        //클릭리스너
        goClick();

    }



    //클릭리스너
    private void goClick() {

        //추천
        btnGoosBuyRecomm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRec =  new Intent(GoodsBuyActivity.this, MainActivity.class);
                startActivity(intentRec);
            }
        });
        //마이페이지
        btnGoodsBuyMypageSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMyPage =  new Intent(GoodsBuyActivity.this, mypage.class);
                startActivity(intentMyPage);
            }
        });
        //드슈
        tvGoodsBuyRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRes = new Intent(GoodsBuyActivity.this, RestaurantActivity.class);
                startActivity(intentRes);
            }
        });
        //하슈
        tvGoodsBuyDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRes = new Intent(GoodsBuyActivity.this, DoActivity.class);
                startActivity(intentRes);
            }
        });
        //자슈
        tvGoodsBuyStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStay = new Intent(GoodsBuyActivity.this, StayActivity.class);
                startActivity(intentStay);
            }
        });

        //타슈
        tvGoodsBuyRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRide = new Intent(GoodsBuyActivity.this, RideActivity.class);
                startActivity(intentRide);
            }
        });

    }

    //리사이클러뷰 아이템 넣기
    private void getData() {
        Log.i(TAG,"리사이클러뷰");

        ArrayList<GoodsBuyItem> list = new ArrayList<>();
        list.add(new GoodsBuyItem(R.drawable.gift,"기념품1","기념품에 관한 설명"));
        list.add(new GoodsBuyItem(R.drawable.gift,"기념품2","기념품에 관한 설명"));
        list.add(new GoodsBuyItem(R.drawable.gift,"기념품3","기념품에 관한 설명"));
        list.add(new GoodsBuyItem(R.drawable.gift,"기념품4","기념품에 관한 설명"));
        list.add(new GoodsBuyItem(R.drawable.gift,"기념품5","기념품에 관한 설명"));
        list.add(new GoodsBuyItem(R.drawable.gift,"기념품6","기념품에 관한 설명"));
        list.add(new GoodsBuyItem(R.drawable.gift,"기념품7","기념품에 관한 설명"));
        list.add(new GoodsBuyItem(R.drawable.gift,"기념품8","기념품에 관한 설명"));
        list.add(new GoodsBuyItem(R.drawable.gift,"기념품9","기념품에 관한 설명"));
        list.add(new GoodsBuyItem(R.drawable.gift,"기념품10","기념품에 관한 설명"));



        adapter = new GoodsBuyAdapter(list);
        recyclerView.setAdapter(adapter);

    }


    //리사이클러뷰 클릭이벤트
    @Override
    public void onItemClick(int position) {

    }
}
