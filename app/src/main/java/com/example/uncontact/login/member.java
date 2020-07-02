package com.example.uncontact.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uncontact.R;
import com.example.uncontact.alarm.alarm;

public class member extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button bt_member; // 회원가입 완료 버튼
    EditText et_memberPw;
    EditText et_memberId;
    Spinner sp_memberSelctAge;
    Spinner sp_memberSelct;


    // 남자 여자 기타 클릭 관련 선언
    TextView tv_genderMan;
    TextView tv_genderWoman;
    TextView tv_genderetc;
    TextView tv_genderMan_click;
    TextView tv_genderWoman_click;
    TextView tv_genderetc_click;

    //스피너 아이템 배열
    String[] selectAge;
    String[] selectContry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        bt_member = findViewById(R.id.bt_member);
        bt_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), login.class));
                Toast.makeText(member.this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        // 연령대 스피너 시작 --------------------------------------------------------------------------
        sp_memberSelctAge = findViewById(R.id.sp_memberSelctAge);
        // 해당하는 스피너에 리스너 붙이기
        sp_memberSelctAge.setOnItemSelectedListener(this);
        selectAge = new String[]{"선택하세요","10대","20대","30대","40대","50대","60대","60대 이상"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,selectAge);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_memberSelctAge.setAdapter(adapter);
        // 연령대 스피너 끝 ----------------------------------------------------------------------------

        // 지역 스피너 시작 ---------------------------------------------------------------------------
        sp_memberSelct = findViewById(R.id.sp_memberSelct);
        sp_memberSelct.setOnItemSelectedListener(this);
        selectContry = new String[]{"선택하세요","서울","대전","부산","대구","광주","경기도","인천","울산","기타 지역"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,selectContry);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_memberSelct.setAdapter(adapter2);
        // 지역 스피너 끝 -----------------------------------------------------------------------------

        // 성별 선택 시작 -----------------------------------------------------------------------------
        tv_genderMan = findViewById(R.id.tv_genderMan);
        tv_genderWoman = findViewById(R.id.tv_genderWoman);
        tv_genderetc = findViewById(R.id.tv_genderetc);
        tv_genderMan_click = findViewById(R.id.tv_genderMan_click);
        tv_genderWoman_click = findViewById(R.id.tv_genderWoman_click);
        tv_genderetc_click = findViewById(R.id.tv_genderetc_click);
        // 남자를 눌렀을때
        tv_genderMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_genderMan.setVisibility(View.GONE);
                tv_genderMan_click.setVisibility(View.VISIBLE);

                tv_genderWoman.setVisibility(View.VISIBLE);
                tv_genderWoman_click.setVisibility(View.GONE);

                tv_genderetc.setVisibility(View.VISIBLE);
                tv_genderetc_click.setVisibility(View.GONE);
            }
        });

        // 여자를를 눌렀을때
        tv_genderWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_genderMan.setVisibility(View.VISIBLE);
                tv_genderMan_click.setVisibility(View.GONE);

                tv_genderWoman.setVisibility(View.GONE);
                tv_genderWoman_click.setVisibility(View.VISIBLE);

                tv_genderetc.setVisibility(View.VISIBLE);
                tv_genderetc_click.setVisibility(View.GONE);
            }
        });

        // 여자를를 눌렀을때
        tv_genderetc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_genderMan.setVisibility(View.VISIBLE);
                tv_genderMan_click.setVisibility(View.GONE);

                tv_genderWoman.setVisibility(View.VISIBLE);
                tv_genderWoman_click.setVisibility(View.GONE);

                tv_genderetc.setVisibility(View.GONE);
                tv_genderetc_click.setVisibility(View.VISIBLE);
            }
        });

        // 성별 선택 끝 -------------------------------------------------------------------------------

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
