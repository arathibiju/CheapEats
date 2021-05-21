package com.example.cheapeatsuoa.Model;

public class Store {
    private int index;
    private String listImageFilename, storeName;

    public String getListImageFilename() {
        return listImageFilename;
    }

    public String getStoreName() {
        return storeName;
    }

    public Store(int index, String listImageFilename, String storeName) {
        this.index = index;
        this.listImageFilename = listImageFilename;
        this.storeName = storeName;
    }

}
