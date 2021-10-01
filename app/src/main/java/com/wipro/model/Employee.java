package com.wipro.model;

public class Employee {
    private String userId;
    private String jobTitleName;
    private String preferredFullName;
    private String region;
    private String phoneNumber;
    private String emailAddress;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJobTitleName() {
        return jobTitleName;
    }

    public void setJobTitleName(String jobTitleName) {
        this.jobTitleName = jobTitleName;
    }

    public String getPreferredFullName() {
        return preferredFullName;
    }

    public void setPreferredFullName(String preferredFullName) {
        this.preferredFullName = preferredFullName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
