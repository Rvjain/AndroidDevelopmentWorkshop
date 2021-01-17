package com.metrohacks.metrohackexample.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

import com.metrohacks.metrohackexample.R;

public class ExampleBoundServiceActivity extends AppCompatActivity {

    ExampleBoundService boundService;
    boolean isBound = false;

    TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service);
        Intent intent = new Intent(this, ExampleBoundService.class);
        bindService(intent, boundServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection boundServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ExampleBoundService.LocalBinder binder = (ExampleBoundService.LocalBinder) service;
            boundService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    public void getTime(View view) {
        String currentTime = boundService.getCurrentTime();
        tvTime.setText(currentTime);
    }
}