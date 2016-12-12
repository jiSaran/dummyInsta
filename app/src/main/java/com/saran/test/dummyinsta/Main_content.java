package com.saran.test.dummyinsta;

/**
 * Created by core I5 on 11/25/2016.
 */

public class Main_content {
    private Integer main_feed_img;
    private Integer bottom_feed_img;

    public Main_content() {
    }

    public Main_content(int mfeedimg, int bfeedimg) {
        this.main_feed_img = mfeedimg;
        this.bottom_feed_img = bfeedimg;
    }

    public Integer getMain_feed_img(){
        return this.main_feed_img;
    }

    public Integer getBottom_feed_img() {
        return this.bottom_feed_img;
    }
}
