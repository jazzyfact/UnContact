package com.example.uncontact.Res;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.uncontact.Adapter.ResCartListAdapter;
import com.example.uncontact.Adapter.RestaurantAdapter;
import com.example.uncontact.Adapter.StayAdapter;
import com.example.uncontact.Model.ResCartItem;
import com.example.uncontact.R;

import java.util.ArrayList;

public class ResCartActivity extends AppCompatActivity implements View.OnClickListener {




    private ArrayList<ResCartItem>list;

    private RecyclerView recyclerView;
    private ResCartListAdapter adapter;

    RecyclerView.LayoutManager mLayoutManager;
    String TAG = "ResCartActivity";



    Button btnPay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_cart);

        btnPay = findViewById(R.id.btn_pay);



        //리사이클러뷰 set
        recyclerView = findViewById(R.id.res_cart_list_recyclerview);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);





        //클릭이벤트
        btnPay.setOnClickListener(this);


        //리사이클러뷰 아이템 불러오기
        getData();

    }

    private void getData() {
        Log.i(TAG,"리사이클러뷰");

        ArrayList<ResCartItem> list = new ArrayList<>();
        list.add(new ResCartItem("짜장면",10000,"삭제",10000,R.drawable.ic_minus,10000,R.drawable.ic_add));
        list.add(new ResCartItem("짜장면",10000,"삭제",10000,R.drawable.ic_minus,10000,R.drawable.ic_add));
        list.add(new ResCartItem("짜장면",10000,"삭제",10000,R.drawable.ic_minus,10000,R.drawable.ic_add));
//        list.add(new ResCartItem("짜장면",10000,"삭제",10000,R.drawable.ic_minus,10000,R.drawable.ic_add));
//        list.add(new ResCartItem("짜장면",10000,"삭제",10000,R.drawable.ic_minus,10000,R.drawable.ic_add));

        adapter = new ResCartListAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        //어댑터클릭리스너
//        adapter.setOnItemClickListener(new RestaurantAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View v, int position) {
//                // 클릭했을때 원하는데로 처리해주는 부분
//                Toast myToast = Toast.makeText(getApplicationContext(),"포지션 눌렀다" + position, Toast.LENGTH_SHORT);
//                myToast.show();
//                Intent intentDetail = new Intent(ResCartActivity.this, RestaurantDetailActivity.class);
//                startActivity(intentDetail);
//            }
//        });
//


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //
            case R.id.btn_pay:
                Intent intentPay = new Intent(ResCartActivity.this, ResPayActivity.class);
                startActivity(intentPay);
                break;
        }
    }
}
