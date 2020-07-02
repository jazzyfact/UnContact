package com.example.uncontact.Ride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.uncontact.R;

public class RideCartActivity extends AppCompatActivity implements View.OnClickListener{

    TextView rideCartMenuTitle,rideCartPrice, rideCartMenuIntro;
    String title, intro;
    Button btnRideCartPay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_cart);


        rideCartMenuTitle = findViewById(R.id.ride_cart_menu_title);
        rideCartMenuIntro = findViewById(R.id.ride_cart_menu_intro);

        btnRideCartPay = findViewById(R.id.btn_ride_cart_pay);


        //RideActivity 인텐트 받기
        Intent intent = getIntent();

        title = intent.getStringExtra("title");
        intro = intent.getStringExtra("intro");


        //set
        rideCartMenuTitle.setText(title);
        rideCartMenuIntro.setText(intro);


        //클릭리스너
        btnRideCartPay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            //결제하기버튼 누르기
            case R.id.btn_ride_cart_pay:
                Intent intentPay = new Intent(RideCartActivity.this, RidePayActivity.class);
                startActivity(intentPay);
                break;
        }
    }
}
