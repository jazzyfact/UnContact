package com.example.uncontact.Do;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uncontact.Adapter.DoAdapter;
import com.example.uncontact.Adapter.RestaurantAdapter;
import com.example.uncontact.GoodsBuy.GoodsBuyActivity;
import com.example.uncontact.MainActivity;
import com.example.uncontact.Model.DoItem;
import com.example.uncontact.Mypage.mypage;
import com.example.uncontact.R;
import com.example.uncontact.Res.RestaurantActivity;
import com.example.uncontact.Res.RestaurantDetailActivity;
import com.example.uncontact.Ride.RideActivity;
import com.example.uncontact.Stay.StayActivity;

import java.util.ArrayList;

public class DoActivity extends AppCompatActivity implements DoAdapter.OnItemClickListener{

    private RecyclerView recyclerView;
    private ArrayList<DoItem> list;
    private DoItem doItem;
    private DoAdapter adapter;


    private TextView tvBtnDoRetaur, btnDoRecomm,tvBtnDoBuy, tvBtnDoStay, tvBtnDoRide, btnDoMypageSend, tvbtnDo;
    RecyclerView.LayoutManager mLayoutManager;
    String TAG = "DoActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do);


        btnDoRecomm = findViewById(R.id.btn_do_recomm);
        btnDoMypageSend = findViewById(R.id.btn_do_mypageSend);
        tvBtnDoRetaur = findViewById(R.id.tv_do_res);
        tvbtnDo = findViewById(R.id.tv_do);
        tvBtnDoBuy = findViewById(R.id.tv_do_buy);
        tvBtnDoStay = findViewById(R.id.tv_do_stay);
        tvBtnDoRide = findViewById(R.id.tv_do_ride);




        //리사이클러뷰 set
        recyclerView = findViewById(R.id.do_recyclerview);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        //리사이클러뷰 아이템 불러오기
        getData();

        //클릭이벤트
        getClick();

    }

    private void getClick() {

        btnDoRecomm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRec =  new Intent(DoActivity.this, MainActivity.class);
                startActivity(intentRec);
                //애니메이션제거
                overridePendingTransition(0, 0);
            }
        });


        btnDoMypageSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMyPage =  new Intent(DoActivity.this, mypage.class);
                startActivity(intentMyPage);
                //애니메이션제거
                overridePendingTransition(0, 0);
            }
        });

        tvBtnDoRetaur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMyPage =  new Intent(DoActivity.this, RestaurantActivity.class);
                startActivity(intentMyPage);
                //애니메이션제거
                overridePendingTransition(0, 0);
            }
        });

        tvBtnDoBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBuy = new Intent(DoActivity.this, GoodsBuyActivity.class);
                startActivity(intentBuy);
                //애니메이션제거
                overridePendingTransition(0, 0);
            }
        });


        tvBtnDoStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStay = new Intent(DoActivity.this, StayActivity.class);
                startActivity(intentStay);
                //애니메이션제거
                overridePendingTransition(0, 0);
            }
        });

        tvBtnDoRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRide = new Intent(DoActivity.this, RideActivity.class);
                startActivity(intentRide);
                //애니메이션제거
                overridePendingTransition(0, 0);
            }
        });

    }

    private void getData() {
        Log.i(TAG, "리사이클러뷰");

        list = new ArrayList<>();
        list.add(new DoItem(R.drawable.do1, "장태산자연휴양림", "울창한 메타세콰이어 숲에서 즐기는 산림욕과 캠핑"));
        list.add(new DoItem(R.drawable.do2, "한밭수목원", "중부권 최대규모의 인공수목원에서 즐기는 다양한 자연생태 체험"));
        list.add(new DoItem(R.drawable.do3, "만인산 자연휴양림", "종합휴양지에서 즐기는 야영, 피크닉, 산림욕 등"));
        list.add(new DoItem(R.drawable.do4, "뿌리공원", "224개 성씨 유래가 기록된 조각품, 자연관찰로, 수목원, 산림욕장 등"));
        list.add(new DoItem(R.drawable.do5, "성북동 산림욕장", "60만평의 산에 임도, 계속, 숲체험시설 등에서 즐기는 산림욕"));
        list.add(new DoItem(R.drawable.do6, "유림공원", "도심 속의 명품숲으로 정자, 호수, 잔디공장, 화훼숲, 바닥분수 등"));
        list.add(new DoItem(R.drawable.do7, "대청호 오백리길", "이현동 억새밭, 슬픈연가 촬영지, 황새바위 등 청정한 대청호 주변의 경치"));
        list.add(new DoItem(R.drawable.do8, "금강로하스에코공원", "대청댐 하류지역의 문화관광벨트에서 누리는 다양한 볼거리 즐길거리"));
        list.add(new DoItem(R.drawable.do9, "계족산 황톳길", "14.5km의 황톳길에서 체험하는 부드러운 황토 발마사지와 산림욕"));
        list.add(new DoItem(R.drawable.do10, "장동산림욕장", "등산순환로, 체육-모험 놀이시설 등이 갖춰진 휴양, 자연탐방코스"));

        adapter = new DoAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(DoActivity.this);
    }

    @Override
    public void onItemClick(int position) {
        Toast myToast = Toast.makeText(getApplicationContext(), "하슈 아이템 눌렀다", Toast.LENGTH_SHORT);
        myToast.show();
        Intent intentDo = new Intent(DoActivity.this, DoDetailActivity.class);

        doItem = list.get(position);

        intentDo.putExtra("image",doItem.getDoImage());
        intentDo.putExtra("title",doItem.getDoTitle());
        intentDo.putExtra("intro",doItem.getDoIntro());

        startActivity(intentDo);
        //애니메이션제거
        overridePendingTransition(0, 0);

    }
}
