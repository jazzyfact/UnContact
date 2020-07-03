package com.example.uncontact.Stay;

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
import com.example.uncontact.Adapter.StayAdapter;
import com.example.uncontact.Do.DoActivity;
import com.example.uncontact.Do.DoDetailActivity;
import com.example.uncontact.GoodsBuy.GoodsBuyActivity;
import com.example.uncontact.MainActivity;
import com.example.uncontact.Model.StayItem;
import com.example.uncontact.Mypage.mypage;
import com.example.uncontact.R;
import com.example.uncontact.Res.RestaurantActivity;
import com.example.uncontact.Ride.RideActivity;
import com.example.uncontact.Ride.RideCartActivity;

import java.util.ArrayList;

public class StayActivity extends AppCompatActivity implements View.OnClickListener, StayAdapter.OnItemClickListener {


    private TextView tvBtnStayRes, tvBtnStayGoods, tvBtnStayRide, tvBtnStayRecomm, tvBtnStayMypageSend, tvBtnStayDo;
    private RecyclerView recyclerView;
    private StayAdapter adapter;
    private ArrayList<StayItem> list;
    private StayItem item;

    RecyclerView.LayoutManager mLayoutManager;
    String TAG = "StayActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stay);


        tvBtnStayRecomm = findViewById(R.id.tv_btn_stay_recomm);
        tvBtnStayMypageSend = findViewById(R.id.tv_btn_stay_mypageSend);
        tvBtnStayRes = findViewById(R.id.tv_btn_stay_res);
        tvBtnStayDo = findViewById(R.id.tv_btn_stay_do);
        tvBtnStayGoods = findViewById(R.id.tv_btn_stay_goods);
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
        tvBtnStayDo.setOnClickListener(this);
        tvBtnStayGoods.setOnClickListener(this);
        tvBtnStayRide.setOnClickListener(this);

        //리사이클러뷰 아이템 불러오기
        getData();

    }

    private void getData() {

        list = new ArrayList<>();
        list.add(new StayItem(R.drawable.hotel1, "크리스탈호텔", "신축 개업한 호텔입니다. ",4));
        list.add(new StayItem(R.drawable.hotel3, "유성모텔", "최고의 서비스를 제공하는 모텔입니다",5));
        list.add(new StayItem(R.drawable.hotel2, "라빈느호텔", "멋진 수영장을 가지고 있는 호텔입니다",4));
        list.add(new StayItem(R.drawable.hotel4, "오월드펜션", "오월드 근처에 있는 펜션입니다.",3));
        list.add(new StayItem(R.drawable.hotel5, "오백리캠핑장", "대청호 인근에 있는 캠핑장입니다",4));
        list.add(new StayItem(R.drawable.hotel7, "보문산펜션", "보문산의 기운을 느낄 수 있는 펜션입니다",3));
        list.add(new StayItem(R.drawable.hotel8, "장태산야영장", "메타세콰이아길과 가깝고, 산림욕을 즐길 수 있습니다",4));
        list.add(new StayItem(R.drawable.hotel9, "식장산펜션", "멋진 야경을 볼 수 있는 펜션입니다",5));
        list.add(new StayItem(R.drawable.hotel10, "계족산게스트하우스", "대전시내를 한 눈에 볼 수 있습니다",4));
//        list.add(new StayItem(R.drawable.hotel1, "패밀리호텔", "가족단위의 손님이 많이 오는 펜션입니다"));


        adapter = new StayAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(StayActivity.this);


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
        switch (v.getId()) {

            //추천
            case R.id.tv_btn_stay_recomm:
                Intent intentRec = new Intent(StayActivity.this, MainActivity.class);
                startActivity(intentRec);
                //애니메이션제거
                overridePendingTransition(0, 0);
                break;
            //마이페이지
            case R.id.tv_btn_stay_mypageSend:
                Intent intentMyPage = new Intent(StayActivity.this, mypage.class);
                startActivity(intentMyPage);
                //애니메이션제거
                overridePendingTransition(0, 0);
                break;

            //드슈
            case R.id.tv_btn_stay_res:
                Intent intentRes = new Intent(StayActivity.this, RestaurantActivity.class);
                startActivity(intentRes);
                //애니메이션제거
                overridePendingTransition(0, 0);
                break;

            //드슈
            case R.id.tv_btn_stay_do:
                Intent intentDo = new Intent(StayActivity.this, DoActivity.class);
                startActivity(intentDo);
                //애니메이션제거
                overridePendingTransition(0, 0);
                break;

            //사슈
            case R.id.tv_btn_stay_goods:
                Intent intentBuy = new Intent(StayActivity.this, GoodsBuyActivity.class);
                startActivity(intentBuy);
                //애니메이션제거
                overridePendingTransition(0, 0);
                break;
            //타슈
            case R.id.tv_btn_stay_ride:
                Intent intentRide = new Intent(StayActivity.this, RideActivity.class);
                startActivity(intentRide);
                //애니메이션제거
                overridePendingTransition(0, 0);
                break;
        }
    }

    @Override
    public void onItemClick(int position) {


        Toast.makeText(getApplicationContext(), "선택하셨습니다", Toast.LENGTH_SHORT).show();

        Intent intentDo = new Intent(StayActivity.this, StayDetailActivity.class);

        item = list.get(position);

        intentDo.putExtra("image", item.getStayImage());
        intentDo.putExtra("title", item.getStayTitle());
        intentDo.putExtra("intro", item.getStayIntro());
        intentDo.putExtra("star", item.getStayStar());

        Log.i(TAG,"star~~~~~" + item.getStayStar());
        startActivity(intentDo);
        //애니메이션제거
        overridePendingTransition(0, 0);

    }
}
