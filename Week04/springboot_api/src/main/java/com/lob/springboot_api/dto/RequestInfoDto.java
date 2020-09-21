package com.lob.springboot_api.dto;


import org.omg.PortableInterceptor.RequestInfo;

public class RequestInfoDto {

    private Long requestID;
    private String requestCode;
    private String userID;
    private String createDate;

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

    public static class Builder {
        private Long requestID;
        private String requestCode;
        private String userID;
        private String createDate;

        public Builder requestID(Long val){
            requestID = val;
            return this;
        }

        public Builder requestCode(String val){
            requestCode = val;
            return this;
        }

        public Builder userID(String val) {
            userID = val;
            return this;
        }

        public Builder createDate(String val) {
            createDate = val;
            return this;
        }

        public RequestInfoDto build() {
            return new RequestInfoDto(this);
        }

    }

    public RequestInfoDto() {
    }

    public RequestInfoDto(Builder builder) {
        requestID = builder.requestID;
        requestCode = builder.requestCode;
        userID = builder.userID;
        createDate = builder.createDate;
    }
}
