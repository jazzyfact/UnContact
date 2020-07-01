package com.example.uncontact.Model;

public class GoodsCartItem {

    String itemTvGoodsBuyCartTitle;
    int itemTvGoodsBuyCartPrice;
    String itemTvGoodsBuyCartDelete;
    int itemTvGoodsBuyCartTotalPrice;
    int itemGoodsBuyCartMinus;
    int itemGoodsBuyCartCountNum;
    int itemGoodsBuyCartPlus;

    public GoodsCartItem(String itemTvGoodsBuyCartTitle, int itemTvGoodsBuyCartPrice, String itemTvGoodsBuyCartDelete, int itemTvGoodsBuyCartTotalPrice, int itemGoodsBuyCartMinus, int itemGoodsBuyCartCountNum, int itemGoodsBuyCartPlus) {
        this.itemTvGoodsBuyCartTitle = itemTvGoodsBuyCartTitle;
        this.itemTvGoodsBuyCartPrice = itemTvGoodsBuyCartPrice;
        this.itemTvGoodsBuyCartDelete = itemTvGoodsBuyCartDelete;
        this.itemTvGoodsBuyCartTotalPrice = itemTvGoodsBuyCartTotalPrice;
        this.itemGoodsBuyCartMinus = itemGoodsBuyCartMinus;
        this.itemGoodsBuyCartCountNum = itemGoodsBuyCartCountNum;
        this.itemGoodsBuyCartPlus = itemGoodsBuyCartPlus;
    }


    public String getItemTvGoodsBuyCartTitle() {
        return itemTvGoodsBuyCartTitle;
    }

    public void setItemTvGoodsBuyCartTitle(String itemTvGoodsBuyCartTitle) {
        this.itemTvGoodsBuyCartTitle = itemTvGoodsBuyCartTitle;
    }

    public int getItemTvGoodsBuyCartPrice() {
        return itemTvGoodsBuyCartPrice;
    }

    public void setItemTvGoodsBuyCartPrice(int itemTvGoodsBuyCartPrice) {
        this.itemTvGoodsBuyCartPrice = itemTvGoodsBuyCartPrice;
    }

    public String getItemTvGoodsBuyCartDelete() {
        return itemTvGoodsBuyCartDelete;
    }

    public void setItemTvGoodsBuyCartDelete(String itemTvGoodsBuyCartDelete) {
        this.itemTvGoodsBuyCartDelete = itemTvGoodsBuyCartDelete;
    }

    public int getItemTvGoodsBuyCartTotalPrice() {
        return itemTvGoodsBuyCartTotalPrice;
    }

    public void setItemTvGoodsBuyCartTotalPrice(int itemTvGoodsBuyCartTotalPrice) {
        this.itemTvGoodsBuyCartTotalPrice = itemTvGoodsBuyCartTotalPrice;
    }

    public int getItemGoodsBuyCartMinus() {
        return itemGoodsBuyCartMinus;
    }

    public void setItemGoodsBuyCartMinus(int itemGoodsBuyCartMinus) {
        this.itemGoodsBuyCartMinus = itemGoodsBuyCartMinus;
    }

    public int getItemGoodsBuyCartCountNum() {
        return itemGoodsBuyCartCountNum;
    }

    public void setItemGoodsBuyCartCountNum(int itemGoodsBuyCartCountNum) {
        this.itemGoodsBuyCartCountNum = itemGoodsBuyCartCountNum;
    }

    public int getItemGoodsBuyCartPlus() {
        return itemGoodsBuyCartPlus;
    }

    public void setItemGoodsBuyCartPlus(int itemGoodsBuyCartPlus) {
        this.itemGoodsBuyCartPlus = itemGoodsBuyCartPlus;
    }
}
