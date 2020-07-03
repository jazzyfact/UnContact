package com.example.uncontact.Res;

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
import com.example.uncontact.Do.DoActivity;
import com.example.uncontact.GoodsBuy.GoodsBuyActivity;
import com.example.uncontact.MainActivity;
import com.example.uncontact.Model.ResMenuItem;
import com.example.uncontact.Model.RestaurantItem;
import com.example.uncontact.Mypage.mypage;
import com.example.uncontact.R;
import com.example.uncontact.Ride.RideActivity;
import com.example.uncontact.Stay.StayActivity;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity implements RestaurantAdapter.OnItemClickListener  {

    private RecyclerView recyclerView;
    private ArrayList<RestaurantItem> list;

    private RestaurantItem restaurantItem; //식당 아이템
    private ResMenuItem resMenuItem;//메뉴 아이템
    private RestaurantAdapter adapter;


    private TextView tvBtnRestaur, btRecommendation,tvBtnBuy, tvBtnStay, tvBtnRide, btnResMypageSend, tvBtnDo;
    RecyclerView.LayoutManager mLayoutManager;
    String TAG = "RestaurantActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);


        btRecommendation = findViewById(R.id.btRecommendation);
        btnResMypageSend = findViewById(R.id.btn_res_mypageSend);

        tvBtnRestaur = findViewById(R.id.tv_res);
        tvBtnDo = findViewById(R.id.tv_do);
        tvBtnBuy = findViewById(R.id.tv_buy);
        tvBtnStay = findViewById(R.id.tv_stay);
        tvBtnRide = findViewById(R.id.tv_ride);



        //리사이클러뷰 set
        recyclerView = findViewById(R.id.res_recyclerview);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        //리사이클러뷰 아이템 불러오기
        getData();



        //클릭이벤트
//        btRecommendation.setOnClickListener(this);
//        btnResMypageSend.setOnClickListener(this);
//        tvBtnBuy.setOnClickListener(this);
//        tvBtnStay.setOnClickListener(this);
//        tvBtnRide.setOnClickListener(this);



        btRecommendation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRec =  new Intent(RestaurantActivity.this, MainActivity.class);
                startActivity(intentRec);
                //애니메이션제거
                overridePendingTransition(0, 0);
            }
        });

        tvBtnDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDo =  new Intent(RestaurantActivity.this, DoActivity.class);
                startActivity(intentDo);
                //애니메이션제거
                overridePendingTransition(0, 0);
            }
        });


        btnResMypageSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMyPage =  new Intent(RestaurantActivity.this, mypage.class);
                startActivity(intentMyPage);
                //애니메이션 제거
                overridePendingTransition(0, 0);
            }
        });

        tvBtnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBuy = new Intent(RestaurantActivity.this, GoodsBuyActivity.class);
                startActivity(intentBuy);
                //애니메이션 제거
                overridePendingTransition(0, 0);
            }
        });


        tvBtnStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStay = new Intent(RestaurantActivity.this, StayActivity.class);
                startActivity(intentStay);
                //애니메이션 제거
                overridePendingTransition(0, 0);
            }
        });

        tvBtnRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRide = new Intent(RestaurantActivity.this, RideActivity.class);
                startActivity(intentRide);
                //애니메이션 제거
                overridePendingTransition(0, 0);
            }
        });




