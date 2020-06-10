package com.example.buisness_app.model;

public class ItemMainJob {
    String jobTitle;
    String jobDescription;
    String jobPostedOn;
    String lastDateToApply;
    int noOfVacancy;

    public ItemMainJob(String jobTitle, String jobDescription, String jobPostedOn, String lastDateToApply, int noOfVacancy) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobPostedOn = jobPostedOn;
        this.lastDateToApply = lastDateToApply;
        this.noOfVacancy = noOfVacancy;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobPostedOn() {
        return jobPostedOn;
    }

    public void setJobPostedOn(String jobPostedOn) {
        this.jobPostedOn = jobPostedOn;
    }

    public String getLastDateToApply() {
        return lastDateToApply;
    }

    public void setLastDateToApply(String lastDateToApply) {
        this.lastDateToApply = lastDateToApply;
    }

    public int getNoOfVacancy() {
        return noOfVacancy;
    }

    public void setNoOfVacancy(int noOfVacancy) {
        this.noOfVacancy = noOfVacancy;
    }
}
