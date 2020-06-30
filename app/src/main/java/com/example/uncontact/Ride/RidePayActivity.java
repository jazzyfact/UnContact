package com.example.uncontact.Ride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uncontact.R;

public class RidePayActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnRidePayPassSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_pay);

        btnRidePayPassSend = findViewById(R.id.btn_ride_pay_pass_send);


        btnRidePayPassSend.setOnClickListener(this);
    }






    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            //타슈 결제완료 화면으로 이동
            case R.id.btn_ride_pay_pass_send:
                Intent intentPay = new Intent(RidePayActivity.this, RidePayCompleteActivity.class);
                startActivity(intentPay);
                break;
        }
    }
}