//        adapter.setOnItemClickListener(new RestaurantAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View v, int position) {
//                Intent intentDetail = new Intent(RestaurantActivity.this, RestaurantDetailActivity.class);
//                intentDetail.putExtra("title", restaurantItem.getRestaurantName());
//                intentDetail.putExtra("intro", restaurantItem.getRestaurantIntro());
//                intentDetail.putExtra("star",restaurantItem.getRating());
//                intentDetail.putExtra("menu_image",resMenuItem.getResMenuImage());
//                intentDetail.putExtra("menu_title",resMenuItem.getResMenuTitle());
//                intentDetail.putExtra("menu_intro",resMenuItem.getResMenuContent());
//                startActivity(intentDetail);
//
//            }
//        });

    }

    //하드코딩
    private void getData() {
        Log.i(TAG,"리사이클러뷰");

        list = new ArrayList<>();
        list.add(new RestaurantItem("한식",R.drawable.gogi, "꽃차돌", "나래가 추천하는 산성동 고기맛집", 5));
        list.add(new RestaurantItem("중식",R.drawable.f_dduck, "가은이네분식집", "24시간 영업하는 한남대학교 중식집", 4));
        list.add(new RestaurantItem(R.drawable.f_bread, "발효빵", "15년 전통 원조 발효빵집", 3));
        list.add(new RestaurantItem(R.drawable.f_kal, "50년전통해물칼국수", "3대가 이어서 하는 칼국수집", 3));
        list.add(new RestaurantItem(R.drawable.f_yack, "영양가득돌솥밥", "영양소 가득한 돌솥밥", 3));
        list.add(new RestaurantItem(R.drawable.f_pizza, "수타장인피자24시", "장인의 손길로 터치한 피자", 2));
        list.add(new RestaurantItem(R.drawable.f_spicy, "매운쭈구미", "화끈하게 매운맛을 보여주는 쭈꾸미집", 3));
        list.add(new RestaurantItem(R.drawable.f_branch, "브런치", "고급스러운 브런치집", 3));
        list.add(new RestaurantItem(R.drawable.f_back, "백반집", "오늘의 반찬 고민하지마세요", 3));
        list.add(new RestaurantItem(R.drawable.f_bool, "황제불고기", "황제가 먹은것 같은 불고기집", 3));


        adapter = new RestaurantAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(RestaurantActivity.this);




    }



//    @Override
//    public void onClick(View v) {
//
//        switch (v.getId()) {
//            //추천
//            case R.id.btRecommendation:
//                Intent intentRec =  new Intent(RestaurantActivity.this, MainActivity.class);
//                startActivity(intentRec);
//                break;
//
//            case R.id.btn_res_mypageSend:
//                Intent intentMyPage =  new Intent(RestaurantActivity.this, mypage.class);
//                startActivity(intentMyPage);
//                break;
//
//            //사슈
//            case R.id.tv_buy:
//                Intent intentBuy = new Intent(RestaurantActivity.this, GoodsBuyActivity.class);
//                startActivity(intentBuy);
//                break;
//            //자슈
//            case R.id.tv_stay:
//                Intent intentStay = new Intent(RestaurantActivity.this, StayActivity.class);
//                startActivity(intentStay);
//                break;
//                //타슈
//            case R.id.tv_ride:
//                Intent intentRide = new Intent(RestaurantActivity.this, RideActivity.class);
//                startActivity(intentRide);
//                break;
//
//
//        }

//    }



    @Override
    public void onItemClick(int position) {
//        Toast myToast = Toast.makeText(getApplicationContext(), "드슈 아이템 눌렀다", Toast.LENGTH_SHORT);
//        myToast.show();
        Intent intentDetail = new Intent(RestaurantActivity.this, RestaurantDetailActivity.class);

        restaurantItem = list.get(position);
//        resMenuItem = RestaurantDetailActivity.resMenuItemArrayList.get(position);

        intentDetail.putExtra("category",restaurantItem.getCategory());
        intentDetail.putExtra("title", restaurantItem.getRestaurantName());
        intentDetail.putExtra("intro", restaurantItem.getRestaurantIntro());
        intentDetail.putExtra("star",restaurantItem.getRating());

//        intentDetail.putExtra("menu_image",resMenuItem.getResMenuImage());
//        intentDetail.putExtra("menu_title",resMenuItem.getResMenuTitle());
//        intentDetail.putExtra("menu_intro",resMenuItem.getResMenuContent());
        startActivity(intentDetail);
        Log.i(TAG,"카테고리" + restaurantItem.getCategory());
        Log.i(TAG,"가게이름" + restaurantItem.getRestaurantName());
        Log.i(TAG,"가게소개" + restaurantItem.getRestaurantIntro());
        Log.i(TAG,"가게평점" + restaurantItem.getRating());

    }
}
