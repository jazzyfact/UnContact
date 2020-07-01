package com.example.uncontact;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uncontact.MainBottom.bottom_sheet;
import com.example.uncontact.Mypage.mypage;
import com.example.uncontact.Res.RestaurantActivity;
import com.example.uncontact.alarm.alarm;

import java.util.ArrayList;

import kr.co.bootpay.Bootpay;
import kr.co.bootpay.BootpayAnalytics;
import kr.co.bootpay.enums.Method;
import kr.co.bootpay.enums.PG;
import kr.co.bootpay.enums.UX;
import kr.co.bootpay.listener.CancelListener;
import kr.co.bootpay.listener.CloseListener;
import kr.co.bootpay.listener.ConfirmListener;
import kr.co.bootpay.listener.DoneListener;
import kr.co.bootpay.listener.ErrorListener;
import kr.co.bootpay.listener.ReadyListener;
import kr.co.bootpay.model.BootExtra;
import kr.co.bootpay.model.BootUser;

public class MainActivity extends AppCompatActivity implements bottom_sheet.BottomSheetListener {

    // 리사이클러뷰 관련 설정
    RecyclerView re_recmdRecyclerview;
    MainReAdapter mainReAdapter;
    ArrayList<MainReData> addMainItemClass;

    // 바텀 네비게이션
    TextView tv_qrCode;
    TextView tv_barCode;

    public static String qrcode;


    Button btBuying;
    TextView btTravel;
    TextView bt_mypageSend;

    // 스탬프 관련
    ImageView iv_stamImage;

    ImageView bt_alarm;

    Intent intent;
    String TAG = "MainActivity";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (qrcode != null) {
            //큐알코드 받아오기------------------------------
//            qrcode = intent.getStringExtra("qrcode");
            Log.i(TAG, "큐알코드" + qrcode);

            bottom_sheet bottomSheet = new bottom_sheet();
            bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");

        }


        // 메인 리사이클러뷰 시작 -----------------------------------------------------------------------

        addMainItemClass = new ArrayList<>();
        addMainItemClass.add(new MainReData("image1", "카데고리", "타이틀1", "내용1"));
        addMainItemClass.add(new MainReData("image1", "카데고리", "타이틀2", "내용2"));
        addMainItemClass.add(new MainReData("image1", "카데고리", "타이틀3", "내용3"));
        addMainItemClass.add(new MainReData("image1", "카데고리", "타이틀4", "내용4"));
        re_recmdRecyclerview = findViewById(R.id.re_recmdRecyclerview);
        re_recmdRecyclerview.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.HORIZONTAL));
        re_recmdRecyclerview.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2)); // 레이아웃 메니저
        // 장바구니 어레이리스트임
        // 이거를 buying class로 보내서 해당하는 사람들이 결제한 리스트가 뭔지 알아야한다.
        mainReAdapter = new MainReAdapter(addMainItemClass); // 어댑터에 리스트 붙이고
        re_recmdRecyclerview.setAdapter(mainReAdapter); // 리사이클러뷰에 어댑터 장착
        mainReAdapter.notifyDataSetChanged();

        // 리사이클러뷰에 데이터 넣기


        // 메인 리사이클러뷰 시작 -----------------------------------------------------------------------
        // 초기설정 - 해당 프로젝트(안드로이드)의 application id 값을 설정합니다. 결제와 통계를 위해 꼭 필
        BootpayAnalytics.init(this, "5ef8c37e4f74b40026f2b8f9");


        btBuying = findViewById(R.id.btBuying);
        btBuying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick_request(v);
            }
        });

        // 여행 보러가기 시작 --------------------------------------------------------------------------

        btTravel = findViewById(R.id.btTravel);
        btTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast myToast = Toast.makeText(getApplicationContext(), "눌렀다", Toast.LENGTH_SHORT);
                myToast.show();
                Intent travelIntent = new Intent(MainActivity.this, RestaurantActivity.class);
                startActivity(travelIntent);
            }
        });
        // 여행 보러가기 끝 ---------------------------------------------------------------------------

        //  스탬프 적립 시작 --------------------------------------------------------------------------
        iv_stamImage = findViewById(R.id.iv_stamImage);
        iv_stamImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 큐알코드 스캔 후 스탬프 레이아웃으로
                startActivity(new Intent(getApplication(), stamp.class));
            }
        });

        //  스탬프 적립 끝 ----------------------------------------------------------------------------

        // 바텀 네비게이션 시작 ------------------------------------------------------------------------

        tv_qrCode = findViewById(R.id.tv_qrCode);
        tv_qrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QrCodeActivity.class);
                startActivity(intent);


