package com.example.buisness_app.model;

public class ItemList {

    int imgId;
    String name;
    String address;
    float rating;


    public ItemList(int imgId, String name, String address, float rating) {
        this.imgId = imgId;
        this.name = name;
        this.address = address;
        this.rating = rating;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
