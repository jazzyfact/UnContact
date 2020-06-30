package com.example.uncontact.GoodsBuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uncontact.R;
import com.example.uncontact.Res.ResSelectMenuActivity;
import com.example.uncontact.Res.RestaurantDetailActivity;

public class GoodsBuyDetailActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnGoodsBuyAddCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_buy_detail);

        btnGoodsBuyAddCart = findViewById(R.id.btn_goods_buy_add_cart);


        //클릭리스너
        btnGoodsBuyAddCart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //장바구니 이동
            case R.id.btn_goods_buy_add_cart:
                Intent intentDetail = new Intent(GoodsBuyDetailActivity.this, GoodsBuyCartActivity.class);
                startActivity(intentDetail);
                break;

        }


    }
}
