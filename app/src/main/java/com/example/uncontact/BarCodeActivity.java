package com.example.uncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.uncontact.GoodsBuy.GoodsBuyCartActivity;
import com.example.uncontact.GoodsBuy.GoodsBuyDetailActivity;
import com.example.uncontact.Res.RestaurantDetailActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class BarCodeActivity extends AppCompatActivity {

    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code);


        //zzing 라이브러리
        //상업적으로 사용시 저작권 적어줘야함
        //http://www.apache.org/licenses/LICENSE-2.0 아파치 라이센스
        //스택오버 플로우 질문과 답변 https://stackoverflow.com/questions/10293870/could-i-use-zxing-for-business-purpose
        //깃허브 주소 https://github.com/zxing/zxing
        //스캔 되는 코드
        qrScan = new IntentIntegrator(this);
        qrScan.setOrientationLocked(false); // default가 세로모드인데 휴대폰 방향에 따라 가로, 세로로 자동 변경됩니다.
        qrScan.initiateScan();

    }

    //qr코드 결과값 받아오는 거
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(result != null) {

            //QR코드 읽어서 가져오는 부분
            //result.getContents
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                // todo
            } else {
//                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();

                String qrCodeGet =  result.getContents();

                Intent intent = new Intent(BarCodeActivity.this, GoodsBuyDetailActivity.class);
                // 굿즈 디테일로 보내기
//                image = String.valueOf(intent.getIntExtra("image",0));
//                title = intent.getStringExtra("title");
//                intro = intent.getStringExtra("intro");

                intent.putExtra("title","대전시 기념품");
                intent.putExtra("intro","기념품에 대한 설명");
                intent.putExtra("qrcode",qrCodeGet);
                startActivity(intent);

                MainActivity.qrcode = "결제";

//                bottom_sheet bottomSheet = new bottom_sheet();
//                bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");

                Log.d("확인","큐알코드 값" + qrCodeGet);
                // todo
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }


    }


}
