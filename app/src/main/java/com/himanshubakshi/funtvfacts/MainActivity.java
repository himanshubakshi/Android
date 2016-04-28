package com.himanshubakshi.funtvfacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public final static String TV_SHOW_ID = "tv_show_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void tvshow_card_click(View view){
        Intent intent = new Intent(this, FunFactDetailActivity.class);
        intent.putExtra(TV_SHOW_ID, view.getId());
        startActivity(intent);
    }
}
