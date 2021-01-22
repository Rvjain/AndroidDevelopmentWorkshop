package com.metrohacks.metrohackexample.contactsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.metrohacks.metrohackexample.R;

public class ContactsMainActivity extends AppCompatActivity {

    EditText etName;
    Button btnAddDetails;

    LinearLayout llDetails;
    TextView tvName;
    TextView tvPhone;
    TextView tvAddress;
    ImageView btnShare;

    final int ADD_CONTACT_DETAILS_REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_main);

        etName = (EditText) findViewById(R.id.et_name);
        btnAddDetails = (Button) findViewById(R.id.btn_addDetails);

        llDetails = (LinearLayout) findViewById(R.id.ll_contactItem);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvPhone = (TextView) findViewById(R.id.tv_phone);
        tvAddress = (TextView) findViewById(R.id.tv_address);
        btnShare = (ImageView) findViewById(R.id.iv_share);
    }

    // TODO Step 10: Start the `AddDetailsActivity` and pass the name in extras.
    public void addDetails(View view) {
        String name = etName.getText().toString().trim();
        if (name.isEmpty()) {
            Toast.makeText(ContactsMainActivity.this, "Give a name for contact", Toast.LENGTH_SHORT).show();
            etName.requestFocus();
            return;
        }

        Intent intent = new Intent(ContactsMainActivity.this, AddDetailsActivity.class);
        intent.putExtra("Name_Extra", name);
        startActivityForResult(intent, ADD_CONTACT_DETAILS_REQUEST_CODE);
    }

    // TODO Step 14: Clicking on the phone number should open the dialer with the number
    public void openDialer(View view) {
        String number = tvPhone.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
        startActivity(intent);
    }

    // TODO Step 15: Clicking on the location should open the map with the address
    public void openMap(View view) {
        String address = tvAddress.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + address));
        startActivity(intent);
    }

    // TODO Step 16: Clicking on the share button show open a chooser dialog and pass the name, phone number and address to which ever share method is used.
    // After this step run the app.
    public void openSharing(View view) {
        String nameWithPhoneAndAddress = String.format("Name: %s, Phone: %s, Address: %s",
                tvName.getText().toString(), tvPhone.getText().toString(), tvAddress.getText().toString());
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, nameWithPhoneAndAddress);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }



    // TODO Step 13: Add `onActivityResult` to collect the result from the `AddDetailsActivity`
    // After this step run the app
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_CONTACT_DETAILS_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                String name = data.getStringExtra("Name_Extra");
                String phone = data.getStringExtra("Phone_Extra");
                String address = data.getStringExtra("Address_Extra");

                toggleContactVisibility();
                tvName.setText(name);
                tvPhone.setText(phone);
                tvAddress.setText(address);
            }
        }
    }

    private void toggleContactVisibility() {
        if (llDetails.getVisibility() == View.GONE) {
            llDetails.setVisibility(View.VISIBLE);
        } else {
            llDetails.setVisibility(View.GONE);
        }
    }
}