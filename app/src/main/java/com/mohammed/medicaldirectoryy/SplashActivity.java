package com.mohammed.medicaldirectoryy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mohammed on 5/6/17.
 */

public class SplashActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        finish();
    }
}
