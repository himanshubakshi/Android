package com.himanshubakshi.funtvfacts;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Main Activity for the App.
 * Loads the main layout which has the recycler view for showing the TV Shows
 */
public class MainActivity extends AppCompatActivity {

    public final static String TV_SHOW_NAME = "tv_show_name";
    private List<TVShow> showList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private TVShowAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }

        mAdapter = new TVShowAdapter(showList);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        prepareTvShowData();
    }

    /**
     * Prepares the data which would be rendered in the App
     * showList is used in the RecyclerView adapter to see the list of TV Shows
     */
    private void prepareTvShowData() {
        showList.add(new TVShow(R.string.tvshow_name_friends, R.drawable.high_tvshow_friends_card_background));
        showList.add(new TVShow(R.string.tvshow_name_himym, R.drawable.high_tvshow_himym_card_background));
        showList.add(new TVShow(R.string.tvshow_name_got, R.drawable.high_tvshow_got_card_background));
        showList.add(new TVShow(R.string.tvshow_name_2_and_a_half_men, R.drawable.high_tvshow_2andahalfmen_card_background));
        showList.add(new TVShow(R.string.tvshow_name_tbbt, R.drawable.high_tvshow_the_big_bang_theory_background));

        mAdapter.notifyDataSetChanged();
    }
}
