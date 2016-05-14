package com.himanshubakshi.funtvfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public final static String TV_SHOW_NAME = "tv_show_name";

    private List<TvShow> showList = new ArrayList<>();
    public static Map<Integer, List<CharSequence>> MyFunFactsDictionary;


    private RecyclerView recyclerView;
    private TvShowAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new TvShowAdapter(showList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepartTvShowData();
    }

    private void prepartTvShowData() {
        showList.add(new TvShow(R.string.tvshow_name_friends, R.drawable.tvshow_friends_card_background));
        showList.add(new TvShow(R.string.tvshow_name_himym, R.drawable.tvshow_himym_card_background));
        showList.add(new TvShow(R.string.tvshow_name_got, R.drawable.tvshow_got_card_background));
        showList.add(new TvShow(R.string.tvshow_name_2_and_a_half_men, R.drawable.tvshow_2andahalfmen_card_background));
        showList.add(new TvShow(R.string.tvshow_name_tbbt, R.drawable.tvshow_the_big_bang_theory_background));

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
