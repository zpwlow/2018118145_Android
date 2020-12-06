package com.example.stickynotes.model;

public class NoteBook {
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
