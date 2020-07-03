package com.example.uncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.uncontact.MainActivity.stampNumber;

public class stamp extends AppCompatActivity {
    TextView tv_stamp1,tv_stamp2,tv_stamp3,tv_stamp4,tv_stamp5,tv_stamp6,tv_stamp7,tv_stamp8;
    TextView tv_stamp1_ck,tv_stamp2_ck,tv_stamp3_ck,tv_stamp4_ck,tv_stamp5_ck,tv_stamp6_ck,tv_stamp7_ck,tv_stamp8_ck;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stamp);
        // 스탬프 숫자 체크 시작 ------------------------------------------------------------------------
        tv_stamp1 = findViewById(R.id.tv_stamp1);
        tv_stamp2 = findViewById(R.id.tv_stamp2);
        tv_stamp3 = findViewById(R.id.tv_stamp3);
        tv_stamp4 = findViewById(R.id.tv_stamp4);
        tv_stamp5 = findViewById(R.id.tv_stamp5);
        tv_stamp6 = findViewById(R.id.tv_stamp6);
        tv_stamp7 = findViewById(R.id.tv_stamp7);
        tv_stamp8 = findViewById(R.id.tv_stamp8);

        tv_stamp1_ck = findViewById(R.id.tv_stamp1_ck);
        tv_stamp2_ck = findViewById(R.id.tv_stamp2_ck);
        tv_stamp3_ck = findViewById(R.id.tv_stamp3_ck);
        tv_stamp4_ck = findViewById(R.id.tv_stamp4_ck);
        tv_stamp5_ck = findViewById(R.id.tv_stamp5_ck);
        tv_stamp6_ck = findViewById(R.id.tv_stamp6_ck);
        tv_stamp7_ck = findViewById(R.id.tv_stamp7_ck);
        tv_stamp8_ck = findViewById(R.id.tv_stamp8_ck);

        if(stampNumber == 0){
            tv_stamp1.setVisibility(View.GONE);
            tv_stamp2.setVisibility(View.GONE);
            tv_stamp3.setVisibility(View.GONE);
            tv_stamp4.setVisibility(View.GONE);
            tv_stamp5.setVisibility(View.GONE);
            tv_stamp6.setVisibility(View.GONE);
            tv_stamp7.setVisibility(View.GONE);
            tv_stamp8.setVisibility(View.GONE);

            tv_stamp1_ck.setVisibility(View.VISIBLE);
            tv_stamp2_ck.setVisibility(View.VISIBLE);
            tv_stamp3_ck.setVisibility(View.VISIBLE);
            tv_stamp4_ck.setVisibility(View.VISIBLE);
            tv_stamp5_ck.setVisibility(View.VISIBLE);
            tv_stamp6_ck.setVisibility(View.VISIBLE);
            tv_stamp7_ck.setVisibility(View.VISIBLE);
            tv_stamp8_ck.setVisibility(View.VISIBLE);
//            tv_stamp1.setVisibility(View.VISIBLE);
//            tv_stamp2.setVisibility(View.VISIBLE);
//            tv_stamp3.setVisibility(View.VISIBLE);
//            tv_stamp4.setVisibility(View.VISIBLE);
//            tv_stamp5.setVisibility(View.VISIBLE);
//            tv_stamp6.setVisibility(View.VISIBLE);
//            tv_stamp7.setVisibility(View.VISIBLE);
//            tv_stamp8.setVisibility(View.VISIBLE);
//
//            tv_stamp1_ck.setVisibility(View.GONE);
//            tv_stamp2_ck.setVisibility(View.GONE);
//            tv_stamp3_ck.setVisibility(View.GONE);
//            tv_stamp4_ck.setVisibility(View.GONE);
//            tv_stamp5_ck.setVisibility(View.GONE);
//            tv_stamp6_ck.setVisibility(View.GONE);
//            tv_stamp7_ck.setVisibility(View.GONE);
//            tv_stamp8_ck.setVisibility(View.GONE);

        } else if(stampNumber == 1) {

            tv_stamp1.setVisibility(View.GONE);
            tv_stamp2.setVisibility(View.VISIBLE);
            tv_stamp3.setVisibility(View.VISIBLE);
            tv_stamp4.setVisibility(View.VISIBLE);
            tv_stamp5.setVisibility(View.VISIBLE);
            tv_stamp6.setVisibility(View.VISIBLE);
            tv_stamp7.setVisibility(View.VISIBLE);
            tv_stamp8.setVisibility(View.VISIBLE);

            tv_stamp1_ck.setVisibility(View.VISIBLE);
            tv_stamp2_ck.setVisibility(View.GONE);
            tv_stamp3_ck.setVisibility(View.GONE);
            tv_stamp4_ck.setVisibility(View.GONE);
            tv_stamp5_ck.setVisibility(View.GONE);
            tv_stamp6_ck.setVisibility(View.GONE);
            tv_stamp7_ck.setVisibility(View.GONE);
            tv_stamp8_ck.setVisibility(View.GONE);

        } else if(stampNumber == 2) {
            tv_stamp1.setVisibility(View.GONE);
            tv_stamp2.setVisibility(View.GONE);
            tv_stamp3.setVisibility(View.VISIBLE);
            tv_stamp4.setVisibility(View.VISIBLE);
            tv_stamp5.setVisibility(View.VISIBLE);
            tv_stamp6.setVisibility(View.VISIBLE);
            tv_stamp7.setVisibility(View.VISIBLE);
            tv_stamp8.setVisibility(View.VISIBLE);

            tv_stamp1_ck.setVisibility(View.VISIBLE);
            tv_stamp2_ck.setVisibility(View.VISIBLE);
            tv_stamp3_ck.setVisibility(View.GONE);
            tv_stamp4_ck.setVisibility(View.GONE);
            tv_stamp5_ck.setVisibility(View.GONE);
            tv_stamp6_ck.setVisibility(View.GONE);
            tv_stamp7_ck.setVisibility(View.GONE);
            tv_stamp8_ck.setVisibility(View.GONE);

        } else if(stampNumber == 3) {
            tv_stamp1.setVisibility(View.GONE);
            tv_stamp2.setVisibility(View.GONE);
            tv_stamp3.setVisibility(View.GONE);
            tv_stamp4.setVisibility(View.VISIBLE);
            tv_stamp5.setVisibility(View.VISIBLE);
            tv_stamp6.setVisibility(View.VISIBLE);
            tv_stamp7.setVisibility(View.VISIBLE);
            tv_stamp8.setVisibility(View.VISIBLE);

            tv_stamp1_ck.setVisibility(View.VISIBLE);
            tv_stamp2_ck.setVisibility(View.VISIBLE);
            tv_stamp3_ck.setVisibility(View.VISIBLE);
            tv_stamp4_ck.setVisibility(View.GONE);
            tv_stamp5_ck.setVisibility(View.GONE);
            tv_stamp6_ck.setVisibility(View.GONE);
            tv_stamp7_ck.setVisibility(View.GONE);
            tv_stamp8_ck.setVisibility(View.GONE);

        } else if(stampNumber == 4) {
            tv_stamp1.setVisibility(View.GONE);
            tv_stamp2.setVisibility(View.GONE);
            tv_stamp3.setVisibility(View.GONE);
            tv_stamp4.setVisibility(View.GONE);
            tv_stamp5.setVisibility(View.VISIBLE);
            tv_stamp6.setVisibility(View.VISIBLE);
            tv_stamp7.setVisibility(View.VISIBLE);
            tv_stamp8.setVisibility(View.VISIBLE);

            tv_stamp1_ck.setVisibility(View.VISIBLE);
            tv_stamp2_ck.setVisibility(View.VISIBLE);
            tv_stamp3_ck.setVisibility(View.VISIBLE);
            tv_stamp4_ck.setVisibility(View.VISIBLE);
            tv_stamp5_ck.setVisibility(View.GONE);
            tv_stamp6_ck.setVisibility(View.GONE);
            tv_stamp7_ck.setVisibility(View.GONE);
            tv_stamp8_ck.setVisibility(View.GONE);

        } else if(stampNumber == 5) {
            tv_stamp1.setVisibility(View.GONE);
            tv_stamp2.setVisibility(View.GONE);
            tv_stamp3.setVisibility(View.GONE);
            tv_stamp4.setVisibility(View.GONE);
            tv_stamp5.setVisibility(View.GONE);
            tv_stamp6.setVisibility(View.VISIBLE);
            tv_stamp7.setVisibility(View.VISIBLE);
            tv_stamp8.setVisibility(View.VISIBLE);

            tv_stamp1_ck.setVisibility(View.VISIBLE);
            tv_stamp2_ck.setVisibility(View.VISIBLE);
            tv_stamp3_ck.setVisibility(View.VISIBLE);
            tv_stamp4_ck.setVisibility(View.VISIBLE);
            tv_stamp5_ck.setVisibility(View.VISIBLE);
            tv_stamp6_ck.setVisibility(View.GONE);
            tv_stamp7_ck.setVisibility(View.GONE);
            tv_stamp8_ck.setVisibility(View.GONE);

        } else if(stampNumber == 6) {
            tv_stamp1.setVisibility(View.GONE);
            tv_stamp2.setVisibility(View.GONE);
            tv_stamp3.setVisibility(View.GONE);
            tv_stamp4.setVisibility(View.GONE);
            tv_stamp5.setVisibility(View.GONE);
            tv_stamp6.setVisibility(View.GONE);
            tv_stamp7.setVisibility(View.VISIBLE);
            tv_stamp8.setVisibility(View.VISIBLE);

            tv_stamp1_ck.setVisibility(View.VISIBLE);
            tv_stamp2_ck.setVisibility(View.VISIBLE);
            tv_stamp3_ck.setVisibility(View.VISIBLE);
            tv_stamp4_ck.setVisibility(View.VISIBLE);
            tv_stamp5_ck.setVisibility(View.VISIBLE);
            tv_stamp6_ck.setVisibility(View.VISIBLE);
            tv_stamp7_ck.setVisibility(View.GONE);
            tv_stamp8_ck.setVisibility(View.GONE);

        } else if(stampNumber == 7) {
            tv_stamp1.setVisibility(View.GONE);
            tv_stamp2.setVisibility(View.GONE);
            tv_stamp3.setVisibility(View.GONE);
            tv_stamp4.setVisibility(View.GONE);
            tv_stamp5.setVisibility(View.GONE);
            tv_stamp6.setVisibility(View.GONE);
            tv_stamp7.setVisibility(View.GONE);
            tv_stamp8.setVisibility(View.VISIBLE);

            tv_stamp1_ck.setVisibility(View.VISIBLE);
            tv_stamp2_ck.setVisibility(View.VISIBLE);
            tv_stamp3_ck.setVisibility(View.VISIBLE);
            tv_stamp4_ck.setVisibility(View.VISIBLE);
            tv_stamp5_ck.setVisibility(View.VISIBLE);
            tv_stamp6_ck.setVisibility(View.VISIBLE);
            tv_stamp7_ck.setVisibility(View.VISIBLE);
            tv_stamp8_ck.setVisibility(View.GONE);

        } else if(stampNumber == 8) {
            tv_stamp1.setVisibility(View.GONE);
            tv_stamp2.setVisibility(View.GONE);
            tv_stamp3.setVisibility(View.GONE);
            tv_stamp4.setVisibility(View.GONE);
            tv_stamp5.setVisibility(View.GONE);
            tv_stamp6.setVisibility(View.GONE);
            tv_stamp7.setVisibility(View.GONE);
            tv_stamp8.setVisibility(View.GONE);

            tv_stamp1_ck.setVisibility(View.VISIBLE);
            tv_stamp2_ck.setVisibility(View.VISIBLE);
            tv_stamp3_ck.setVisibility(View.VISIBLE);
            tv_stamp4_ck.setVisibility(View.VISIBLE);
            tv_stamp5_ck.setVisibility(View.VISIBLE);
            tv_stamp6_ck.setVisibility(View.VISIBLE);
            tv_stamp7_ck.setVisibility(View.VISIBLE);
            tv_stamp8_ck.setVisibility(View.VISIBLE);
        }




        // 스탬프 숫자 체크 끝 -------------------------------------------------------------------------

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        if(MainActivity.stampNumber == 8){
            Dialog();
        } else {

        }
    }

    public void Dialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림");
        builder.setMessage("온통대전 적립금 5000원이 추가되었습니다.");
        builder.setPositiveButton("확인",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(),"우측버튼 클릭됨",Toast.LENGTH_LONG).show();
                    }
                });
        builder.show();
    }

}
