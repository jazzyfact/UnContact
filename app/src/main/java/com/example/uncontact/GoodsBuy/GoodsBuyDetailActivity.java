package com.example.uncontact.GoodsBuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uncontact.R;
import com.example.uncontact.Res.ResSelectMenuActivity;
import com.example.uncontact.Res.RestaurantDetailActivity;

public class GoodsBuyDetailActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivGoodsSelectImage;
    TextView tvGoodsSelectTitle, tvGoodsSelectIntro;
    Button btnGoodsBuyAddCart;
    private String title, image, intro;
    String TAG = "GoodsBuyDetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_buy_detail);

        ivGoodsSelectImage = findViewById(R.id.iv_goods_select_image);
        tvGoodsSelectTitle = findViewById(R.id.tv_goods_select_title);
        tvGoodsSelectIntro = findViewById(R.id.tv_goods_select_intro);

        btnGoodsBuyAddCart = findViewById(R.id.btn_goods_buy_add_cart);


        //클릭리스너
        btnGoodsBuyAddCart.setOnClickListener(this);


        //데이터 받기
        Intent intent = getIntent();
        image = String.valueOf(intent.getIntExtra("image",0));
        title = intent.getStringExtra("title");
        intro = intent.getStringExtra("intro");

        Log.i(TAG,"이미지" + image);

        ivGoodsSelectImage.setImageResource(Integer.parseInt(image));
        tvGoodsSelectTitle.setText(title);
        tvGoodsSelectIntro.setText(intro);


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
