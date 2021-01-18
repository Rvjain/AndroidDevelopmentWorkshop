package com.metrohacks.metrohackexample.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.metrohacks.metrohackexample.R;

public class ExampleBoundServiceActivity extends AppCompatActivity {

    private final String TAG = "BoundServiceActivity";

    ExampleBoundService boundService;
    TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service);

        // TODO Step 28: Start the service by using `bindService`
//        Intent intent = new Intent(this, ExampleBoundService.class);
//        bindService(intent, boundServiceConnection, Context.BIND_AUTO_CREATE);
    }

    // TODO Step 27: Create the service connection object
    // This object will be used to understand when the service is connected and when it is disconnected
//    private ServiceConnection boundServiceConnection = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            ExampleBoundService.LocalBinder binder = (ExampleBoundService.LocalBinder) service;
//            boundService = binder.getService();
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            Log.d(TAG, "onServiceDisconnected");
//        }
//    };

    public void getTime(View view) {
        String currentTime = boundService.getCurrentTime();
        tvTime.setText(currentTime);
    }
}