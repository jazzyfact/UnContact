package com.example.uncontact.Mypage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.uncontact.MainActivity;
import com.example.uncontact.R;
import com.example.uncontact.Res.ResCartActivity;
import com.example.uncontact.Res.RestaurantActivity;

public class mypage_booking extends AppCompatActivity {
    TextView tv_mypageBMycard;
    TextView tv_mypageBMyb;

    // 상단 버튼
    TextView bt_Recommendation;
    TextView btTravel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_booking);

        tv_mypageBMycard = findViewById(R.id.tv_mypageBMycard);
        tv_mypageBMycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), mypage.class)); //로딩이 끝난 후, ChoiceFunction 이동
            }
        });
        tv_mypageBMyb = findViewById(R.id.tv_mypageBMyb);


        // 상단 버튼 시작  ----------------------------------------------------------------------------
        bt_Recommendation = findViewById(R.id.bt_Recommendation);
        bt_Recommendation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추천으로 가는 버튼
                startActivity(new Intent(getApplication(), MainActivity.class)); //로딩이 끝난 후, ChoiceFunction 이동
            }
        });
        btTravel = findViewById(R.id.btTravel);
        btTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 여행으로 가는 버튼
                startActivity(new Intent(getApplication(), RestaurantActivity.class)); //로딩이 끝난 후, ChoiceFunction 이동
            }
        });
        // 상단 버튼 끝  ------------------------------------------------------------------------------
    }
}
