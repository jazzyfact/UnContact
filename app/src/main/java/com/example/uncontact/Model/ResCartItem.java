package com.example.uncontact.Model;

import android.widget.ImageView;

public class ResCartItem {

    //item_tv_res_pay_title  item_tv_res_pay_price item_tv_res_pay_delete item_tv_res_pay_total_price
    //item_res_pay_minus  item_res_pay_count_num item_res_pay_plus

    String itemTvResPayTitle;
    int itemTvResPayPrice;
    String itemTvResPayDelete;
    int itemTvResPayTotalPrice;
    int itemResPayMinus;
    int itemResPayCountNum;
    int itemResPayPlus;

    public ResCartItem(String itemTvResPayTitle, int itemTvResPayPrice, String itemTvResPayDelete, int itemTvResPayTotalPrice, int itemResPayMinus, int itemResPayCountNum, int itemResPayPlus) {
        this.itemTvResPayTitle = itemTvResPayTitle;
        this.itemTvResPayPrice = itemTvResPayPrice;
        this.itemTvResPayDelete = itemTvResPayDelete;
        this.itemTvResPayTotalPrice = itemTvResPayTotalPrice;
        this.itemResPayMinus = itemResPayMinus;
        this.itemResPayCountNum = itemResPayCountNum;
        this.itemResPayPlus = itemResPayPlus;
    }



    public String getItemTvResPayTitle() {
        return itemTvResPayTitle;
    }

    public void setItemTvResPayTitle(String itemTvResPayTitle) {
        this.itemTvResPayTitle = itemTvResPayTitle;
    }

    public int getItemTvResPayPrice() {
        return itemTvResPayPrice;
    }

    public void setItemTvResPayPrice(int itemTvResPayPrice) {
        this.itemTvResPayPrice = itemTvResPayPrice;
    }

    public String getItemTvResPayDelete() {
        return itemTvResPayDelete;
    }

    public void setItemTvResPayDelete(String itemTvResPayDelete) {
        this.itemTvResPayDelete = itemTvResPayDelete;
    }

    public int getItemTvResPayTotalPrice() {
        return itemTvResPayTotalPrice;
    }

    public void setItemTvResPayTotalPrice(int itemTvResPayTotalPrice) {
        this.itemTvResPayTotalPrice = itemTvResPayTotalPrice;
    }

    public int getItemResPayMinus() {
        return itemResPayMinus;
    }

    public void setItemResPayMinus(int itemResPayMinus) {
        this.itemResPayMinus = itemResPayMinus;
    }

    public int getItemResPayCountNum() {
        return itemResPayCountNum;
    }

    public void setItemResPayCountNum(int itemResPayCountNum) {
        this.itemResPayCountNum = itemResPayCountNum;
    }

    public int getItemResPayPlus() {
        return itemResPayPlus;
    }

    public void setItemResPayPlus(int itemResPayPlus) {
        this.itemResPayPlus = itemResPayPlus;
    }
}
