package com.mazharali.sofittask.model;

public class ImageTextModel {
    private String imageLink;
    private String imageDetail;

    public ImageTextModel(String imageLink, String imageDetail) {
        this.imageLink = imageLink;
        this.imageDetail = imageDetail;
    }

    public String getImageDetail() {
        return imageDetail;
    }
    public String getImageLink(){
        return imageLink;
    }
}
