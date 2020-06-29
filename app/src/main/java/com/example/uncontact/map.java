package com.example.uncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.naver.maps.map.NaverMapSdk;

public class map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        NaverMapSdk.getInstance(this).setClient(
                new NaverMapSdk.NaverCloudPlatformClient("eu6zrbl386"));
    }
}
