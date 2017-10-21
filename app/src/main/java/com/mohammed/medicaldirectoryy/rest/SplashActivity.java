package com.mohammed.medicaldirectoryy.rest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mohammed.medicaldirectoryy.Home;

/**
 * Created by mohammed on 5/6/17.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        finish();
    }
}
