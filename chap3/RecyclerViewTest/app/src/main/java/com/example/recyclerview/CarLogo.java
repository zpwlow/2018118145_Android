package com.example.recyclerview;

public class CarLogo {
    private String name;
    private  int imageId;

    public CarLogo(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
