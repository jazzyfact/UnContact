package com.example.uncontact.Mypage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.uncontact.MainActivity;
import com.example.uncontact.R;
import com.example.uncontact.Res.ResCartActivity;
import com.example.uncontact.Res.RestaurantActivity;

import java.util.ArrayList;

public class mypage extends AppCompatActivity {
    RecyclerView re_mypagePayment;
    mypageAdapter mypageAdapter;
    ArrayList<mypagePaymentData> mypagePaymentList;

    //하단 버튼
    TextView tv_mypageMycard;
    TextView tv_mypageMyb;
    // 상단 버튼
    TextView bt_Recommendation;
    TextView btTravel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        // 메인 리사이클러뷰 시작 -----------------------------------------------------------------------
        mypagePaymentList = new ArrayList<>();
        mypagePaymentList.add(new mypagePaymentData("title1",5000));
        mypagePaymentList.add(new mypagePaymentData("title2",5000));
        mypagePaymentList.add(new mypagePaymentData("title3",5000));
        mypagePaymentList.add(new mypagePaymentData("title4",5000));
        mypagePaymentList.add(new mypagePaymentData("title5",5000));
        re_mypagePayment = findViewById(R.id.re_mypagePayment);
        re_mypagePayment.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        re_mypagePayment.setLayoutManager(new LinearLayoutManager(getApplicationContext())); // 레이아웃 메니저
        // 장바구니 어레이리스트임
        // 이거를 buying class로 보내서 해당하는 사람들이 결제한 리스트가 뭔지 알아야한다.
        mypageAdapter = new mypageAdapter(mypagePaymentList); // 어댑터에 리스트 붙이고
        re_mypagePayment.setAdapter(mypageAdapter); // 리사이클러뷰에 어댑터 장착
        mypageAdapter.notifyDataSetChanged();

        // 리사이클러뷰에 데이터 넣기


        // 메인 리사이클러뷰 시작 -----------------------------------------------------------------------

        // 내카드 / 예약 내역 보기 시작 -----------------------------------------------------------------
        tv_mypageMycard = findViewById(R.id.tv_mypageMycard);
        tv_mypageMycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getApplication(), mypage.class)); //로딩이 끝난 후, ChoiceFunction 이동
            }
        });
        tv_mypageMyb = findViewById(R.id.tv_mypageMyb);
        tv_mypageMyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), mypage_booking.class)); //로딩이 끝난 후, ChoiceFunction 이동
            }
        });
        // 내카드 / 예약 내역 보기 끝 -------------------------------------------------------------------

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
