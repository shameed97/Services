package com.example.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void stopService(View view) {

        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    public void startService(View view) {

        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }
}
