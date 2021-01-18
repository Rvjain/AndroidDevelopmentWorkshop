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

    // Before this step run the app to check the code without thread
    // TODO Step 17: Update the code to run the code without causing any lags on the UI.
    public void changeText(View view) {
        codeWithoutThread();
        //codeWithThread();
    }

    // This code increment the count value by 1 and updates the counter `tvCount` TextView
    public void incrementCounter(View view) {
        count++;
        tvCount.setText("Count : " + count);
    }

    // This code run waits for 6 seconds before updating the textview `tvHello` to "Hi Folks!"
    private void codeWithoutThread() {
        longWaitingOperation();
        tvHello.setText("Hi Folks!");
    }

    private void codeWithThread() {
        // A Handler allows you to send and process {@link Message} and Runnable
        // * objects associated with a thread's {@link MessageQueue}.
        final Handler handler = new Handler();

        // TODO Step 18: Create Runnable object for a new thread and perform the
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                longWaitingOperation();
//
//                // TODO Step 20: Using Handler to update the after the long running operation
////                handler.post(new Runnable() {
////                    @Override
////                    public void run() {
////                        tvHello.setText("Hi Folks!");
////                    }
////                });
//            }
//        };

        // TODO Step 19: Start the thread with the newly created runnable
        // After this step run the app
//        Thread thread = new Thread(r);
//        thread.start();
    }

    private void longWaitingOperation() {
        long futureTime = System.currentTimeMillis() + 6000;
        while(System.currentTimeMillis() < futureTime) {
            synchronized (this) {
                // Do nothing
            }
        }
    }
}