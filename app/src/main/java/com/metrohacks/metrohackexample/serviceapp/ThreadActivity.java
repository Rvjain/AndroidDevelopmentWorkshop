package com.metrohacks.metrohackexample.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.metrohacks.metrohackexample.R;

public class ThreadActivity extends AppCompatActivity {

    TextView tvHello;
    TextView tvCount;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_thread);

        tvHello = (TextView) findViewById(R.id.tv_serviceText);
        tvCount = (TextView) findViewById(R.id.tv_count);
    }

    public void changeText(View view) {
        wrongCode();
        //codeWithThread();
    }

    public void incrementCounter(View view) {
        count++;
        tvCount.setText("Count : " + count);
    }

    private void wrongCode() {
        long futureTime = System.currentTimeMillis() + 6000;
        while(System.currentTimeMillis() < futureTime) {
            synchronized (this) {
                // Do nothing
            }
        }
        tvHello.setText("Hi Folks!");
    }

    private void codeWithThread() {
        final Handler handler = new Handler();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                long futureTime = System.currentTimeMillis() + 6000;
                while(System.currentTimeMillis() < futureTime) {
                    synchronized (this) {
                        // Do nothing
                    }
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvHello.setText("Hi Folks!");
                    }
                });
            }
        };

        Thread thread = new Thread(r);
        thread.start();
    }
}