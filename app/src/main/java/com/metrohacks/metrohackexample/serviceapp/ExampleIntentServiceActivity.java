package com.metrohacks.metrohackexample.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.metrohacks.metrohackexample.R;

public class ExampleIntentServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_intent_service);

        // TODO Step 24: Start the foreground service with an intent and provide extra data.
        // After this Run the app and test.
//        Intent intent = new Intent(this, ExampleIntentService.class);
//        intent.putExtra("inputExtra", "Hello Service");
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            startForegroundService(intent);
//        } else {
//            startService(intent);
//        }
    }
}