package com.example.uncontact.Res;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uncontact.R;

public class ResCartActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnPay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_cart);

        btnPay = findViewById(R.id.btn_pay);


        //리사이클러뷰 아이템 불러오기
        getData();

        //클릭이벤트
        btnPay.setOnClickListener(this);

    }

    private void getData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //
            case R.id.btn_pay:
                Intent intentPay = new Intent(ResCartActivity.this, ResPayActivity.class);
                startActivity(intentPay);
                break;
        }
    }
}
