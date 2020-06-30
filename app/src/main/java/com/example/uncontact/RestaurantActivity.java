package com.example.uncontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.uncontact.Adapter.RestaurantAdapter;
import com.example.uncontact.Model.RestaurantItem;

import java.util.ArrayList;
import java.util.Arrays;

public class RestaurantActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private ArrayList<RestaurantItem> list;
    private RestaurantAdapter adapter;
    private TextView tvBtnRestaur, btRecommendation,tvBtnBuy, tvBtnStay, tvBtnRide;
    RecyclerView.LayoutManager mLayoutManager;
    String TAG = "RestaurantActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);


        btRecommendation = findViewById(R.id.btRecommendation);
        tvBtnRestaur = findViewById(R.id.tv_res);
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
        btRecommendation.setOnClickListener(this);
        tvBtnBuy.setOnClickListener(this);
        tvBtnStay.setOnClickListener(this);
        tvBtnRide.setOnClickListener(this);

    }

    //하드코딩
    private void getData() {
        Log.i(TAG,"리사이클러뷰");

        ArrayList<RestaurantItem> list = new ArrayList<>();
        list.add(new RestaurantItem(R.drawable.berry, "차오차오", "123123", 5));
        list.add(new RestaurantItem(R.drawable.berry, "차오차오", "123123", 3));
        list.add(new RestaurantItem(R.drawable.berry, "차오차오", "123123", 1));
        list.add(new RestaurantItem(R.drawable.berry, "차오차오", "123123", 2));
        list.add(new RestaurantItem(R.drawable.berry, "차오차오", "123123", 3));
        list.add(new RestaurantItem(R.drawable.berry, "차오차오", "123123", 3));

        adapter = new RestaurantAdapter(list);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            //추천
            case R.id.btRecommendation:
                Intent intentRec =  new Intent(RestaurantActivity.this, MainActivity.class);
                startActivity(intentRec);
                break;
            //사슈
            case R.id.tv_buy:
                Intent intentBuy = new Intent(RestaurantActivity.this, GoodsBuyActivity.class);
                startActivity(intentBuy);
                break;
            //자슈
            case R.id.tv_stay:
                Intent intentStay = new Intent(RestaurantActivity.this, StayActivity.class);
                startActivity(intentStay);
                break;
                //타슈
            case R.id.tv_ride:
                Intent intentRide = new Intent(RestaurantActivity.this, RideActivity.class);
                startActivity(intentRide);
                break;


        }

    }
}
