package com.example.newyorker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.newyorker.model.Customer;
import com.example.newyorker.model.Email;
import com.example.newyorker.model.Specifications;

public class SendRequestActivity extends AppCompatActivity {

    Specifications specifications;
    Customer customer;
    Email email = new Email();
    EditText customerName;
    EditText customerPhoneNumber;
    EditText customerEmailAddress;
    EditText customerAddress;
    EditText customerZIPCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__send__request);
        Intent intent = getIntent();
        specifications = (Specifications) intent.getSerializableExtra("Specifications");
        customer = new Customer();
        initializeUIElements();
        // initializeListeners();




    }



    public void sendRequest(View view) {
        customer.setCustomerName(customerName.getText().toString());
        customer.setCustomerZIPCode(customerZIPCode.getText().toString());
        customer.setCustomerEmailAddress(customerEmailAddress.getText().toString());
        customer.setCustomerPhoneNumber(customerPhoneNumber.getText().toString());
        customer.setCustomerAddress(customerAddress.getText().toString());



        startActivity(email.sendEmail("hjordrup96@live.dk", customer, specifications.getWall()));

    }


    private void initializeUIElements() {
       customerName = findViewById(R.id.editText_name);
       customerAddress = findViewById(R.id.editText_address);
       customerEmailAddress = findViewById(R.id.editText_email_address);
       customerPhoneNumber = findViewById(R.id.editText_phone_number);
       customerZIPCode = findViewById(R.id.editText_zip_code);
    }
    /*private void initializeListeners() {

        customerName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean hasFocus) {
                if (customerName.getText() != null) {
                    if (!hasFocus) {
                        customer.setCustomerName(customerName.getText().toString());
                    }
                }
            }
        });
        customerPhoneNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean hasFocus) {
                if (customerPhoneNumber.getText() != null) {
                    if (!hasFocus) {
                       customer.setCustomerPhoneNumber(customerPhoneNumber.getText().toString());
                    }
                }
            }
        });
        customerZIPCode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean hasFocus) {
                if (customerZIPCode.getText() != null) {
                    if (!hasFocus) {
                        customer.setCustomerZIPCode(customerZIPCode.getText().toString());
                    }
                }
            }
        });
        customerEmailAddress.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean hasFocus) {
                if (customerEmailAddress.getText() != null) {
                    if (!hasFocus) {
                        customer.setCustomerEmailAddress(customerEmailAddress.getText().toString());
                    }
                }
            }
        });
        customerAddress.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean hasFocus) {
                if (customerAddress.getText() != null) {
                    if (!hasFocus) {
                        customer.setCustomerAddress(customerAddress.getText().toString());
                    }
                }
            }
        });
    }
*/

}