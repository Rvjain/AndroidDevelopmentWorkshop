package com.metrohacks.metrohackexample.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.metrohacks.metrohackexample.R;

public class AddDetailsActivity extends AppCompatActivity {

    TextView tvName;
    EditText etPhone;
    EditText etAddress;
    Button btnAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        tvName = (TextView) findViewById(R.id.tv_name);
        etPhone = (EditText) findViewById(R.id.et_phone);
        etAddress = (EditText) findViewById(R.id.et_location);
        btnAddress = (Button) findViewById(R.id.btn_createContact);

        displayName();
    }

    // TODO Step 11: Display the name from which this activity received from `ContactMainActivity`
    private void displayName() {
        Intent intent = getIntent();
        if (intent == null) {
            Toast.makeText(AddDetailsActivity.this, "No intent provided to the activity", Toast.LENGTH_SHORT).show();
            return;
        }

        String name = intent.getStringExtra("Name_Extra");
        tvName.setText(name);
    }

    // TODO Step 12: Send the name, phone number and address back to `ContactMainActivity`
    public void createContact(View view) {
        String phone = etPhone.getText().toString();
        String address = etAddress.getText().toString();
        if (phone.isEmpty()) {
            Toast.makeText(AddDetailsActivity.this, "Please provide the phone number", Toast.LENGTH_SHORT).show();
            etPhone.requestFocus();
            return;
        }

        if (address.isEmpty()) {
            Toast.makeText(AddDetailsActivity.this, "Please provide the Address", Toast.LENGTH_SHORT).show();
            etAddress.requestFocus();
            return;
        }

        Intent intent = new Intent();
        intent.putExtra("Name_Extra", tvName.getText().toString());
        intent.putExtra("Phone_Extra", phone);
        intent.putExtra("Address_Extra", address);

        setResult(RESULT_OK, intent);
        finish();
    }
}