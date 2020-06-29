package com.example.uncontact.Model;

import android.graphics.drawable.Drawable;
import android.widget.RatingBar;

public class Travel {

    //가게이미지, 가게이름, 가게소개글, 가게 평점
    private Drawable Image;
    private String restaurantName;
    private String restaurantIntro;
    private RatingBar restaurantStar;


    public Drawable getImage() {
        return Image;
    }

    public void setImage(Drawable image) {
        Image = image;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantIntro() {
        return restaurantIntro;
    }

    public void setRestaurantIntro(String restaurantIntro) {
        this.restaurantIntro = restaurantIntro;
    }

    public RatingBar getRestaurantStar() {
        return restaurantStar;
    }

    public void setRestaurantStar(RatingBar restaurantStar) {
        this.restaurantStar = restaurantStar;
    }
}
