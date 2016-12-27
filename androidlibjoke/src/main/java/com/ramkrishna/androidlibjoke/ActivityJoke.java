package com.ramkrishna.androidlibjoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityJoke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Intent intent = getIntent();
        String joke = intent.getStringExtra(AppConstants.JOKE_INTENT_EXTRA);
        TextView jokeTextView = (TextView) findViewById(R.id.jokeText);
        jokeTextView.setText(joke);
    }
}
