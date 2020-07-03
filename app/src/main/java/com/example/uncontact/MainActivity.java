package com.example.uncontact;

import androidx.annotation.NonNull;
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

import com.example.uncontact.Do.DoActivity;
import com.example.uncontact.Do.DoDetailActivity;
import com.example.uncontact.MainBottom.bottom_sheet;
import com.example.uncontact.Mypage.mypage;
import com.example.uncontact.Res.RestaurantActivity;
import com.example.uncontact.alarm.alarm;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

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

public class MainActivity extends AppCompatActivity implements bottom_sheet.BottomSheetListener, MainReAdapter.OnItemClickListener {

    // 리사이클러뷰 관련 설정
    RecyclerView re_recmdRecyclerview;
    MainReAdapter mainReAdapter;
    ArrayList<MainReData> addMainItemClass;
    private MainReData mainReData;

    // 바텀 네비게이션
    TextView tv_qrCode;
    TextView tv_barCode;

    public static String qrcode;


    Button btBuying;
    TextView btTravel;
    TextView bt_mypageSend;

    // 스탬프 관련
    ImageView iv_stamImage;
    TextView tv_stampNumber;
    ImageView bt_alarm;
    static int stampNumber = 6;
    TextView tv_stampTitle;
    TextView tv_mainUsepay;
    static int mainUsepay = 20000;

    Intent intent;
    String TAG = "MainActivity";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(qrcode != null) {
            if (qrcode.equals("결제")) {
                //큐알코드 받아오기------------------------------
//            qrcode = intent.getStringExtra("qrcode");
                Log.i(TAG, "큐알코드" + qrcode);
                bottom_sheet bottomSheet = new bottom_sheet();
                bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");
            } else {

            }
        }

        //파이어베이스를 사용할 토큰 생성 시작 -------------------------------------------------------------
        FirebaseApp.initializeApp(this);
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();

                        // Log and toast
                        String msg = getString(R.string.msg_token_fmt, token);
                        Log.d(TAG, msg);
//                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

        //파이어베이스를 사용할 토큰 생성 끝 --------------------------------------------------------------


        // 메인 리사이클러뷰 시작 -----------------------------------------------------------------------

        addMainItemClass = new ArrayList<>();
        addMainItemClass.add(new MainReData(R.drawable.citytour, "볼거리", "대전 시티투어", "대전 핵심 관광지를 하나로!"));
        addMainItemClass.add(new MainReData(R.drawable.toto, "축제", "대전 토토즐 페스티벌", "토요일 토요일은 즐거워!"));
        addMainItemClass.add(new MainReData(R.drawable.tashu, "운동", "대전 시민 공용자전거", "원하는 장소에서 쉽게 대여하고, 사용후 편리하게 반납하는"));
        addMainItemClass.add(new MainReData(R.drawable.deachung, "힐링", "대청호 오백리길", "걸으며 사색하는 그림 속 호수"));
        addMainItemClass.add(new MainReData(R.drawable.manbal, "건강", "계족산 맨발축제", "숲속황톳길을 맨발로 걷거나 달리는 세계 유일의 맨발축제"));
        addMainItemClass.add(new MainReData(R.drawable.onchun, "치유", "유성온천문화축제", "천년온천 유성의 천가지 즐거움!"));
        addMainItemClass.add(new MainReData(R.drawable.untact, "휴식", "대전 언텍트 관광명소 추천", "코로나19로 쌓인 스트레스, 대전서 날려버려요!"));
        re_recmdRecyclerview = findViewById(R.id.re_recmdRecyclerview);
        re_recmdRecyclerview.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.HORIZONTAL));
        re_recmdRecyclerview.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2)); // 레이아웃 메니저
        // 장바구니 어레이리스트임
        // 이거를 buying class로 보내서 해당하는 사람들이 결제한 리스트가 뭔지 알아야한다.
        mainReAdapter = new MainReAdapter(addMainItemClass); // 어댑터에 리스트 붙이고
        re_recmdRecyclerview.setAdapter(mainReAdapter); // 리사이클러뷰에 어댑터 장착
        mainReAdapter.notifyDataSetChanged();

        // 리사이클러뷰에 데이터 넣기

        //어댑터 클릭리스너
        mainReAdapter.setOnItemClickListener(MainActivity.this);



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
//                Toast myToast = Toast.makeText(getApplicationContext(), "눌렀다", Toast.LENGTH_SHORT);LENGTH_SHORT
//                myToast.show();
                Intent travelIntent = new Intent(MainActivity.this, RestaurantActivity.class);
                startActivity(travelIntent);
                //애니메이션제거
                overridePendingTransition(0, 0);
            }
        });
        // 여행 보러가기 끝 ---------------------------------------------------------------------------

        //  스탬프 적립 시작 --------------------------------------------------------------------------
        iv_stamImage = findViewById(R.id.iv_stamImage);
        iv_stamImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 큐알코드 스캔 후 스탬프 레이아웃으로

                Intent intent = new Intent(MainActivity.this, QrCodeStampActivity.class);
                startActivity(intent);

//                startActivity(new Intent(getApplication(), stamp.class));
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

        tv_barCode = findViewById(R.id.tv_barCode);
        tv_barCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BarCodeActivity.class);
                startActivity(intent);
            }
        });

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

        // 스탬프 갯수 관련 시작 -----------------------------------------------------------------------

        tv_stampNumber = findViewById(R.id.tv_stampNumber);
        tv_stampNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), stamp.class));
            }
        });
        tv_stampNumber.setText(String.valueOf(stampNumber));
        tv_mainUsepay = findViewById(R.id.tv_mainUsepay);
        tv_mainUsepay.setText(String.valueOf(mainUsepay));

        tv_stampTitle = findViewById(R.id.tv_stampTitle);
        tv_stampTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), stamp.class));
            }
        });



        // 스탬프 갯수 관련 끝 -------------------------------------------------------------------------

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



    // 축제 상세정보 화면으로 이동 시작 /////////////////////////////////////////////////////////////////
    @Override
    public void onItemClick(int position) {
        Log.i(TAG,"리사이클러뷰 어댑터 클릭");
        Toast myToast = Toast.makeText(getApplicationContext(), "축제 상세화면으로 이동합니다", Toast.LENGTH_SHORT);
        myToast.show();


        Intent intentMain = new Intent(MainActivity.this, MainDetailActivity.class);
        mainReData = addMainItemClass.get(position);
        intentMain.putExtra("image", mainReData.getMainReImage());
        intentMain.putExtra("title", mainReData.getMainReTitle());
        intentMain.putExtra("intro",mainReData.getMainReContent());
        Log.i(TAG,"이미지~~~" +mainReData.getMainReImage());
        startActivity(intentMain);
        //애니메이션제거
        overridePendingTransition(0, 0);
    }

    //축체 상제 정보 화면 끝////////////////////////////////////////////////////////////////////////////

}
