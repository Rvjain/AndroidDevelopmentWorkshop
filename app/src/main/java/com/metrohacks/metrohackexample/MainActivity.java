package com.metrohacks.metrohackexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.metrohacks.metrohackexample.contactsapp.ContactsMainActivity;
import com.metrohacks.metrohackexample.receiverapp.ReceiverMainActivity;
import com.metrohacks.metrohackexample.serviceapp.ServiceMainActivity;

public class MainActivity extends AppCompatActivity {

    final String TAG = "MainActivity";

    Button btnContactApp;
    Button btnServiceApp;
    Button btnReceiverApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, TAG + " : onCreate is called");

        setContentView(R.layout.activity_main);

        btnContactApp = (Button) findViewById(R.id.contactapp);
        btnServiceApp = (Button) findViewById(R.id.serviceapp);
        btnReceiverApp = (Button) findViewById(R.id.receiverapp);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, TAG + " : onRestart is called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, TAG + " : onStart is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, TAG + " : onResume is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, TAG + " : onPause is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, TAG + " : onStop is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, TAG + " : onDestroy is called");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_meu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if (item.getItemId() == R.id.share) {
            startShareDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startShareDialog() {
        String text = "Best app ever !!!";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }

    public void startContactApp(View view) {
        Intent contactIntent = new Intent(MainActivity.this, ContactsMainActivity.class);
        startActivity(contactIntent);
    }

    public void startServiceApp(View view) {
        Intent contactIntent = new Intent(MainActivity.this, ServiceMainActivity.class);
        startActivity(contactIntent);
    }

    public void startReceiverApp(View view) {
        Intent contactIntent = new Intent(MainActivity.this, ReceiverMainActivity.class);
        startActivity(contactIntent);
    }

    public void styleApp(View view) {
        btnContactApp.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
        btnServiceApp.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
        btnReceiverApp.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
    }
}