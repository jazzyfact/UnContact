package com.example.uncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainDetailActivity extends AppCompatActivity {

    private TextView tvMainSelectTitle,  tvMainSelectIntro;
    private ImageView ivMainSelectImage;
    private String title, image, intro;

    String TAG = "MainDetailActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);


        tvMainSelectTitle = findViewById(R.id.tv_main_select_title);
        ivMainSelectImage = findViewById(R.id.iv_main_select_image);
        tvMainSelectIntro = findViewById(R.id.tv_main_select_intro);

        Intent intent = getIntent();
        //image = String.valueOf(intent.getIntExtra("image",0));
        image = String.valueOf(intent.getIntExtra("image",0));
        title = intent.getStringExtra("title");
        intro = intent.getStringExtra("intro");

        Log.i(TAG,"이미지" + image);

//        ivMainSelectImage.setImageDrawable(Drawable.createFromPath(image));
//        ivMainSelectImage.setImageBitmap(image);
        ivMainSelectImage.setImageResource(Integer.parseInt(image));
        tvMainSelectTitle.setText(title);
        tvMainSelectIntro.setText(intro);
    }
}
