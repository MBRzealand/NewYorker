package com.example.newyorker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.newyorker.model.Customer;
import com.example.newyorker.model.Email;
import com.example.newyorker.model.Specifications;

public class SendRequestActivity extends AppCompatActivity {

    Specifications specifications;
    Customer customer;
    Email email = new Email();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__send__request);
        Intent intent = getIntent();
        specifications = (Specifications) intent.getSerializableExtra("Specifications");

    }



    public void sendRequest(View view) {
        startActivity(email.sendEmail("hjordrup96@live.dk", customer));

    }
}