//                bottom_sheet bottomSheet = new bottom_sheet();
//                bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");
            }
        });

//        tv_barCode = findViewById(R.id.tv_barCode);
//        tv_barCode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        // 바텀 네비게이션 끝 --------------------------------------------------------------------------

        // 마이페이지 시작 ----------------------------------------------------------------------------
        bt_mypageSend = findViewById(R.id.bt_mypageSend);
        bt_mypageSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), mypage.class));
            }
        });
        // 마이페이지 끝 ------------------------------------------------------------------------------

        bt_alarm = findViewById(R.id.bt_alarm);
        bt_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), alarm.class));
            }
        });

    }

    // 부트페이 관련한 메소드 시작 -----------------------------------------------------------------------
    public void onClick_request(View v) {
        // 결제호출
        BootUser bootUser = new BootUser().setPhone("010-1234-5678");
        BootExtra bootExtra = new BootExtra().setQuotas(new int[]{0, 2, 3});

        Bootpay.init(getFragmentManager())
                .setApplicationId("5ef8c37e4f74b40026f2b8f9") // 해당 프로젝트(안드로이드)의 application id 값
                .setPG(PG.INICIS) // 결제할 PG 사
                .setMethod(Method.CARD) // 결제수단
                .setContext(this)
                .setBootUser(bootUser)
                .setBootExtra(bootExtra)
                .setUX(UX.PG_DIALOG)
//                .setUserPhone("010-1234-5678") // 구매자 전화번호
                .setName("이름") // 개결제할 상품명
                .setOrderId("1234") // 결제 고유번호expire_month
                .setPrice(2000) // 결제할 금액
                .addItem("마우's 스", 1, "ITEM_CODE_MOUSE", 2000) // 주문정보에 담길 상품정보, 통계를 위해 사용
                .addItem("키보드", 1, "ITEM_CODE_KEYBOARD", 0, "패션", "여성상의", "블라우스") // 주문정보에 담길 상품정보, 통계를 위해 사용
                .onConfirm(new ConfirmListener() { // 결제가 진행되기 바로 직전 호출되는 함수로, 주로 재고처리 등의 로직이 수행
                    @Override
                    public void onConfirm(@Nullable String message) {

//                        if (0 < stuck) Bootpay.confirm(message); // 재고가 있을 경우.
//                        else Bootpay.removePaymentWindow(); // 재고가 없어 중간에 결제창을 닫고 싶을 경우
                        Log.d("confirm", message);
                    }
                })
                .onDone(new DoneListener() { // 결제완료시 호출, 아이템 지급 등 데이터 동기화 로직을 수행합니다
                    @Override
                    public void onDone(@Nullable String message) {
                        Log.d("done", message);

                        //  결제가 완료되는  부분

                        Toast.makeText(getApplicationContext(), "결제가 완료되었습니다.", Toast.LENGTH_SHORT).show();

                    }
                })
                .onReady(new ReadyListener() { // 가상계좌 입금 계좌번호가 발급되면 호출되는 함수입니다.
                    @Override
                    public void onReady(@Nullable String message) {
                        Log.d("ready", message);
                    }
                })
                .onCancel(new CancelListener() { // 결제 취소시 호출
                    @Override
                    public void onCancel(@Nullable String message) {

                        Log.d("cancel", message);
                    }
                })
                .onError(new ErrorListener() { // 에러가 났을때 호출되는 부분
                    @Override
                    public void onError(@Nullable String message) {
                        Log.d("error", message);
                    }
                })
                .onClose(
                        new CloseListener() { //결제창이 닫힐때 실행되는 부분
                            @Override
                            public void onClose(String message) {
                                Log.d("close", "close");
                            }
                        })
                .request();

    }

    @Override
    public void onButtonClicked(String text) {
        Log.i("바텀시트 클릭함 ", "onButtonClicked: ");
    }
    // 부트페이 관련한 메소드 끝 -----------------------------------------------------------------------
}
