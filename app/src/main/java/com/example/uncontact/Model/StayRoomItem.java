package com.example.uncontact.Model;

public class StayRoomItem {

    //호텔방사진, 호텔방이름, 호텔방설명,
    private int stayRoomImage;
    private String stayRoomitle;
    private String stayRoomContent;

    public StayRoomItem(int stayRoomImage, String stayRoomitle, String stayRoomContent) {
        this.stayRoomImage = stayRoomImage;
        this.stayRoomitle = stayRoomitle;
        this.stayRoomContent = stayRoomContent;
    }

    public int getStayRoomImage() {
        return stayRoomImage;
    }

    public void setStayRoomImage(int stayRoomImage) {
        this.stayRoomImage = stayRoomImage;
    }

    public String getStayRoomitle() {
        return stayRoomitle;
    }

    public void setStayRoomitle(String stayRoomitle) {
        this.stayRoomitle = stayRoomitle;
    }

    public String getStayRoomContent() {
        return stayRoomContent;
    }

    public void setStayRoomContent(String stayRoomContent) {
        this.stayRoomContent = stayRoomContent;
    }
}
