package com.example.uncontact.Model;

import android.graphics.drawable.Drawable;
import android.widget.RatingBar;

public class RestaurantItem {

    //가게이미지, 가게이름, 가게소개글, 가게 평점
    private String category;
    private int Image;
    private String restaurantName;
    private String restaurantIntro;
    private int restaurantStar;

    public RestaurantItem(int image, String restaurantName, String restaurantIntro, int restaurantStar) {
        this.Image = image;
        this.restaurantName = restaurantName;
        this.restaurantIntro = restaurantIntro;
        this.restaurantStar = restaurantStar;
    }



    public RestaurantItem(String category, int image, String restaurantName, String restaurantIntro, int restaurantStar) {
        this.category = category;
        Image = image;
        this.restaurantName = restaurantName;
        this.restaurantIntro = restaurantIntro;
        this.restaurantStar = restaurantStar;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
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



    public void setRestaurantStar(int restaurantStar) {
        this.restaurantStar = restaurantStar;
    }

    public float getRating() {
        return restaurantStar;
    }

}
