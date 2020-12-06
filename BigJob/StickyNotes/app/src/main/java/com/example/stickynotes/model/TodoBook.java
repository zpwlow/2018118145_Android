package com.example.stickynotes.model;

import org.litepal.crud.DataSupport;

public class TodoBook extends DataSupport {
    private int id;
    private String todoname; //待办书名

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodoname() {
        return todoname;
    }

    public void setTodoname(String todoname) {
        this.todoname = todoname;
    }
}