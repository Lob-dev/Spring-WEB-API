package com.lob.springboot_api.dto;

public class UserDto {

    private String userID;
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


    public static class Builder {

        private String userID;
        private String hr_Organ;
        private String username;
        private String password;

        public Builder userId(String val) {
            userID = val;
            return this;
        }

        public Builder hr_Organ(String val) {
            hr_Organ = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public UserDto build(){
            return new UserDto(this);
        }

    }

    public UserDto() {
    }


    private UserDto(Builder builder) {
        userID = builder.userID;
        hr_Organ = builder.hr_Organ;
        username = builder.username;
        password = builder.password;
    }

}
