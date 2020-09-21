package com.lob.springboot_api.dto;

public class ExcelFileDto {

    private Long requestID;
    private String requestCode;
    private String userID;
    private String createDate;
    private String hr_Organ;
    private String username;
    private String password;

    public String getUserID() {
        return userID;
    }

    public String getHr_Organ() {
        return hr_Organ;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Long getRequestID() {
        return requestID;
    }

    public String getRequestCode() {
        return requestCode;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setHr_Organ(String hr_Organ) {
        this.hr_Organ = hr_Organ;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRequestID(Long requestID) { this.requestID = requestID; }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public class Builder {

        private Long requestID;
        private String requestCode;
        private String userID;
        private String createDate;
        private String hr_Organ;
        private String username;
        private String password;

        public Builder requestID(Long val){
            requestID = val;
            return this;
        }

        public Builder requestCode(String val){
            requestCode = val;
            return this;
        }

        public Builder userID(String val){
            userID = val;
            return this;
        }

        public Builder createDate(String val){
            createDate = val;
            return this;
        }

        public Builder organ(String val){
            hr_Organ = val;
            return this;
        }

        public Builder username(String val){
            username = val;
            return this;
        }

        public Builder password(String val){
            password = val;
            return this;
        }

        public ExcelFileDto build() {
            return new ExcelFileDto(this);
        }
    }

    public ExcelFileDto() {
    }

    public ExcelFileDto(Builder builder){
        requestID = builder.requestID;
        requestCode = builder.requestCode;
        userID = builder.userID;
        createDate = builder.createDate;
        hr_Organ = builder.hr_Organ;
        username = builder.username;
        password = builder.password;
    }

}
