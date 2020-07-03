package com.example.uncontact.Stay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uncontact.Adapter.RestaurantAdapter;
import com.example.uncontact.Adapter.RestaurantMenuAdapter;
import com.example.uncontact.Adapter.StayRoomAdapter;
import com.example.uncontact.Model.StayRoomItem;
import com.example.uncontact.R;
import com.example.uncontact.Res.ResSelectMenuActivity;
import com.example.uncontact.Res.RestaurantDetailActivity;

import java.util.ArrayList;

public class StayDetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<StayRoomItem> list;
    private StayRoomAdapter adapter;

    private String title, image, intro;
    float star;
    TextView tvResDetailTitle, tvResDetailContent;
    RatingBar tvStayDetailRatingBar;

    RecyclerView.LayoutManager mLayoutManager;
    String TAG = "StayDetailActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stay_detail);


        tvResDetailTitle = findViewById(R.id.tv_res_detail_title);
        tvResDetailContent = findViewById(R.id.tv_res_detail_content);
        tvStayDetailRatingBar = findViewById(R.id.tv_stay_detail_rating_bar);

        //리사이클러뷰 set
        recyclerView = findViewById(R.id.stay_detail_recylcerview);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        //리사이클러뷰 아이템 불러오기
        getData();

        //인텐트 받기
        Intent intent = getIntent();

        title = intent.getStringExtra("title");
        intro = intent.getStringExtra("intro");
        //ratingbar string으로 받아오려고 해서 오류가 남, flot으로 바꿔준 후 디폴트값 넣어줘야함
//        star = intent.getFloatExtra("star",0);
        star = intent.getIntExtra("star", 0);

        Log.i(TAG,"스타" + star);

        tvResDetailTitle.setText(title);
        tvResDetailContent.setText(intro);
        tvStayDetailRatingBar.setRating(star);


    }

    private void getData() {
        ArrayList<StayRoomItem> list = new ArrayList<>();
        list.add(new StayRoomItem(R.drawable.single,"싱글 룸","멋진 뷰를 볼 수 있는 방입니다. 하나의 침대가 있습니다"));
        list.add(new StayRoomItem(R.drawable.couple,"커플 룸 ","아늑한 조명, 분위기를 느낄 수 있는 방입니다. 더블 침대가 있습니다"));
        list.add(new StayRoomItem(R.drawable.famaily,"패밀리 룸","넓고 깔끔한 느낌을 주는 방입니다. 가족단위의 가족들이 많이 찾습니다"));


        adapter = new StayRoomAdapter(list);
        recyclerView.setAdapter(adapter);



    }
}
