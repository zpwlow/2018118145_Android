package com.example.stickynotes.model;

public class OneHome {
    private  String saying;  //语录
    private  String from ;  //来自
    private  String date ;  //日期
    private  String time ;  //时间

    public String getSaying() {
        return saying;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}

