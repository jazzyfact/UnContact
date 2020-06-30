package com.example.uncontact.Stay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uncontact.R;
import com.example.uncontact.Res.ResCartActivity;
import com.example.uncontact.Res.ResSelectMenuActivity;

public class StayRoomSelectActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnRoomRsrvtCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stay_room_select);
        btnRoomRsrvtCart = findViewById(R.id.btn_room_rsrvt_cart);


        //클릭리스너
        btnRoomRsrvtCart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //
            case R.id.btn_room_rsrvt_cart:
                Intent intentPay = new Intent(StayRoomSelectActivity.this, StayPayActivity.class);
                startActivity(intentPay);

                break;
        }
    }
}
