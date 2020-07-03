package com.example.uncontact.Res;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class ResSelectMenuActivity extends AppCompatActivity implements  View.OnClickListener, AdapterView.OnItemSelectedListener  {

    Button btnResAddCartm ,btnResAddPay;
    ImageView resSelectMinus, resSelectPlus;
    TextView resSelectCountNum;
    int count, totalCount;
    RadioGroup rgResSelectGroup;
    RadioButton rbResSelectNow, rbResSelectTime;
    Spinner spResSelect;
    String selectTime[];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_select_menu);

        resSelectMinus  = findViewById(R.id.res_select_minus);
        resSelectPlus = findViewById(R.id.res_select_plus);
        resSelectCountNum = findViewById(R.id.res_select_count_num);




        btnResAddPay = findViewById(R.id.btn_res_select_add_pay);

        //라디오
        rbResSelectNow = findViewById(R.id.rb_res_select_now);
        rbResSelectTime = findViewById(R.id.rb_res_select_time);



        //라디오그룹
        rgResSelectGroup = findViewById(R.id.rg_res_select_group);
        rgResSelectGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);





        //스피너
        //스피너
        spResSelect = findViewById(R.id.spinner_res_select);
        spResSelect.setOnItemSelectedListener(this);
        selectTime = new String[]{"선택하세요", "10분 뒤에 방문", "30분 뒤에 방문", "60분 뒤에 방문"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, selectTime);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spResSelect.setAdapter(adapter);







        btnResAddPay.setOnClickListener(this);
        resSelectMinus.setOnClickListener(this);
        resSelectPlus.setOnClickListener(this);
    }


    //라디오버튼
    RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            if(i == R.id.rb_res_select_now) {

                rbResSelectTime.setChecked(false);
                rbResSelectNow.setChecked(true);



            } else if (i == R.id.rb_res_select_time) {

                rbResSelectNow.setChecked(false);
                rbResSelectTime.setChecked(true);


            }
        }
    };




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //장바구니 추가 버튼 ,, 결제로바꿈
            case R.id.btn_res_select_add_pay:
                Intent intentAddCart = new Intent(ResSelectMenuActivity.this, ResPayActivity.class);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
