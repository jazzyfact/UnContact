package com.example.uncontact.Do;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uncontact.R;

public class DoDetailActivity extends AppCompatActivity {

    private TextView tvDoSelectTitle, tvDoSelectIntro;
    private ImageView ivDoSelectImage;
    private String title, image, intro;

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
    }
}
