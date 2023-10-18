package com.example.community.dto;

import io.swagger.models.auth.In;

/**
 * @author zhf
 */
public class MonthRoom {
    private String month;
    private Integer num;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
