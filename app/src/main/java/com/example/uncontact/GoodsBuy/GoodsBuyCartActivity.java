package com.example.uncontact.GoodsBuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.uncontact.Adapter.GoodsCartListAdapter;
import com.example.uncontact.Adapter.ResCartListAdapter;
import com.example.uncontact.Model.GoodsCartItem;
import com.example.uncontact.R;
import com.example.uncontact.Res.ResSelectMenuActivity;
import com.example.uncontact.Res.RestaurantDetailActivity;

import java.util.ArrayList;

public class GoodsBuyCartActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<GoodsCartItem> list;
    private RecyclerView recyclerView;
    private GoodsCartListAdapter adapter;

    RecyclerView.LayoutManager mLayoutManager;
    String TAG = "GoodsBuyCartActivity";

    Button btnGoodsBuyPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_buy_cart);

        btnGoodsBuyPay = findViewById(R.id.btn_goods_buy_pay);

        //리사이클러뷰 set
        recyclerView = findViewById(R.id.goods_cart_list_recyclerview);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        //클릭리스너
        btnGoodsBuyPay.setOnClickListener(this);

        //리사이클러뷰 아이템 불러오기
        getData();
    }

    private void getData() {
        Log.i(TAG,"리사이클러뷰");

        ArrayList<GoodsCartItem> list = new ArrayList<>();
        list.add(new GoodsCartItem("기념품 이름1",10000,"삭제",10000,R.drawable.ic_minus,1,R.drawable.ic_add));
        list.add(new GoodsCartItem("기념품 이름2",10000,"삭제",10000,R.drawable.ic_minus,1,R.drawable.ic_add));
        list.add(new GoodsCartItem("기념품 이름3",10000,"삭제",10000,R.drawable.ic_minus,1,R.drawable.ic_add));
        list.add(new GoodsCartItem("기념품 이름4",10000,"삭제",10000,R.drawable.ic_minus,1,R.drawable.ic_add));



        adapter = new GoodsCartListAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_goods_buy_pay:
                Intent intentDetail = new Intent(GoodsBuyCartActivity.this, GoodsBuyPayActivity.class);
                startActivity(intentDetail);
                break;

        }
    }
}
