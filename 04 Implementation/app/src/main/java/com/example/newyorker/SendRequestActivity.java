package com.example.newyorker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.newyorker.model.Customer;
import com.example.newyorker.model.Email;

public class SendRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__send__request);


    }

    Email email = new Email();


    public void sendRequest(View view) {
        startActivity(email.sendEmail("hjordrup96@live.dk", new Customer()));

    }
}