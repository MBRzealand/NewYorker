package com.example.newyorker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PreviewOrderActivity extends AppCompatActivity {

    double wallPrice;
    TextView totalPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_order);

        totalPrice = findViewById(R.id.textview_price);
        wallPrice =  getIntent().getDoubleExtra("wallPrice", wallPrice);


        totalPrice.setText(String.valueOf((int)wallPrice));

    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }

    public void goToSendRequest(View view) {

        Intent intent = new Intent(this, SendRequestActivity.class);

        startActivity(intent);

    }
}