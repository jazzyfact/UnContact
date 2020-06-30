package com.example.uncontact.GoodsBuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uncontact.R;
import com.example.uncontact.Res.ResSelectMenuActivity;
import com.example.uncontact.Res.RestaurantDetailActivity;

public class GoodsBuyCartActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnGoodsBuyPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_buy_cart);

        btnGoodsBuyPay = findViewById(R.id.btn_goods_buy_pay);



        //클릭리스너
        btnGoodsBuyPay.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_goods_buy_pay:
                Intent intentDetail = new Intent(GoodsBuyCartActivity.this, GoodsBuyPayActivity.class);
                startActivity(intentDetail);
                break;

        }
    }
}
