package com.example.uncontact.Res;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uncontact.R;

public class ResSelectMenuActivity extends AppCompatActivity implements  View.OnClickListener {

    Button btnResAddCart;
    ImageView resSelectMinus, resSelectPlus;
    TextView resSelectCountNum;
    int count, totalCount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_select_menu);

        resSelectMinus  = findViewById(R.id.res_select_minus);
        resSelectPlus = findViewById(R.id.res_select_plus);
        resSelectCountNum = findViewById(R.id.res_select_count_num);

        btnResAddCart = findViewById(R.id.btn_res_add_cart);


        btnResAddCart.setOnClickListener(this);
        resSelectMinus.setOnClickListener(this);
        resSelectPlus.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //장바구니 추가 버튼
            case R.id.btn_res_add_cart:
                Intent intentAddCart = new Intent(ResSelectMenuActivity.this, ResCartActivity.class);
                startActivity(intentAddCart);
                break;
                //수량마이너스
            case R.id.res_select_minus:
                count --;

                resSelectCountNum.setText(String.valueOf(count));
                if (count < 0) {
                    count = 0;
                    resSelectCountNum.setText("0");
                }
                break;


            //수량 플러스
            case R.id.res_select_plus:
                totalCount =0;
                count ++;
                resSelectCountNum.setText(String.valueOf(count));
                break;
        }
    }
}
