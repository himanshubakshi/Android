package com.himanshubakshi.funtvfacts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Detail Activity where the view pager is hosted
 * The fun facts for TV Shows will be displayed here
 */
public class DetailActivity extends AppCompatActivity {

    private static String LOG_TAG = DetailActivity.class.getName();
    private static int NUM_ITEMS;

    private static CharSequence[] mShowDetailArray;

    FragmentPagerAdapter mAdapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        overridePendingTransition(R.anim.in_right,0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int mCurrentShowId = getIntent().getExtras().getInt(MainActivity.TV_SHOW_NAME);
        setTitle(getString(mCurrentShowId));

        // map mCurrentShowId to the string array
        int showDetailArrayId = ShowDataHelper.getShowDetailArrayId(mCurrentShowId);
        mShowDetailArray = getResources().getTextArray(showDetailArrayId);

        mAdapterViewPager = new MyPagerAdapter(getSupportFragmentManager());

        CustomViewPager viewPager = (CustomViewPager) findViewById(R.id.detail_view_pager);
        viewPager.setOnSwipeOutListener(new MySwipeOutListener());
        viewPager.setAdapter(mAdapterViewPager);

        NUM_ITEMS = mShowDetailArray.length;
        mAdapterViewPager.notifyDataSetChanged();
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            if (position < NUM_ITEMS) {
                CharSequence content = getFunFactText(position);
                CharSequence index = getFactIndexText(position);

                return ShowDetailFragment.newInstance(index, content);
            }
            return null;
        }

        // Get the text for the show detail
        private CharSequence getFunFactText(int position) {
            if (mShowDetailArray != null) {
                return mShowDetailArray[position];
            }
            return "";
        }

        // Get the current show detail index
        private String getFactIndexText(int position) {
            return (position + 1) + "/" + NUM_ITEMS;
        }
    }

    public interface OnSwipeOutListener {
        void onSwipeOutAtStart();
        void onSwipeOutAtEnd();
    }

    /**
     * This class helps identify a swipe out at the first page, or at the last page
     * of the view pager
     */
    public class MySwipeOutListener implements OnSwipeOutListener {

        public void onSwipeOutAtStart() {
            finish();
            overridePendingTransition(0,R.anim.out_right);
        }

        public void onSwipeOutAtEnd() {

        }
    }
}
