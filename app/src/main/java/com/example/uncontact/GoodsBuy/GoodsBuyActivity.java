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
import com.example.uncontact.Do.DoDetailActivity;
import com.example.uncontact.MainActivity;
import com.example.uncontact.Model.GoodsBuyItem;
import com.example.uncontact.Mypage.mypage;
import com.example.uncontact.R;
import com.example.uncontact.Res.RestaurantActivity;
import com.example.uncontact.Res.RestaurantDetailActivity;
import com.example.uncontact.Ride.RideActivity;
import com.example.uncontact.Stay.StayActivity;

import java.util.ArrayList;

public class GoodsBuyActivity extends AppCompatActivity implements GoodsBuyAdapter.OnItemClickListener, View.OnClickListener {

    private RecyclerView recyclerView;
    private ArrayList<GoodsBuyItem> list;
    private GoodsBuyAdapter adapter;
    private GoodsBuyItem item;
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
                //애니메이션 제거
                intentRec.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intentRec);
            }
        });
        //마이페이지
        btnGoodsBuyMypageSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMyPage =  new Intent(GoodsBuyActivity.this, mypage.class);
                //애니메이션 제거
                intentMyPage.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intentMyPage);
            }
        });
        //드슈
        tvGoodsBuyRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRes = new Intent(GoodsBuyActivity.this, RestaurantActivity.class);
                //애니메이션 제거
                intentRes.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intentRes);
            }
        });
        //하슈
        tvGoodsBuyDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRes = new Intent(GoodsBuyActivity.this, DoActivity.class);
                //애니메이션 제거
                intentRes.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intentRes);
            }
        });
        //자슈
        tvGoodsBuyStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStay = new Intent(GoodsBuyActivity.this, StayActivity.class);
                //애니메이션 제거
                intentStay.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intentStay);
            }
        });

        //타슈
        tvGoodsBuyRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRide = new Intent(GoodsBuyActivity.this, RideActivity.class);
                //애니메이션 제거
                intentRide.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intentRide);
            }
        });

    }

    //리사이클러뷰 아이템 넣기
    private void getData() {
        Log.i(TAG,"리사이클러뷰");

        list = new ArrayList<>();
        list.add(new GoodsBuyItem(R.drawable.g_1,"제23회 관광기념품공모전  대상","서애진"));
        list.add(new GoodsBuyItem(R.drawable.g_2,"제23회 관광기념품공모전 금상","임미숙"));
        list.add(new GoodsBuyItem(R.drawable.g_3,"제23회 관광기념품공모전 은상","박희창"));
        list.add(new GoodsBuyItem(R.drawable.g_4,"제23회 관광기념품공모전 동상","길순정"));
        list.add(new GoodsBuyItem(R.drawable.g_5,"제23회 관광기념품공모전 장려","김한솔"));
        list.add(new GoodsBuyItem(R.drawable.g_6,"제23회 관광기념품공모전 장려","송인길"));
        list.add(new GoodsBuyItem(R.drawable.g_7,"제23회 관광기념품공모전 특선","육동창"));
        list.add(new GoodsBuyItem(R.drawable.g_8,"제23회 관광기념품공모전 특선","이충규, 김지연"));
        list.add(new GoodsBuyItem(R.drawable.g_9,"제23회 관광기념품공모전 특선","조윤상"));
        list.add(new GoodsBuyItem(R.drawable.g_10,"제23회 관광기념품공모전 특선","조윤주"));



        adapter = new GoodsBuyAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(GoodsBuyActivity.this);


    }


    //리사이클러뷰 클릭이벤트
    @Override
    public void onItemClick(int position) {

        Intent intentDo = new Intent(GoodsBuyActivity.this, GoodsBuyDetailActivity.class);

        item = list.get(position);

        intentDo.putExtra("image",item.getGoodsImage());
        intentDo.putExtra("title",item.getGoosTitle());
        intentDo.putExtra("intro",item.getGoosIntro());

        startActivity(intentDo);

    }

    @Override
    public void onClick(View v) {

    }
}
