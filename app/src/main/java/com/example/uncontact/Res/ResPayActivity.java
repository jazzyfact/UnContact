package com.example.uncontact.Res;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uncontact.R;

public class ResPayActivity extends AppCompatActivity implements View.OnClickListener{


    Button btnResPassSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_pay);


        //결제비번누르고 보내기 버튼
        btnResPassSend = findViewById(R.id.btn_res_pass_send);


        //버튼리스너
        btnResPassSend.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //추천
            //결제완료 화면으로 이동
            case R.id.btn_res_pass_send:
                Intent intentRec = new Intent(ResPayActivity.this, ResPayCompleteActivity.class);
                startActivity(intentRec);
                break;
        }
    }
}
