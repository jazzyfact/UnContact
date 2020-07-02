package com.example.uncontact.Ride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.uncontact.R;

public class RideCartActivity extends AppCompatActivity implements View.OnClickListener{

    TextView ride_cart_menu_title,rideCartPrice;
    Button btnRideCartPay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_cart);

        btnRideCartPay = findViewById(R.id.btn_ride_cart_pay);


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
