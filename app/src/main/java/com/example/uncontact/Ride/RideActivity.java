package com.example.uncontact.Ride;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uncontact.Adapter.RestaurantAdapter;
import com.example.uncontact.Adapter.RideAdapter;
import com.example.uncontact.Do.DoActivity;
import com.example.uncontact.Do.DoDetailActivity;
import com.example.uncontact.GoodsBuy.GoodsBuyActivity;
import com.example.uncontact.MainActivity;
import com.example.uncontact.Model.RideItem;
import com.example.uncontact.Mypage.mypage;
import com.example.uncontact.R;
import com.example.uncontact.Res.RestaurantActivity;
import com.example.uncontact.Stay.StayActivity;

import java.util.ArrayList;

public class RideActivity extends AppCompatActivity implements RideAdapter.OnItemClickListener, View.OnClickListener {

    private RecyclerView recyclerView;
    private ArrayList<RideItem> list;
    private RideAdapter adapter;
    private RideItem rideItem;

    RecyclerView.LayoutManager mLayoutManager;
    String TAG = "RideActivity";

    private TextView tvBtnRestaur, btnRideRravel, btnRideRecomme,tvBtnBuy, tvBtnStay, tvBtnRide, btnRideMypageSend, tvBtnRideDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride);

        btnRideRecomme = findViewById(R.id.btn_ride_recomme);
        btnRideMypageSend = findViewById(R.id.btn_ride_mypageSend);
//        btnRideRravel = findViewById(R.id.btn_ride_travel);
        tvBtnRestaur = findViewById(R.id.tv_ride_res);
        tvBtnRideDo = findViewById(R.id.tv_ride_do);
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
        tvBtnRideDo.setOnClickListener(this);


//        btRecommendation.setOnClickListener(this);
//        tvBtnRestaur.setOnClickListener(this);
//        tvBtnBuy.setOnClickListener(this);
//        tvBtnStay.setOnClickListener(this);
//        tvBtnRide.setOnClickListener(this);

        //리사이클러뷰 아이템 불러오기
        getData();


    }



    private void getData() {
        Log.i(TAG, "리사이클러뷰");

        list = new ArrayList<>();
        list.add(new RideItem(R.drawable.ic_one, "교통 1일권", "대전광역시 대중교통(버스,지하철,공공자전거) 무제한 사용 가능"));
        list.add(new RideItem(R.drawable.ic_three, "교통 3일권", "대전광역시 대중교통(버스,지하철,공공자전거) 무제한 사용 가능"));
        list.add(new RideItem(R.drawable.ic_seven, "교통 7일권", "대전광역시 대중교통(버스,지하철,공공자전거) 무제한 사용 가능"));

        adapter = new RideAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(RideActivity.this);


    }

//    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            //추천
            case R.id.btn_ride_recomme:
                Intent intentRec = new Intent(RideActivity.this, MainActivity.class);
                startActivity(intentRec);
                //애니메이션제거
                overridePendingTransition(0, 0);
                break;
            //마이페이지
            case R.id.btn_ride_mypageSend:
                Intent intentMyPage =  new Intent(RideActivity.this, mypage.class);
                startActivity(intentMyPage);
                //애니메이션제거
                overridePendingTransition(0, 0);
                break;

            //드슈
            case R.id.tv_ride_res:
                Intent intentRes = new Intent(RideActivity.this, RestaurantActivity.class);
                startActivity(intentRes);
                //애니메이션제거
                overridePendingTransition(0, 0);
                break;


            //사슈
            case R.id.tv_ride_buy:
                Intent intentBuy = new Intent(RideActivity.this, GoodsBuyActivity.class);
                startActivity(intentBuy);
                //애니메이션제거
                overridePendingTransition(0, 0);
                break;
            //자슈
            case R.id.tv_ride_stay:
                Intent intentStay = new Intent(RideActivity.this, StayActivity.class);
                startActivity(intentStay);
                //애니메이션제거
                overridePendingTransition(0, 0);
                break;
            //하슈
            case R.id.tv_ride_do:
                Intent intentRide = new Intent(RideActivity.this, DoActivity.class);
                startActivity(intentRide);
                break;
        }
    }



    @Override
    public void onItemClick(int position) {
       Toast.makeText(getApplicationContext(),  "구매화면으로 이동합니다", Toast.LENGTH_SHORT).show();

        Intent intentRide = new Intent(RideActivity.this, RideCartActivity.class);

        rideItem   = list.get(position);

//        intentRide.putExtra("image",rideItem.getRideImage());
        intentRide.putExtra("title",rideItem.getRideTitle());
        intentRide.putExtra("intro",rideItem.getRideIntro());

        startActivity(intentRide);
        //애니메이션제거
        overridePendingTransition(0, 0);
    }
}
