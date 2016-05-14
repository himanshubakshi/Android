package com.himanshubakshi.funtvfacts;

/**
 * Created by hbakshi on 5/14/16.
 */
public class TvShow {

    public TvShow(int showNameId, int showImageId) {
        this.showNameId = showNameId;
        this.showImageId = showImageId;
    }

    private int showNameId;
    public int getShowNameId() {
        return showNameId;
    }

    private int showImageId;
    public int getShowImageId() {
        return showImageId;
    }
}


