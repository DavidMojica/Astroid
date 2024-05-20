package com.dmv.astroid;

public class PlanetOnList {
    private String name, ENGName;
    private int imgId;

    public PlanetOnList(String name, int imgId, String ENGName) {
        this.name = name;
        this.imgId = imgId;
        this.ENGName = ENGName;
    }

    public String getName() {
        return name;
    }
    public String getENGName() { return ENGName; };
    public int getImgId() {
        return imgId;
    }
}