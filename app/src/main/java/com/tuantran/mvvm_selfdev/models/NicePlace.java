package com.tuantran.mvvm_selfdev.models;

public class NicePlace {
    private String imageName;
    private String imageUrl;

    public NicePlace(String url, String name) {
        imageUrl=url;
        imageName=name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
