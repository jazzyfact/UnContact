package com.example.uncontact.Model;

public class RideItem {

    //타슈 이미지, 1일권, 설명
    private int rideImage;
    private String rideTitle;
    private String rideIntro;

    public RideItem(int rideImage, String rideTitle, String rideIntro) {
        this.rideImage = rideImage;
        this.rideTitle = rideTitle;
        this.rideIntro = rideIntro;
    }


    public int getRideImage() {
        return rideImage;
    }

    public void setRideImage(int rideImage) {
        this.rideImage = rideImage;
    }

    public String getRideTitle() {
        return rideTitle;
    }

    public void setRideTitle(String rideTitle) {
        this.rideTitle = rideTitle;
    }

    public String getRideIntro() {
        return rideIntro;
    }

    public void setRideIntro(String rideIntro) {
        this.rideIntro = rideIntro;
    }
}
