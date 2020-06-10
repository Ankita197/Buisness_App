package com.example.buisness_app.model;

public class ItemAd {
    int imgId;
    String adsTitle;
    String adsDescription;
    String adsBy;

    public ItemAd(int imgId, String adsTitle, String adsDescription, String adsBy) {
        this.imgId = imgId;
        this.adsTitle = adsTitle;
        this.adsDescription = adsDescription;
        this.adsBy = adsBy;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getAdsTitle() {
        return adsTitle;
    }

    public void setAdsTitle(String adsTitle) {
        this.adsTitle = adsTitle;
    }

    public String getAdsDescription() {
        return adsDescription;
    }

    public void setAdsDescription(String adsDescription) {
        this.adsDescription = adsDescription;
    }

    public String getAdsBy() {
        return adsBy;
    }

    public void setAdsBy(String adsBy) {
        this.adsBy = adsBy;
    }
}
