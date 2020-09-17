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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setTotal_Count(String total_Count) {
        Total_Count = total_Count;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
