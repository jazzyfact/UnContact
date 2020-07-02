package com.example.uncontact.Model;

public class ResMenuItem {

    //메뉴사진, 메뉴이름, 메뉴설명,
    private String category;
    private int resMenuImage;
    private String resMenuTitle;
    private String resMenuContent;

    public ResMenuItem(int resMenuImage, String resDetailTitle, String resDetailMenu) {
        this.resMenuImage = resMenuImage;
        this.resMenuTitle = resDetailTitle;
        this.resMenuContent = resDetailMenu;
    }


    public ResMenuItem(String category, int resMenuImage, String resMenuTitle, String resMenuContent) {
        this.category = category;
        this.resMenuImage = resMenuImage;
        this.resMenuTitle = resMenuTitle;
        this.resMenuContent = resMenuContent;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getResMenuImage() {
        return resMenuImage;
    }

    public void setResMenuImage(int resMenuImage) {
        this.resMenuImage = resMenuImage;
    }

    public String getResMenuTitle() {
        return resMenuTitle;
    }

    public void setResMenuTitle(String resMenuTitle) {
        this.resMenuTitle = resMenuTitle;
    }

    public String getResMenuContent() {
        return resMenuContent;
    }

    public void setResMenuContent(String resMenuContent) {
        this.resMenuContent = resMenuContent;
    }
}
