package com.example.stickynotes.model.GSON;

public class One {

    /*
    返回的json数据
    */
    private  int id;
    private  String hitokoto;  //消息
    private  String from ;   //来自

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHitokoto() {
        return hitokoto;
    }

    public void setHitokoto(String hitokoto) {
        this.hitokoto = hitokoto;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
