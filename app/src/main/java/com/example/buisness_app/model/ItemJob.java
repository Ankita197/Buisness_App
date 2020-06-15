package com.example.buisness_app.model;

public class ItemJob {
    int imgId;
    String jobType;

    public ItemJob(int imgId, String jobType) {
        this.imgId = imgId;
        this.jobType = jobType;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
}
