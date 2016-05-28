package com.himanshubakshi.funtvfacts;

/**
 * Created by hbakshi on 5/28/16.
 */


/**
 * This interface helps identify a swipe out at the first page, or at the last page
 * of the view pager
 */
public interface OnSwipeOutListener {
    void onSwipeOutAtStart();
    void onSwipeOutAtEnd();
}