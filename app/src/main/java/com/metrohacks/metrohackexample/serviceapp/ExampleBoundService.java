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

    private final IBinder serviceBinder = new LocalBinder();

    public ExampleBoundService() {}

    public String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return (df.format(new Date()));
    }

    @Override
    public IBinder onBind(Intent intent) {
        return serviceBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy is called");
    }

    class LocalBinder extends Binder {
        ExampleBoundService getService() {
            return ExampleBoundService.this;
        }
    }
 }
