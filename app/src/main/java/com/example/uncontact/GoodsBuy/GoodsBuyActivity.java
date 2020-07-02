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
import com.example.uncontact.MainActivity;
import com.example.uncontact.Model.GoodsBuyItem;
import com.example.uncontact.Mypage.mypage;
import com.example.uncontact.R;
import com.example.uncontact.Res.RestaurantActivity;
import com.example.uncontact.Res.RestaurantDetailActivity;
import com.example.uncontact.Ride.RideActivity;
import com.example.uncontact.Stay.StayActivity;

import java.util.ArrayList;

public class GoodsBuyActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerView;
    private ArrayList<GoodsBuyItem> list;
    private GoodsBuyAdapter adapter;
    private TextView btnGoosBuyRecomm,  btnGoodsBuyTravel,  tvGoodsBuyRes, tvGoodsBuyStay, tvGoodsBuyRide,btnGoodsBuyMypageSend;

    RecyclerView.LayoutManager mLayoutManager;
    String TAG = "GoodsBuyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_buy);

        btnGoosBuyRecomm = findViewById(R.id.btn_goos_buy_recomm);
        btnGoodsBuyMypageSend = findViewById(R.id.btn_goods_buy_mypageSend);
        tvGoodsBuyRes = findViewById(R.id.tv_goods_buy_res);
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
        btnGoosBuyRecomm.setOnClickListener(this);
        btnGoodsBuyMypageSend.setOnClickListener(this);
        tvGoodsBuyRes.setOnClickListener(this);
        tvGoodsBuyStay.setOnClickListener(this);
        tvGoodsBuyRide.setOnClickListener(this);
    }

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


//        //어댑터클릭리스너
//        adapter.setOnItemClickListener(new RestaurantAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View v, int position) {
//                // 클릭했을때 원하는데로 처리해주는 부분
//                Toast myToast = Toast.makeText(getApplicationContext(),"포지션 눌렀다" + position, Toast.LENGTH_SHORT);
//                myToast.show();
//                Intent intentDetail = new Intent(GoodsBuyActivity.this, GoodsBuyDetailActivity.class);
//                startActivity(intentDetail);
//            }
//        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            //추천
            case R.id.btn_goos_buy_recomm:
                Intent intentRec =  new Intent(GoodsBuyActivity.this, MainActivity.class);
                startActivity(intentRec);
                break;

                //마이페이지
            case R.id.btn_goods_buy_mypageSend:
                Intent intentMyPage =  new Intent(GoodsBuyActivity.this, mypage.class);
                startActivity(intentMyPage);
                break;

            //드슈
            case R.id.tv_goods_buy_res:
                Intent intentRes = new Intent(GoodsBuyActivity.this, RestaurantActivity.class);
                startActivity(intentRes);
                break;
            //자슈
            case R.id.tv_goods_buy_stay:
                Intent intentStay = new Intent(GoodsBuyActivity.this, StayActivity.class);
                startActivity(intentStay);
                break;
            //타슈
            case R.id.tv_goods_buy_ride:
                Intent intentRide = new Intent(GoodsBuyActivity.this, RideActivity.class);
                startActivity(intentRide);
                break;



        }

    }
}
