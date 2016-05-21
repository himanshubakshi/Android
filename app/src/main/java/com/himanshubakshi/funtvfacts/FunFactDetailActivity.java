package com.himanshubakshi.funtvfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

/**
 * The Detail Activity Class that is used to render the detail view for any TV Show.
 * This is the single activity used for all the TV Shows.
 */
public class FunFactDetailActivity extends AppCompatActivity {

    int currentIndex = 0;
    int currentShowId = -1;
    TextView myFunFactDetailTextView;
    TextView myFunFactIndexTextView;


    private CharSequence getContent(int showId) {
        List<CharSequence> showFacts = MainActivity.MyFunFactsDictionary.get(showId);
        if (showFacts != null) {

            // Validate the index value
            if (currentIndex <= 0) {
                currentIndex = 0;
                findViewById(R.id.funFactPrevButton).setVisibility(View.GONE);
            } else if (currentIndex == showFacts.size() - 1) {
                findViewById(R.id.funFactNextButton).setVisibility(View.GONE);
            } else if (currentIndex == showFacts.size()) {
                currentIndex = showFacts.size() - 1;
            } else {
                // TODO: could use some optimization
                findViewById(R.id.funFactNextButton).setVisibility(View.VISIBLE);
                findViewById(R.id.funFactPrevButton).setVisibility(View.VISIBLE);
            }

            return showFacts.get(currentIndex);
        }
        return "";
    }

    private String getIndexText(int showId) {

        int listSize = MainActivity.MyFunFactsDictionary.get(showId).size();
        return (currentIndex + 1) + "/" + listSize;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentShowId = getIntent().getExtras().getInt(MainActivity.TV_SHOW_NAME);

        currentIndex = 0;
        setContentView(R.layout.activity_fun_fact_detail);

        // set the correct index and the fact text

        myFunFactDetailTextView = (TextView) findViewById(R.id.fun_fact_detail_text_view);
        myFunFactIndexTextView = (TextView) findViewById(R.id.fun_fact_index_text_view);

        // Not sure if the condition is valid
        if (currentShowId > 0) {
            myFunFactDetailTextView.setText(getContent(currentShowId));
            myFunFactIndexTextView.setText(getIndexText(currentShowId));
        }

        // Click listener for the next button
        findViewById(R.id.funFactNextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++currentIndex;
                myFunFactDetailTextView.setText(getContent(currentShowId));
                myFunFactIndexTextView.setText(getIndexText(currentShowId));
                resetScroll();
            }
        });

        // Click listener for the next button
        findViewById(R.id.funFactPrevButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                --currentIndex;
                myFunFactDetailTextView.setText(getContent(currentShowId));
                myFunFactIndexTextView.setText(getIndexText(currentShowId));
                resetScroll();
            }
        });
    }

    private void resetScroll() {
        ((ScrollView) findViewById(R.id.detail_scroll_view)).setScrollY(0);
    }
}
