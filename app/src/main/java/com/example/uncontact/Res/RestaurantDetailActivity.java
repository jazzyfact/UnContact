package com.example.uncontact.Res;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uncontact.Adapter.RestaurantAdapter;
import com.example.uncontact.Adapter.RestaurantMenuAdapter;
import com.example.uncontact.Do.DoActivity;
import com.example.uncontact.Do.DoDetailActivity;
import com.example.uncontact.Model.ResMenuItem;
import com.example.uncontact.R;

import java.util.ArrayList;

//드슈 식당 상세정보 페이지
public class RestaurantDetailActivity extends AppCompatActivity implements RestaurantMenuAdapter.OnItemClickListener{

    private RecyclerView recyclerView;
    static ArrayList<ResMenuItem> resMenuItemArrayList;
    private RestaurantMenuAdapter adapter;
    private ResMenuItem resMenuItem;

    RecyclerView.LayoutManager mLayoutManager;
    String TAG = "RestaurantDetailActivity";

    String resTitle, resCategory;
    float resRating;
    String resIntro;
    String resMenuTitle;
    String resMenuImage;
    String resMenuIntro;
    Intent intent;
    TextView tvResDetailTitle, tvResDetailContent;
    RatingBar tvResDetailRatingBar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);


        tvResDetailTitle = findViewById(R.id.tv_res_detail_title);
        tvResDetailContent =findViewById(R.id.tv_res_detail_content);
        tvResDetailRatingBar = findViewById(R.id.tv_res_detail_rating_bar);


        //리사이클러뷰 set
        recyclerView = findViewById(R.id.res_detail_recylcerview);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        //리사이클러뷰 아이템 불러오기
        getData();




        //RestaurantActivity에서 인텐트 받아옴
        //  intentDetail.putExtra("title", restaurantItem.getRestaurantName());
        //                intentDetail.putExtra("intro", restaurantItem.getRestaurantIntro());
        //                intentDetail.putExtra("star",restaurantItem.getRating());
        //                intentDetail.putExtra("menu_image",resMenuItem.getResMenuImage());
        //                intentDetail.putExtra("menu_title",resMenuItem.getResMenuTitle());
        //                intentDetail.putExtra("menu_intro",resMenuItem.getResMenuContent());

        Intent intent = getIntent();
        resCategory = intent.getStringExtra("category");
        resTitle = intent.getStringExtra("title");
        resIntro = intent.getStringExtra("intro");
        //ratingbar string으로 받아오려고 해서 오류가 남, flot으로 바꿔준 후 디폴트값 넣어줘야함
        resRating = intent.getFloatExtra("star",0);

//        resMenuImage = intent.getStringExtra("menu_image");
//        resMenuTitle = intent.getStringExtra("menu_title");
//        resMenuIntro = intent.getStringExtra("menu_intro");
//
        Log.i(TAG,"인텐트 값 카테고리" + resCategory);
        Log.i(TAG,"인텐트 값 제목" + resTitle);
        Log.i(TAG,"인텐트 값 소개" + resIntro);
        Log.i(TAG,"인텐트 값 평점" + resRating);
//        Log.i(TAG,"인텐트 값 resMenuImage" + resMenuImage);
//        Log.i(TAG,"인텐트 값 resMenuTitle" + resMenuTitle);
//        Log.i(TAG,"인텐트 값 resMenuIntro" + resMenuIntro);

        //아이템 셋
        tvResDetailTitle.setText(resTitle);
        tvResDetailContent.setText(resIntro);
        tvResDetailRatingBar.setRating(resRating);





    }

    //메뉴 리사이클러뷰
    private void getData() {


        resMenuItemArrayList = new ArrayList<>();
//        if(resCategory.equals(resMenuItem.getCategory())) {
//            Log.i(TAG,"받은 카테고리" + resMenuItem.getCategory());
//            resMenuItemArrayList.add(new ResMenuItem("한식",R.drawable.meat,"차돌박이","감칠맛"));
//            resMenuItemArrayList.add(new ResMenuItem("한식",R.drawable.meat,"부채살","담백한맛"));
//            resMenuItemArrayList.add(new ResMenuItem("한식",R.drawable.meat,"황제갈비살","고소한맛"));
//            resMenuItemArrayList.add(new ResMenuItem("한식",R.drawable.meat,"살치살","입안에서녹는맛"));
//            resMenuItemArrayList.add(new ResMenuItem("한식",R.drawable.meat,"차돌된장찌개","구수한맛"));
//            resMenuItemArrayList.add(new ResMenuItem("중식",R.drawable.meat,"짜장면","달달한맛"));
//            resMenuItemArrayList.add(new ResMenuItem("중식",R.drawable.meat,"짬뽕","달달한맛"));
//            resMenuItemArrayList.add(new ResMenuItem("중식",R.drawable.meat,"탕수육","달달한맛"));
//            resMenuItemArrayList.add(new ResMenuItem("중식",R.drawable.meat,"볶음밥","달달한맛"));
//        }

        resMenuItemArrayList.add(new ResMenuItem("한식",R.drawable.meat1,"차돌박이","감칠맛"));
        resMenuItemArrayList.add(new ResMenuItem("한식",R.drawable.meat2,"부채살","담백한맛"));
        resMenuItemArrayList.add(new ResMenuItem("한식",R.drawable.meat3,"황제갈비살","고소한맛"));
        resMenuItemArrayList.add(new ResMenuItem("한식",R.drawable.meat4,"살치살","입안에서녹는맛"));
        resMenuItemArrayList.add(new ResMenuItem("한식",R.drawable.soy,"차돌된장찌개","구수한맛"));
//        resMenuItemArrayList.add(new ResMenuItem("중식",R.drawable.meat,"짜장면","달달한맛"));
//        resMenuItemArrayList.add(new ResMenuItem("중식",R.drawable.meat,"짬뽕","달달한맛"));
//        resMenuItemArrayList.add(new ResMenuItem("중식",R.drawable.meat,"탕수육","달달한맛"));
//        resMenuItemArrayList.add(new ResMenuItem("중식",R.drawable.meat,"볶음밥","달달한맛"));

        adapter = new RestaurantMenuAdapter(resMenuItemArrayList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(RestaurantDetailActivity.this);


//        //어댑터클릭리스너
//        adapter.setOnItemClickListener(new RestaurantAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View v, int position) {
//                // 클릭했을때 원하는데로 처리해주는 부분
//                Toast myToast = Toast.makeText(getApplicationContext(),"포지션 눌렀다" + position, Toast.LENGTH_SHORT);
//                myToast.show();
//                Intent intentDetail = new Intent(RestaurantDetailActivity.this, ResSelectMenuActivity.class);
//                startActivity(intentDetail);
//            }
//        });

    }

    @Override
    public void onItemClick(int position) {


        Toast myToast = Toast.makeText(getApplicationContext(), "결제페이지로 이동합니다", Toast.LENGTH_SHORT);
        myToast.show();
        Intent intentDo = new Intent(RestaurantDetailActivity.this, ResSelectMenuActivity.class);

        resMenuItem = resMenuItemArrayList.get(position);

        intentDo.putExtra("image",resMenuItem.getResMenuImage());
        intentDo.putExtra("title",resMenuItem.getResMenuTitle());
        intentDo.putExtra("intro",resMenuItem.getResMenuContent());

        startActivity(intentDo);
        //애니메이션제거
        overridePendingTransition(0, 0);

    }
}
