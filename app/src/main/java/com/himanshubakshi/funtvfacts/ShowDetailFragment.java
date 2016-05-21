package com.himanshubakshi.funtvfacts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * The fragment to show the fun fact details
 * Each fun fact will be rendered in it's own fragment, based on the view pager's index
 */
public class ShowDetailFragment extends Fragment {

    private CharSequence mIndexText;
    private CharSequence mFunFactText;

    private static final String TVSHOW_INDEX = "TVSHOW_INDEX";
    private static final String TVSHOW_FUNFACT = "TVSHOW_FUNFACT";

    // newInstance constructor for creating fragment with arguments
    public static ShowDetailFragment newInstance(CharSequence indexText, CharSequence funFactText) {
        ShowDetailFragment showDetailFragment = new ShowDetailFragment();
        Bundle args = new Bundle();
        args.putCharSequence(TVSHOW_INDEX, indexText);
        args.putCharSequence(TVSHOW_FUNFACT, funFactText);
        showDetailFragment.setArguments(args);
        return showDetailFragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIndexText = getArguments().getCharSequence(TVSHOW_INDEX);
        mFunFactText = getArguments().getCharSequence(TVSHOW_FUNFACT);
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tvshow_detail, container, false);

        TextView indexTextView = (TextView) view.findViewById(R.id.fun_fact_index_text_view);
        indexTextView.setText(mIndexText);

        TextView funFactTextView = (TextView) view.findViewById(R.id.fun_fact_detail_text_view);
        funFactTextView.setText(mFunFactText);

        return view;
    }
}
