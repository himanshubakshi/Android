package com.himanshubakshi.funtvfacts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.List;

/**
 * Detail Activity where the view pager is hosted
 * The fun facts for TV Shows will be displayed here
 */
public class DetailActivity extends AppCompatActivity {

    private static String LOG_TAG = DetailActivity.class.getName();
    private static int NUM_ITEMS;

    private static int currentShowId;

    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        overridePendingTransition(R.anim.in_right,0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        currentShowId = getIntent().getExtras().getInt(MainActivity.TV_SHOW_NAME);
        setTitle(getString(currentShowId));

        CustomViewPager viewPager = (CustomViewPager) findViewById(R.id.detail_view_pager);
        viewPager.setOnSwipeOutListener(new MySwipeOutListener());

        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);

        NUM_ITEMS = MainActivity.MyFunFactsDictionary.get(currentShowId).size();
        adapterViewPager.notifyDataSetChanged();

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
                CharSequence content = getFunFactText(currentShowId, position);
                CharSequence index = getFactIndexText(currentShowId, position);

                return ShowDetailFragment.newInstance(index, content);
            }
            return null;
        }

        private CharSequence getFunFactText(int showId, int position) {
            List<CharSequence> showFacts = MainActivity.MyFunFactsDictionary.get(showId);
            if (showFacts != null) {
                return showFacts.get(position);
            }
            return "";
        }

        private String getFactIndexText(int showId, int position) {
            return (position + 1) + "/" + NUM_ITEMS;
        }
    }

    public interface OnSwipeOutListener {
        void onSwipeOutAtStart();

        void onSwipeOutAtEnd();
    }

    public class MySwipeOutListener implements OnSwipeOutListener {
        public void onSwipeOutAtStart() {
            finish();
            overridePendingTransition(0,R.anim.out_right);
        }

        public void onSwipeOutAtEnd() {

        }
    }
}
