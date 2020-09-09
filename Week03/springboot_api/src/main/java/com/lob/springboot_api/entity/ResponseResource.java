package com.lob.springboot_api.entity;

import org.springframework.hateoas.RepresentationModel;

public class ResponseResource extends RepresentationModel {
    //title
    private String title;
    private String description;
    private String year;
    private String Total_Count;
    private ResourceStatus is_Success = ResourceStatus.FALSE;

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

    public ResourceStatus getIs_Success() {
        return is_Success;
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

    public void setIs_Success(ResourceStatus is_Success) {
        this.is_Success = is_Success;
    }
}
