package com.example.uncontact.Mypage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.uncontact.R;

import java.util.ArrayList;

public class mypage extends AppCompatActivity {
    RecyclerView re_mypagePayment;
    mypageAdapter mypageAdapter;
    ArrayList<mypagePaymentData> mypagePaymentList;

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

    }
}
