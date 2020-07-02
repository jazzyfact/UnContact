package com.example.uncontact;

public class MainReData {
    //  메인 리사이클러뷰에 넣어줄 내용
    // 이미지, 타이틀 텍스트, 내용, 카테고리
//    String mainReImage;
    int mainReImage;
    String mainReCategory;
    String mainReTitle;
    String mainReContent;

    public MainReData(int mainReImage, String mainReCategory, String mainReTitle, String mainReContent) {
        this.mainReImage = mainReImage;
        this.mainReCategory = mainReCategory;
        this.mainReTitle = mainReTitle;
        this.mainReContent = mainReContent;
    }

    //    public MainReData(String mainReImage, String mainReCategory, String mainReTitle, String mainReContent) {
//        this.mainReImage = mainReImage;
//        this.mainReCategory = mainReCategory;
//        this.mainReTitle = mainReTitle;
//        this.mainReContent = mainReContent;
//    }

//    public String getMainReImage() {
//        return mainReImage;
//    }
//
//    public void setMainReImage(String mainReImage) {
//        this.mainReImage = mainReImage;
//    }


    public int getMainReImage() {
        return mainReImage;
    }

    public void setMainReImage(int mainReImage) {
        this.mainReImage = mainReImage;
    }

    public String getMainReCategory() {
        return mainReCategory;
    }

    public void setMainReCategory(String mainReCategory) {
        this.mainReCategory = mainReCategory;
    }

    public String getMainReTitle() {
        return mainReTitle;
    }

    public void setMainReTitle(String mainReTitle) {
        this.mainReTitle = mainReTitle;
    }

    public String getMainReContent() {
        return mainReContent;
    }

    public void setMainReContent(String mainReContent) {
        this.mainReContent = mainReContent;
    }
}
