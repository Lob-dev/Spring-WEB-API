package com.lob.springboot_api.entity;


public class RequestInfo {

    private Long requestID;
    private String requestCode;
    private String userID;
    private String createDate;

    public void setRequestID(Long requestID) { this.requestID = requestID;}

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Long getRequestID() {
        return requestID;
    }

    public String getRequestCode() {
        return requestCode;
    }

    public String getUserID() {
        return userID;
    }

    public String getCreateDate() {
        return createDate;
    }
}
