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
import com.metrohacks.metrohackexample.serviceapp.ServiceMainActivity;

public class MainActivity extends AppCompatActivity {

    final String TAG = "MainActivity";

    Button btnContactApp;
    Button btnServiceApp;

    // This is the function where we should create views, bind data, initialize variables.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnContactApp = (Button) findViewById(R.id.contactapp);
        btnServiceApp = (Button) findViewById(R.id.serviceapp);

        // TODO Step 1: Log when the onCreate() lifecycle method is called
        // Log.d(TAG, TAG + " : onCreate is called");
    }

    // TODO Step 2: Log when the onRestart() lifecycle method is called
    // To uncomment multiple lines together select all the lines which needs to be uncommented
    // For mac OS: click command + /
    // For windows OS: click control + shift + /

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.d(TAG, TAG + " : onRestart is called");
//    }

    // TODO Step 3: Log when the onStart() lifecycle method is called
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d(TAG, TAG + " : onStart is called");
//    }

    // TODO Step 4: Log when the onResume() lifecycle method is called
    // Called if the activity get visible again and the user starts interacting with the activity again.
    // Used to initialize fields, register listeners, bind to services, etc.
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d(TAG, TAG + " : onResume is called");
//    }

    // TODO Step 5: Log when the onPause() lifecycle method is called
    // Called once another activity gets into the foreground. Always called before the activity is not visible anymore.
    // Used to release resources or save application data.
    // For example you unregister listeners, intent receivers, unbind from services or remove system service listeners.
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d(TAG, TAG + " : onPause is called");
//    }

    // TODO Step 6: Log when the onStop() lifecycle method is called
    // Called once the activity is no longer visible.
    // Time or CPU intensive shut-down operations, such as writing information to a database should be down in the onStop() method.
    // This method is guaranteed to be called as of API 11.
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d(TAG, TAG + " : onStop is called");
//    }

    // TODO Step 7: Log when the onDestroy() lifecycle method is called
    // After this step run the app.
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d(TAG, TAG + " : onDestroy is called");
//    }

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

    // TODO Step 8: On `Contact App` button click start the new activity using explicit intent
    public void startContactApp(View view) {
//        Intent contactIntent = new Intent(MainActivity.this, ContactsMainActivity.class);
//        startActivity(contactIntent);
    }

    // TODO Step 9: On `Service App` button click start the new activity using explicit intent
    // After this step run the app
    public void startServiceApp(View view) {
//        Intent contactIntent = new Intent(MainActivity.this, ServiceMainActivity.class);
//        startActivity(contactIntent);
    }

    public void styleApp(View view) {
        btnContactApp.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
        btnServiceApp.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
    }
}