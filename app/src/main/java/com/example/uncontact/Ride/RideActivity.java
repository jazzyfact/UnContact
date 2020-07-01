package com.example.uncontact.Ride;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uncontact.Adapter.RestaurantAdapter;
import com.example.uncontact.Adapter.RideAdapter;
import com.example.uncontact.GoodsBuy.GoodsBuyActivity;
import com.example.uncontact.MainActivity;
import com.example.uncontact.Model.RideItem;
import com.example.uncontact.Mypage.mypage;
import com.example.uncontact.R;
import com.example.uncontact.Res.RestaurantActivity;
import com.example.uncontact.Stay.StayActivity;

import java.util.ArrayList;

public class RideActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private ArrayList<RideItem> list;
    private RideAdapter adapter;

    RecyclerView.LayoutManager mLayoutManager;
    String TAG = "RideActivity";

    private TextView tvBtnRestaur, btnRideRravel, btnRideRecomme,tvBtnBuy, tvBtnStay, tvBtnRide, btnRideMypageSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride);

        btnRideRecomme = findViewById(R.id.btn_ride_recomme);
        btnRideMypageSend = findViewById(R.id.btn_ride_mypageSend);
//        btnRideRravel = findViewById(R.id.btn_ride_travel);
        tvBtnRestaur = findViewById(R.id.tv_ride_res);
        tvBtnBuy = findViewById(R.id.tv_ride_buy);
        tvBtnStay = findViewById(R.id.tv_ride_stay);
        tvBtnRide = findViewById(R.id.tv_ride_ride);

        //리사이클러뷰 set
        recyclerView = findViewById(R.id.ride_recyclerview);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);



        //클릭이벤트
        btnRideRecomme.setOnClickListener(this);
        btnRideMypageSend.setOnClickListener(this);
        tvBtnRestaur.setOnClickListener(this);
        tvBtnBuy.setOnClickListener(this);
        tvBtnStay.setOnClickListener(this);
////        tvBtnRide.setOnClickListener(this);


//        btRecommendation.setOnClickListener(this);
//        tvBtnRestaur.setOnClickListener(this);
//        tvBtnBuy.setOnClickListener(this);
//        tvBtnStay.setOnClickListener(this);
//        tvBtnRide.setOnClickListener(this);

        //리사이클러뷰 아이템 불러오기
        getData();

    }

    private void getData() {

        ArrayList<RideItem> list = new ArrayList<>();
        list.add(new RideItem(R.drawable.bus, "교통 1일권", "지하철 버스 타슈 무제한 사용 가능"));
        list.add(new RideItem(R.drawable.bus, "교통 3일권", "지하철 버스 타슈 무제한 사용 가능"));
        list.add(new RideItem(R.drawable.bus, "교통 7일권", "지하철 버스 타슈 무제한 사용 가능"));

        adapter = new RideAdapter(list);
        recyclerView.setAdapter(adapter);


        //어댑터클릭리스너
        adapter.setOnItemClickListener(new RestaurantAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                // 클릭했을때 원하는데로 처리해주는 부분
                Toast myToast = Toast.makeText(getApplicationContext(), "포지션 눌렀다" + position, Toast.LENGTH_SHORT);
                myToast.show();
                Intent intentDetail = new Intent(RideActivity.this, RideCartActivity.class);
                startActivity(intentDetail);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //추천
            case R.id.btn_ride_recomme:
                Intent intentRec = new Intent(RideActivity.this, MainActivity.class);
                startActivity(intentRec);
                break;
            //마이페이지
            case R.id.btn_ride_mypageSend:
                Intent intentMyPage =  new Intent(RideActivity.this, mypage.class);
                startActivity(intentMyPage);
                break;

            //드슈
            case R.id.tv_ride_res:
                Intent intentRes = new Intent(RideActivity.this, RestaurantActivity.class);
                startActivity(intentRes);
                break;


            //사슈
            case R.id.tv_ride_buy:
                Intent intentBuy = new Intent(RideActivity.this, GoodsBuyActivity.class);
                startActivity(intentBuy);
                break;
            //자슈
            case R.id.tv_ride_stay:
                Intent intentStay = new Intent(RideActivity.this, StayActivity.class);
                startActivity(intentStay);
                break;
            //타슈
//            case R.id.tv_ride:
//                Intent intentRide = new Intent(RideActivity.this, RideActivity.class);
//                startActivity(intentRide);
//                break;
        }
    }
}
