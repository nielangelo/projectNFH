package com.example.safe_haven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {

// Using handler with postDelayed called runnable run method

            @Override

            public void run() {

                Intent i = new Intent(splashscreen.this, login.class);
                startActivity(i);

                // close this activity

                finish();

            }

        }, 3*1000); // wait for 5 seconds


    }
}