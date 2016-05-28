package com.himanshubakshi.funtvfacts;

/**
 * Created by hbakshi on 5/14/16.
 *
 * Data Model for a TV Show
 *
 * Contains IDs for the show names and the background images for the shows
 */
public class TVShow {

    public TVShow(int showNameId, int showImageId) {
        this.mShowNameId = showNameId;
        this.mShowImageId = showImageId;
    }

    private int mShowNameId;
    public int getmShowNameId() {
        return mShowNameId;
    }

    private int mShowImageId;
    public int getmShowImageId() {
        return mShowImageId;
    }
}


