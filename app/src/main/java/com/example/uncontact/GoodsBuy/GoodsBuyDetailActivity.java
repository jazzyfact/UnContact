package com.example.uncontact.GoodsBuy;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.uncontact.R;
import com.example.uncontact.Res.ResSelectMenuActivity;
import com.example.uncontact.Res.RestaurantDetailActivity;

public class GoodsBuyDetailActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    ImageView ivGoodsSelectImage, ivGoodsDetailMinus,ivGoodsDetailPlus;
    TextView tvGoodsSelectTitle, tvGoodsSelectIntro, tvGoodsDetailNum,tvGoodsBuyTotalPrice;
    Button btnGoodsBuyAddCart;
    Spinner spGoodsBuyTime;
    String[] selectTime;
    int count, totalCount;
    RadioGroup rbGoodsDetailGroup;
    RadioButton rbGoodsDetailNow, rbGoodsDetailTime;


    private String title, image, intro;
    String TAG = "GoodsBuyDetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_buy_detail);

        ivGoodsSelectImage = findViewById(R.id.iv_goods_select_image);
        tvGoodsSelectTitle = findViewById(R.id.tv_goods_select_title);
        tvGoodsSelectIntro = findViewById(R.id.tv_goods_select_intro);
        ivGoodsDetailMinus = findViewById(R.id.iv_goods_detail_minus);
        tvGoodsDetailNum = findViewById(R.id.tv_goods_detail_num);
        ivGoodsDetailPlus = findViewById(R.id.iv_goods_detail_plus);
        tvGoodsBuyTotalPrice = findViewById(R.id.tv_goods_buy_total_price);
        btnGoodsBuyAddCart = findViewById(R.id.btn_goods_buy_add_cart);
        rbGoodsDetailNow =findViewById(R.id.rb_goods_detail_now);
        rbGoodsDetailTime = findViewById(R.id.rb_goods_detail_time);

        //라디오그룹
        rbGoodsDetailGroup = findViewById(R.id.rb_goods_detail_group);
        rbGoodsDetailGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);







        //스피너
        spGoodsBuyTime = findViewById(R.id.sp_goods_buy_time);
        spGoodsBuyTime.setOnItemSelectedListener(this);
        selectTime = new String[]{"선택하세요", "10분 뒤에 방문", "30분 뒤에 방문", "60분 뒤에 방문"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, selectTime);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGoodsBuyTime.setAdapter(adapter);


        //스피너끝


        //클릭리스너
        btnGoodsBuyAddCart.setOnClickListener(this);
        ivGoodsDetailMinus.setOnClickListener(this);
        ivGoodsDetailPlus.setOnClickListener(this);

        //데이터 받기
        Intent intent = getIntent();
        image = String.valueOf(intent.getIntExtra("image", 0));
        title = intent.getStringExtra("title");
        intro = intent.getStringExtra("intro");

        Log.i(TAG, "이미지" + image);

        ivGoodsSelectImage.setImageResource(Integer.parseInt(image));
        tvGoodsSelectTitle.setText(title);
        tvGoodsSelectIntro.setText(intro);


    }


    //라디오버튼
    RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            if(i == R.id.rb_goods_detail_now) {

                rbGoodsDetailTime.setChecked(false);
                rbGoodsDetailNow.setChecked(true);



            } else if (i == R.id.rb_goods_detail_time) {

                rbGoodsDetailNow.setChecked(false);
                rbGoodsDetailTime.setChecked(true);


            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //장바구니 이동
            case R.id.btn_goods_buy_add_cart:
                Intent intentDetail = new Intent(GoodsBuyDetailActivity.this, GoodsBuyCartActivity.class);
                startActivity(intentDetail);
                break;
            //수량마이너스
            case R.id.iv_goods_detail_minus:
                count --;

                tvGoodsDetailNum.setText(String.valueOf(count));
                if (count < 0) {
                    count = 0;
                    tvGoodsDetailNum.setText("0");
                }
                break;


            //수량 플러스
            case R.id.iv_goods_detail_plus:
                totalCount =0;
                count ++;
                tvGoodsDetailNum.setText(String.valueOf(count));
                break;






        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
