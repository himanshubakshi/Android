package com.himanshubakshi.funtvfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FunFactDetailActivity extends AppCompatActivity {

    int currentIndex = 0;

    private String getContent(int id, int index) {

        String funFact = "";

        switch (id) {
            case R.id.tvshow_friends_card:
                // get the first fact for the friends tv show

                funFact = getResources().getString(R.string.tvshow_friends_fun_fact_1);
                break;
            case R.id.tvshow_2_and_a_half_men_card:

                funFact = getResources().getString(R.string.tvshow_2andahalf_fun_fact_1);

                break;
            case R.id.tvshow_got_card:
                funFact = getResources().getString(R.string.tvshow_got_fun_fact_1);

                break;
            case R.id.tvshow_himym_card:
                funFact = getResources().getString(R.string.tvshow_himym_fun_fact_1);

                break;
        }
        return funFact;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int tvShowCardId = getIntent().getExtras().getInt(MainActivity.TV_SHOW_ID);

        currentIndex = 0;
        setContentView(R.layout.activity_fun_fact_detail);

        // set the correct index and the fact text

        // Not sure if the condition is valid
        if (tvShowCardId > 0) {
            ((TextView) findViewById(R.id.fun_fact_detail_text_view)).setText(getContent(tvShowCardId, currentIndex));
        }
    }
}
