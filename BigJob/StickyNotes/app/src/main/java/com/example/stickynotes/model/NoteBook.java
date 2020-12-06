package com.example.stickynotes.model;

import org.litepal.crud.DataSupport;

public class NoteBook extends DataSupport {
    private  int id;
    private String bookname;  //便签书名

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotename() {
        return bookname;
    }

    public void setNotename(String bookname) {
        this.bookname = bookname;
    }
}
