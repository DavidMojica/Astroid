package com.dmv.astroid;

public class PlanetOnList {
    private String name;
    private int imgId;

    public PlanetOnList(String name, int imgId) {
        this.name = name;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public int getImgId() {
        return imgId;
    }
}
