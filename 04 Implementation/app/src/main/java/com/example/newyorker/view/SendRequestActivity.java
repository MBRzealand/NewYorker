package com.example.newyorker.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.newyorker.R;
import com.example.newyorker.controller.NYBuilderController;
import com.example.newyorker.model.Email;
import com.sendgrid.Attachments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendRequestActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;
    NYBuilderController controller;
    Email email = new Email();
    EditText customerName;
    EditText customerPhoneNumber;
    EditText customerEmailAddress;
    EditText customerAddress;
    EditText customerZIPCode;
    EditText notes;
    private final List<Uri> uris = new ArrayList<>();
    private final List<File> attachments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__send__request);

        Intent intent = getIntent();
        controller = (NYBuilderController) intent.getSerializableExtra("controller");
        initializeUIElements();
        // initializeListeners();

    }



    public void sendRequest(View view) throws IOException {
        controller.setCustomerName(customerName.getText().toString());
        controller.setCustomerZIPCode(customerZIPCode.getText().toString());
        controller.setCustomerEmailAddress(customerEmailAddress.getText().toString());
        controller.setCustomerPhoneNumber(customerPhoneNumber.getText().toString());
        controller.setCustomerAddress(customerAddress.getText().toString());
        controller.setCustomerNotes(notes.getText().toString());



       // Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        //intent.setType("*/*");
        //startActivityForResult(intent, REQUEST_CODE);




        email.sendEmail(controller.getCustomer(), controller.getWall(0), uris, getApplicationContext() );
    }

   /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            uris.add(data.getData());
        }
    }
  */

    private void initializeUIElements() {
       customerName = findViewById(R.id.editText_name);
       customerAddress = findViewById(R.id.editText_address);
       customerEmailAddress = findViewById(R.id.editText_email_address);
       customerPhoneNumber = findViewById(R.id.editText_phone_number);
       customerZIPCode = findViewById(R.id.editText_zip_code);
       notes = findViewById(R.id.editText_notes);
    }



}