package com.example.stickynotes.model;

import org.litepal.crud.DataSupport;

public class Note extends DataSupport {
    private int id;
    private  String content;  //内容
    private  String notename; //便签名

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNotename() {
        return notename;
    }

    public void setNotename(String notename) {
        this.notename = notename;
    }
}
