package com.example.stickynotes.model;

import android.util.Log;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

public class Dbservice {
    private static final Dbservice ourInstance = new Dbservice();

    public static Dbservice getInstance() {
        return ourInstance;
    }

    private Dbservice() {

        if(DataSupport.count(UserInfo.class)==0){

            Log.i("gong","创建数据库");
            LitePal.getDatabase();


            NoteBook noteBook = new NoteBook();
            noteBook.setNotename("笔记");
            noteBook.save();


            TodoBook todoBook = new TodoBook();
            todoBook.setTodoname("日常");
            todoBook.save();


            Note note3 = new Note();
            note3.setNotename("笔记");
            note3.setContent("待办完成项 点击右上角查看每日Log！");
            note3.setWritetime("2020.5.20");
            note3.save();

            Note note = new Note();
            note.setNotename("笔记");
            note.setContent("修改+删除尝试长按");
            note.setWritetime("2020.5.20");
            note.save();


            Note note1 = new Note();
            note1.setNotename("笔记");
            note1.setContent("长按信息对应项——>修改签名昵称");
            note1.setWritetime("2020.5.20");
            note1.save();


            UserInfo userInfo = new UserInfo();
            userInfo.setSaying("low(@_@)");
            userInfo.setName("Mr. Zhong");
            userInfo.setProfile("1");
            userInfo.save();

        }
        else {
            LitePal.getDatabase();
        }
    }
}

