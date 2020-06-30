package com.example.uncontact.GoodsBuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uncontact.R;

public class GoodsBuyPayActivity extends AppCompatActivity implements View.OnClickListener{


    Button btnGoodsPassSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_buy_pay);

        btnGoodsPassSend = findViewById(R.id.btn_goods_pass_send);



        //클릭리스너
        btnGoodsPassSend.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_goods_pass_send:
                Intent intentDetail = new Intent(GoodsBuyPayActivity.this, GoodsBuyPayCompleteActivity.class);
                startActivity(intentDetail);
                break;


        }
    }
}
