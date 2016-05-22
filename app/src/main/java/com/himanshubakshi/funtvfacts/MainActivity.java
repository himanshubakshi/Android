package com.himanshubakshi.funtvfacts;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main Activity for the App.
 * Loads the main layout which has the recycler view for showing the TV Shows
 */
public class MainActivity extends AppCompatActivity {

    public final static String TV_SHOW_NAME = "tv_show_name";

    private List<TVShow> showList = new ArrayList<>();
    public static Map<Integer, List<CharSequence>> MyFunFactsDictionary;

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

        prepartTvShowData();
    }

    /**
     * Prepares the data which would be rendered in the App
     * showList is used in the Main Activity to see the list of TV Shows
     * MyFunFactsDictionary is used by the detail activity to show the fun facts for a Show
     */
    private void prepartTvShowData() {
        showList.add(new TVShow(R.string.tvshow_name_friends, R.drawable.high_tvshow_friends_card_background));
        showList.add(new TVShow(R.string.tvshow_name_himym, R.drawable.high_tvshow_himym_card_background));
        showList.add(new TVShow(R.string.tvshow_name_got, R.drawable.high_tvshow_got_card_background));
        showList.add(new TVShow(R.string.tvshow_name_2_and_a_half_men, R.drawable.high_tvshow_2andahalfmen_card_background));
        showList.add(new TVShow(R.string.tvshow_name_tbbt, R.drawable.high_tvshow_the_big_bang_theory_background));

        mAdapter.notifyDataSetChanged();

        List<CharSequence> friendsFactsList = new ArrayList<>();
        friendsFactsList.add(getText(R.string.tvshow_friends_fun_fact_1));
        friendsFactsList.add(getText(R.string.tvshow_friends_fun_fact_2));
        friendsFactsList.add(getText(R.string.tvshow_friends_fun_fact_3));
        friendsFactsList.add(getText(R.string.tvshow_friends_fun_fact_4));
        friendsFactsList.add(getText(R.string.tvshow_friends_fun_fact_5));


        List<CharSequence> himymFactsList = new ArrayList<>();
        himymFactsList.add(getText(R.string.tvshow_himym_fun_fact_1));
        himymFactsList.add(getText(R.string.tvshow_himym_fun_fact_2));
        himymFactsList.add(getText(R.string.tvshow_himym_fun_fact_3));
        himymFactsList.add(getText(R.string.tvshow_himym_fun_fact_4));
        himymFactsList.add(getText(R.string.tvshow_himym_fun_fact_5));

        List<CharSequence> gotFactsList = new ArrayList<>();
        gotFactsList.add(getText(R.string.tvshow_got_fun_fact_1));
        gotFactsList.add(getText(R.string.tvshow_got_fun_fact_2));
        gotFactsList.add(getText(R.string.tvshow_got_fun_fact_3));
        gotFactsList.add(getText(R.string.tvshow_got_fun_fact_4));
        gotFactsList.add(getText(R.string.tvshow_got_fun_fact_5));

        List<CharSequence> twoAndAHalfMenFactsList = new ArrayList<>();
        twoAndAHalfMenFactsList.add(getText(R.string.tvshow_2andahalf_fun_fact_1));
        twoAndAHalfMenFactsList.add(getText(R.string.tvshow_2andahalf_fun_fact_2));
        twoAndAHalfMenFactsList.add(getText(R.string.tvshow_2andahalf_fun_fact_3));
        twoAndAHalfMenFactsList.add(getText(R.string.tvshow_2andahalf_fun_fact_4));
        twoAndAHalfMenFactsList.add(getText(R.string.tvshow_2andahalf_fun_fact_5));

        List<CharSequence> tbbtFactsList = new ArrayList<>();
        tbbtFactsList.add(getText(R.string.tvshow_tbbt_fun_fact_1));
        tbbtFactsList.add(getText(R.string.tvshow_tbbt_fun_fact_2));
        tbbtFactsList.add(getText(R.string.tvshow_tbbt_fun_fact_3));
        tbbtFactsList.add(getText(R.string.tvshow_tbbt_fun_fact_4));
        tbbtFactsList.add(getText(R.string.tvshow_tbbt_fun_fact_5));


        MyFunFactsDictionary = new HashMap<Integer, List<CharSequence>>();
        MyFunFactsDictionary.put(R.string.tvshow_name_friends, friendsFactsList);
        MyFunFactsDictionary.put(R.string.tvshow_name_himym, himymFactsList);
        MyFunFactsDictionary.put(R.string.tvshow_name_2_and_a_half_men, twoAndAHalfMenFactsList);
        MyFunFactsDictionary.put(R.string.tvshow_name_got, gotFactsList);
        MyFunFactsDictionary.put(R.string.tvshow_name_tbbt, tbbtFactsList);
    }
}
