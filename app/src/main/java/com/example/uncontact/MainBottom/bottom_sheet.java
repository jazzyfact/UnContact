package com.example.uncontact.MainBottom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.uncontact.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class bottom_sheet extends BottomSheetDialogFragment {
    Button bt_payment;
    LinearLayout ll_payment;
    LinearLayout ll_passwordPush;
    // 결제하기 쪽
    LinearLayout ll_passwordFine;
    Button bt_passSend;
    // 결제완료
    private BottomSheetListener mListener;

    // 비밀번호 누르기
    ImageView tv_btn1;
    ImageView tv_btn2;
    ImageView tv_btn3;
    ImageView tv_btn4;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_bottom_sheet, container, false);
        ll_payment = v.findViewById(R.id.ll_payment);
        ll_payment.setVisibility(View.VISIBLE);
        ll_passwordPush = v.findViewById(R.id.ll_passwordPush);
        ll_passwordFine = v.findViewById(R.id.ll_passwordFine);
        ll_passwordFine.setVisibility(View.GONE);
        // 바텀시트 버튼 누르면


        bt_payment = v.findViewById(R.id.bt_payment);
        bt_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_payment.setVisibility(View.GONE);
                ll_passwordFine.setVisibility(View.GONE);
                ll_passwordPush.setVisibility(View.VISIBLE);
            }
        });

        // 결제하기
        bt_passSend = v.findViewById(R.id.bt_passSend);
        bt_passSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_passwordPush.setVisibility(View.GONE);
                ll_passwordFine.setVisibility(View.VISIBLE);
            }
        });
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mListener.onButtonClicked("Button 1 clicked");
//                dismiss();
//            }
//        });
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mListener.onButtonClicked("Button 2 clicked");
//                dismiss();
//            }
//        });

        // 비밀번호 누르기 시작 ------------------------------------------------------------------------
        tv_btn1 = v.findViewById(R.id.tv_btn1);
        tv_btn2 = v.findViewById(R.id.tv_btn2);
        tv_btn3 = v.findViewById(R.id.tv_btn3);
        tv_btn4 = v.findViewById(R.id.tv_btn4);

        // 비밀번호 누르기 끝 --------------------------------------------------------------------------

        return v;

    }
    public interface BottomSheetListener {
        void onButtonClicked(String text);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (BottomSheetListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement BottomSheetListener");
        }
    }
}
