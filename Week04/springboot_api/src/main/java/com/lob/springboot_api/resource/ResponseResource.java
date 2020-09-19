package com.lob.springboot_api.resource;

import org.springframework.hateoas.RepresentationModel;

public class ResponseResource extends RepresentationModel {
    //title
    private String title;
    private String description;
    private String year;
    private String month;
    private String days;
    private String Total_Count;

    public static class Builder {

        private final String total_Count;

        private String title;
        private String description;
        private String year;
        private String month;
        private String days;

        public Builder(String total_Count) {
            this.total_Count = total_Count;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }
        public Builder description(String val) {
            description = val;
            return this;
        }
        public Builder year(String val) {
            year = val;
            return this;
        }
        public Builder month(String val) {
            month = val;
            return this;
        }
        public Builder days(String val) {
            days = val;
            return this;
        }

        public ResponseResource build() {
            return new ResponseResource(this);
        }

    }

    public ResponseResource(){

    }
    //
    public ResponseResource(String title,String description, String year, String month, String days, String total_Count){
        this.title = title;
        this.description = description;
        this.year = year;
        this.month = month;
        this.days = days;
        this.Total_Count = total_Count;
    }

    //빌더 패턴
    public ResponseResource(Builder builder) {
        title       = builder.title;
        description = builder.description;
        year        = builder.year;
        month       = builder.month;
        days        = builder.days;
        Total_Count = builder.total_Count;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getYear() {
        return year;
    }

    public String getTotal_Count() {
        return Total_Count;
    }

    public String getDays() {
        return days;
    }

    public String getMonth() {
        return month;
    }


}
