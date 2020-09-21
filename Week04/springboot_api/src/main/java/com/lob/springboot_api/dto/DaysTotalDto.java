package com.lob.springboot_api.dto;

public class DaysTotalDto {

    private String day;
    private long count;


    public static class Builder {

        private String day;
        private Long count;

        public Builder day(String val){
            day = val;
            return this;
        }

        public Builder count(long val){
            count = val;
            return this;
        }

        public DaysTotalDto build(){
            return new DaysTotalDto(this);
        }

    }

    public DaysTotalDto() {
    }

    public DaysTotalDto(Builder builder) {
        day = builder.day;
        count = builder.count;
    }

    public long getCount() {
        return count;
    }
}
