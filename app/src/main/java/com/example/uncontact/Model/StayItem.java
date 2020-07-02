package com.example.uncontact.Model;

public class StayItem {


    //자슈 이미지, 숙소이름, 숙소설명
    private int stayImage;
    private String stayTitle;
    private String stayIntro;
    private int stayStar;

    public StayItem(int stayImage, String stayTitle, String stayIntro, int stayStar) {
        this.stayImage = stayImage;
        this.stayTitle = stayTitle;
        this.stayIntro = stayIntro;
        this.stayStar = stayStar;
    }

    public int getStayStar() {
        return stayStar;
    }

    public void setStayStar(int stayStar) {
        this.stayStar = stayStar;
    }

    public int getStayImage() {
        return stayImage;
    }

    public void setStayImage(int stayImage) {
        this.stayImage = stayImage;
    }

    public String getStayTitle() {
        return stayTitle;
    }

    public void setStayTitle(String stayTitle) {
        this.stayTitle = stayTitle;
    }

    public String getStayIntro() {
        return stayIntro;
    }

    public void setStayIntro(String stayIntro) {
        this.stayIntro = stayIntro;
    }
}
