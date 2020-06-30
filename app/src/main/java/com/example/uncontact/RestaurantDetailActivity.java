package com.example.uncontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.uncontact.Adapter.RestaurantAdapter;
import com.example.uncontact.Adapter.RestaurantMenuAdapter;
import com.example.uncontact.Model.ResMenuItem;

import java.util.ArrayList;

//드슈 식당 상세정보 페이지
public class RestaurantDetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<ResMenuItem> list;
    private RestaurantMenuAdapter adapter;

    RecyclerView.LayoutManager mLayoutManager;
    String TAG = "RestaurantActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);



        //리사이클러뷰 set
        recyclerView = findViewById(R.id.res_detail_recylcerview);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        //리사이클러뷰 아이템 불러오기
        getData();

    }

    //메뉴 리사이클러뷰
    private void getData() {
        ArrayList<ResMenuItem> list = new ArrayList<>();
        list.add(new ResMenuItem(R.drawable.coffee,"불고기","달달한맛"));
        list.add(new ResMenuItem(R.drawable.coffee,"불고기","달달한맛"));
        list.add(new ResMenuItem(R.drawable.coffee,"불고기","달달한맛"));
        list.add(new ResMenuItem(R.drawable.coffee,"불고기","달달한맛"));
        list.add(new ResMenuItem(R.drawable.coffee,"불고기","달달한맛"));
        list.add(new ResMenuItem(R.drawable.coffee,"불고기","달달한맛"));

        adapter = new RestaurantMenuAdapter(list);
        recyclerView.setAdapter(adapter);


        //어댑터클릭리스너
        adapter.setOnItemClickListener(new RestaurantAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                // 클릭했을때 원하는데로 처리해주는 부분
                Toast myToast = Toast.makeText(getApplicationContext(),"포지션 눌렀다" + position, Toast.LENGTH_SHORT);
                myToast.show();
                Intent intentDetail = new Intent(RestaurantDetailActivity.this, ResSelectMenuActivity.class);
                startActivity(intentDetail);
            }
        });

    }
}
