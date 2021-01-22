package com.metrohacks.metrohackexample.serviceapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ExampleBoundService extends Service {
    final String TAG = "ExampleIntentService";

    // TODO Step 26: Create the implementation of IBinder using the LocalBinder
    private final IBinder serviceBinder = new LocalBinder();

    public ExampleBoundService() {}

    public String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return (df.format(new Date()));
    }

    // TODO Step 27: Bind the activity with the service by returning the IBinder implementation
    @Override
    public IBinder onBind(Intent intent) {
        //return null;
        return serviceBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy is called");
    }

    // TODO Step 25: Create the binder class to return the service
    class LocalBinder extends Binder {
        ExampleBoundService getService() {
            return ExampleBoundService.this;
        }
    }
 }
