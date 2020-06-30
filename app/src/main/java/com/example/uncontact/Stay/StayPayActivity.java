package com.example.uncontact.Stay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uncontact.R;
import com.example.uncontact.Res.ResPayActivity;
import com.example.uncontact.Res.ResPayCompleteActivity;

public class StayPayActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnRoomPassSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stay_pay);

        btnRoomPassSend =findViewById(R.id.btn_room_pass_send);


        //클릭
        btnRoomPassSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //추천
            //결제완료 화면으로 이동
            case R.id.btn_room_pass_send:
                Intent intentRec = new Intent(StayPayActivity.this, StayPayCompleteActivity.class);
                startActivity(intentRec);
                break;
        }
    }
}
