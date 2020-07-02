package com.example.uncontact.Stay;

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
import com.example.uncontact.Adapter.StayAdapter;
import com.example.uncontact.GoodsBuy.GoodsBuyActivity;
import com.example.uncontact.MainActivity;
import com.example.uncontact.Model.StayItem;
import com.example.uncontact.Mypage.mypage;
import com.example.uncontact.R;
import com.example.uncontact.Res.RestaurantActivity;
import com.example.uncontact.Ride.RideActivity;
import com.example.uncontact.Ride.RideCartActivity;

import java.util.ArrayList;

public class StayActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView tvBtnStayRes, tvBtnStayGoods,  tvBtnStayRide, tvBtnStayRecomm,tvBtnStayMypageSend;
    private RecyclerView recyclerView;
    private StayAdapter adapter;

    RecyclerView.LayoutManager mLayoutManager;
    String TAG = "StayActivity";
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stay);


        tvBtnStayRecomm = findViewById(R.id.tv_btn_stay_recomm);
        tvBtnStayMypageSend =findViewById(R.id.tv_btn_stay_mypageSend);
        tvBtnStayRes = findViewById(R.id.tv_btn_stay_res);
        tvBtnStayGoods =findViewById(R.id.tv_btn_stay_goods);
        tvBtnStayRide = findViewById(R.id.tv_btn_stay_ride);

        //리사이클러뷰 set
        recyclerView = findViewById(R.id.stay_recyclerview);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        
        //클릭이벤트
        tvBtnStayRecomm.setOnClickListener(this);
        tvBtnStayMypageSend.setOnClickListener(this);
        tvBtnStayRes.setOnClickListener(this);
        tvBtnStayGoods.setOnClickListener(this);
        tvBtnStayRide.setOnClickListener(this);

        //리사이클러뷰 아이템 불러오기
        getData();
        
    }

    private void getData() {

        ArrayList<StayItem> list = new ArrayList<>();
        list.add(new StayItem(R.drawable.ic_hotel2,"호텔1","호텔정보입니다"));
        list.add(new StayItem(R.drawable.ic_hotel2,"호텔2","호텔정보입니다"));
        list.add(new StayItem(R.drawable.ic_hotel2,"호텔3","호텔정보입니다"));
        list.add(new StayItem(R.drawable.ic_hotel2,"호텔4","호텔정보입니다"));
        list.add(new StayItem(R.drawable.ic_hotel2,"호텔5","호텔정보입니다"));
        list.add(new StayItem(R.drawable.ic_hotel2,"호텔6","호텔정보입니다"));
        list.add(new StayItem(R.drawable.ic_hotel2,"호텔7","호텔정보입니다"));
        list.add(new StayItem(R.drawable.ic_hotel2,"호텔8","호텔정보입니다"));
        list.add(new StayItem(R.drawable.ic_hotel2,"호텔9","호텔정보입니다"));
        list.add(new StayItem(R.drawable.ic_hotel2,"호텔10","호텔정보입니다"));



        adapter = new StayAdapter(list);
        recyclerView.setAdapter(adapter);


        //어댑터클릭리스너
//        adapter.setOnItemClickListener(new RestaurantAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View v, int position) {
//                // 클릭했을때 원하는데로 처리해주는 부분
//                Toast myToast = Toast.makeText(getApplicationContext(), "포지션 눌렀다" + position, Toast.LENGTH_SHORT);
//                myToast.show();
//                Intent intentDetail = new Intent(StayActivity.this, StayDetailActivity.class);
//                startActivity(intentDetail);
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            //추천
            case R.id.tv_btn_stay_recomm:
                Intent intentRec = new Intent(StayActivity.this, MainActivity.class);
                startActivity(intentRec);
                break;
            //마이페이지
            case R.id.tv_btn_stay_mypageSend:
                Intent intentMyPage =  new Intent(StayActivity.this, mypage.class);
                startActivity(intentMyPage);
                break;

            //드슈
            case R.id.tv_btn_stay_res:
                Intent intentRes = new Intent(StayActivity.this, RestaurantActivity.class);
                startActivity(intentRes);
                break;


            //사슈
            case R.id.tv_btn_stay_goods:
                Intent intentBuy = new Intent(StayActivity.this, GoodsBuyActivity.class);
                startActivity(intentBuy);
                break;
            //타슈
            case R.id.tv_btn_stay_ride:
                Intent intentRide = new Intent(StayActivity.this, RideActivity.class);
                startActivity(intentRide);
                break;
        }
    }
}
