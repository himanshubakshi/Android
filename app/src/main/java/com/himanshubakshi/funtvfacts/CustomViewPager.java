package com.himanshubakshi.funtvfacts;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by hbakshi on 5/22/16.
 *
 * Custom View Pager that can intercept swipe events
 * at at the beginning and at the end of the views
 */
public class CustomViewPager extends ViewPager {

    float mStartDragX;
    OnSwipeOutListener mListener;

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public void setOnSwipeOutListener(OnSwipeOutListener listener) {
        mListener = listener;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        float x = ev.getX();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartDragX = x;
                break;
            case MotionEvent.ACTION_MOVE:
                float xdiff = x - mStartDragX;
                if (mStartDragX < x && getCurrentItem() == 0 && xdiff > 50.0) {
                    mListener.onSwipeOutAtStart();
                } else if (mStartDragX > x && getCurrentItem() == getAdapter().getCount() - 1) {
                    mListener.onSwipeOutAtEnd();
                }
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}