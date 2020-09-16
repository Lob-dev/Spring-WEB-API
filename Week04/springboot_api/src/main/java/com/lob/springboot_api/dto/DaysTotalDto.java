package com.lob.springboot_api.dto;

public class DaysTotalDto {

    private String day;
    private long count;

    public void setDay(String day) {
        this.day = day;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }
}
