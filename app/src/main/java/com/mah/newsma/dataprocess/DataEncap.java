package com.mah.newsma.dataprocess;

/**
 * Created by Mah on 1/25/2017.
 */

public class DataEncap {
    private String url;
    private String img;
    private String disc;
    private String title;

    public DataEncap(String url,  String img, String disc, String title) {
        this.url = url;
        this.img = img;
        this.disc = disc;
        this.title = title;
    }

    public DataEncap() {

    }

    public String getUrl() {
        return url;
    }

    public String getImg() {
        return img;
    }

    public String getDisc() {
        return disc;
    }

    public String getTitle() {
        return title;
    }
}
