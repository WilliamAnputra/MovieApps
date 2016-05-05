package com.example.williamanputra.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.williamanputra.movieapp.PopularMoviePOJO.Result;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent getIntent= getIntent();

        Result result= getIntent.getParcelableExtra("DATA");

        Log.i("getINTENT", result.getOriginalTitle());


    }
}
