package com.example.newyorker.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.newyorker.R;
import com.example.newyorker.controller.NYBuilderController;

public class SendRequestActivity extends AppCompatActivity {

    NYBuilderController controller;
    Email email = new Email();
    EditText customerName;
    EditText customerPhoneNumber;
    EditText customerEmailAddress;
    EditText customerAddress;
    EditText customerZIPCode;
    EditText notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__send__request);

        Intent intent = getIntent();
        controller = (NYBuilderController) intent.getSerializableExtra("controller");
        initializeUIElements();
    }



    public void sendRequest(View view) throws Exception {
        controller.setCustomerName(customerName.getText().toString());
        controller.setCustomerZIPCode(customerZIPCode.getText().toString());
        controller.setCustomerEmailAddress(customerEmailAddress.getText().toString());
        controller.setCustomerPhoneNumber(customerPhoneNumber.getText().toString());
        controller.setCustomerAddress(customerAddress.getText().toString());
        controller.setCustomerNotes(notes.getText().toString());
        
        email.sendEmail("hjordrup96@live.dk", controller.getCustomer(), controller.getWall(0));

    }


    private void initializeUIElements() {
       customerName = findViewById(R.id.editText_name);
       customerAddress = findViewById(R.id.editText_address);
       customerEmailAddress = findViewById(R.id.editText_email_address);
       customerPhoneNumber = findViewById(R.id.editText_phone_number);
       customerZIPCode = findViewById(R.id.editText_zip_code);
       notes = findViewById(R.id.editText_notes);
    }

}