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


