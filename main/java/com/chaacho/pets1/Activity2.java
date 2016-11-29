package com.chaacho.pets1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Toolbar miapbar = (Toolbar) findViewById(R.id.miApbar);
        setSupportActionBar(miapbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
