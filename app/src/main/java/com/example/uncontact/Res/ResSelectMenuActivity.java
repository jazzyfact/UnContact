package com.example.uncontact.Res;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uncontact.R;

public class ResSelectMenuActivity extends AppCompatActivity implements  View.OnClickListener {

    Button btnResAddCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_select_menu);

        btnResAddCart = findViewById(R.id.btn_res_add_cart);


        btnResAddCart.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //
            case R.id.btn_res_add_cart:
                Intent intentAddCart = new Intent(ResSelectMenuActivity.this, ResCartActivity.class);
                startActivity(intentAddCart);

                break;
        }
    }
}
