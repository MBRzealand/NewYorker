package com.example.newyorker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CustomizeOrderActivity extends AppCompatActivity {

    double wallPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_order);

        wallPrice = getIntent().getDoubleExtra("wallPrice", wallPrice);

    }

    public void goToPreviewActivity(View view) {

        Intent intent = new Intent(this, PreviewOrderActivity.class);

        intent.putExtra("wallPrice",  wallPrice);

        startActivity(intent);

    }
}