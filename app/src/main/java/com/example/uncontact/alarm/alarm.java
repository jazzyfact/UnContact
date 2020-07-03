package com.example.uncontact.alarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uncontact.MainActivity;
import com.example.uncontact.Mypage.mypage;
import com.example.uncontact.R;
import com.example.uncontact.Res.RestaurantActivity;

import java.util.ArrayList;

public class alarm extends AppCompatActivity {
//    re_alarmList 알람 내역 리사이클러뷰
//    tv_Recommendation 추천
//    tv_travel 여행
//    tv_mypage 마이페이지
//    iv_alarm 알람

    // 리사이클러뷰
    RecyclerView re_alarmList;
    TextView tv_Recommendation;
    TextView tv_travel;
    TextView tv_mypage;
    ImageView iv_alarm;

    // 리사이클러뷰 관련 설정
    alarmAdapter alarmAdapter;
    ArrayList<alarmData> addAlarmItemClass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        // 상단 시작 ---------------------------------------------------------------------------------
        tv_Recommendation = findViewById(R.id.tv_Recommendation);
        tv_Recommendation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), MainActivity.class)); //로딩이 끝난 후, ChoiceFunction 이동
            }
        });
        tv_travel = findViewById(R.id.tv_travel);
        tv_travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), RestaurantActivity.class)); //로딩이 끝난 후, ChoiceFunction 이동
            }
        });
        tv_mypage = findViewById(R.id.tv_mypage);
        tv_mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), mypage.class)); //로딩이 끝난 후, ChoiceFunction 이동
            }
        });
        iv_alarm = findViewById(R.id.iv_alarm);
        iv_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), alarm.class)); //로딩이 끝난 후, ChoiceFunction 이동s
            }
        });
        // 상단 끝 -----------------------------------------------------------------------------------

        // 메인 리사이클러뷰 시작 -----------------------------------------------------------------------

        addAlarmItemClass = new ArrayList<>();
        addAlarmItemClass.add(new alarmData("주문하신 음식이 나왔습니다."));
        addAlarmItemClass.add(new alarmData("주문하신 음식이 나왔습니다."));
        addAlarmItemClass.add(new alarmData("주문하신 음식이 나왔습니다."));
        re_alarmList = findViewById(R.id.re_alarmList);
        re_alarmList.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        re_alarmList.setLayoutManager(new LinearLayoutManager(getApplicationContext())); // 레이아웃 메니저
        // 장바구니 어레이리스트임
        // 이거를 buying class로 보내서 해당하는 사람들이 결제한 리스트가 뭔지 알아야한다.
        alarmAdapter = new alarmAdapter(addAlarmItemClass); // 어댑터에 리스트 붙이고
        re_alarmList.setAdapter(alarmAdapter); // 리사이클러뷰에 어댑터 장착
        alarmAdapter.notifyDataSetChanged();
        // 리사이클러뷰에 데이터 넣기


        // 메인 리사이클러뷰 시작 -----------------------------------------------------------------------

        // 노티피케이션 관련 ---------------------------------------------------------------------------
        String text = "전달 받은 값은";
        int id = 0;

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            text = "값을 전달 받는데 문제 발생";
        }
        else
            id = extras.getInt("notificationId");

        NotificationManager notificationManager =  (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //노티피케이션 제거
        notificationManager.cancel(id);


    }
}
