package com.example.uncontact.Do;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uncontact.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DoDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private TextView tvDoSelectTitle, tvDoSelectIntro;
    private ImageView ivDoSelectImage;
    private String title, image, intro;
    MapView mapView;

    GoogleMap mMap;
    String TAG = "DoDetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_detail);


        tvDoSelectTitle = findViewById(R.id.tv_do_select_title);
        ivDoSelectImage =  findViewById(R.id.iv_do_select_image);
        tvDoSelectIntro = findViewById(R.id.tv_do_select_intro);


        Intent intent = getIntent();
        image = String.valueOf(intent.getIntExtra("image",0));
        title = intent.getStringExtra("title");
        intro = intent.getStringExtra("intro");

        Log.i(TAG,"이미지" + image);

        ivDoSelectImage.setImageResource(Integer.parseInt(image));
        tvDoSelectTitle.setText(title);
        tvDoSelectIntro.setText(intro);

        //구글지도
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapview);
        mapFragment.getMapAsync(this);



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // 구글 맵 객체를 불러온다.
        mMap = googleMap;

        // 서울 여의도에 대한 위치 설정
        LatLng seoul = new LatLng(37.52487, 126.92723);

        // 구글 맵에 표시할 마커에 대한 옵션 설정
        MarkerOptions makerOptions = new MarkerOptions();
        makerOptions
                .position(seoul)
                .title("원하는 위치(위도, 경도)에 마커를 표시했습니다.");

        // 마커를 생성한다.
        mMap.addMarker(makerOptions);

        //카메라를 여의도 위치로 옮긴다.
        mMap.moveCamera(CameraUpdateFactory.newLatLng(seoul));
    }
}
