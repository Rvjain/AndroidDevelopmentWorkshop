package com.metrohacks.metrohackexample.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.metrohacks.metrohackexample.R;

public class ServiceMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_main);
    }

    public void startThreadActivity(View view) {
        Intent intent = new Intent(ServiceMainActivity.this, ThreadActivity.class);
        startActivity(intent);
    }

    public void startIntentServiceActivity(View view) {
        Intent intent = new Intent(ServiceMainActivity.this, ExampleIntentServiceActivity.class);
        startActivity(intent);
    }

    public void startBoundServiceActivity(View view) {
        Intent intent = new Intent(ServiceMainActivity.this, ExampleBoundServiceActivity.class);
        startActivity(intent);
    }
}