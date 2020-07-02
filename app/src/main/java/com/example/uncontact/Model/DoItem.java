package com.example.uncontact.Model;

public class DoItem {


    //언택트관광 이미지, 언택트관광이름, 언택트관광 설명
    private int doImage;
    private String doTitle;
    private String doIntro;

    public DoItem(int doImage, String doTitle, String doIntro) {
        this.doImage = doImage;
        this.doTitle = doTitle;
        this.doIntro = doIntro;
    }

    public int getDoImage() {
        return doImage;
    }

    public void setDoImage(int doImage) {
        this.doImage = doImage;
    }

    public String getDoTitle() {
        return doTitle;
    }

    public void setDoTitle(String doTitle) {
        this.doTitle = doTitle;
    }

    public String getDoIntro() {
        return doIntro;
    }

    public void setDoIntro(String doIntro) {
        this.doIntro = doIntro;
    }
}
