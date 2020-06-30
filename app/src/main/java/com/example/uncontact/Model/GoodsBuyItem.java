package com.example.uncontact.Model;

public class GoodsBuyItem {

    //굿즈 이미지, 굿즈이름, 굿즈설명
    private int goodsImage;
    private String goosTitle;
    private String goosIntro;

    //생성자
    public GoodsBuyItem(int goodsImage, String goosTitle, String goosIntro) {
        this.goodsImage = goodsImage;
        this.goosTitle = goosTitle;
        this.goosIntro = goosIntro;
    }

    //게터세터
    public int getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(int goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getGoosTitle() {
        return goosTitle;
    }

    public void setGoosTitle(String goosTitle) {
        this.goosTitle = goosTitle;
    }

    public String getGoosIntro() {
        return goosIntro;
    }

    public void setGoosIntro(String goosIntro) {
        this.goosIntro = goosIntro;
    }
}
