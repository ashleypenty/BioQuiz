package com.yinkash.bioquiz.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Result {

    private Integer id;
    private String createdOn;
    private Integer userId;
    private Integer score;

    public Result(Integer userId, Integer score) {
        this.userId = userId;
        this.score = score;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return this.score;
    }
}
