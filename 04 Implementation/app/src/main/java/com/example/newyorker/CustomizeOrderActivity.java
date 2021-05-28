package com.example.newyorker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CustomizeOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_order);
    }

    public void goToPreviewActivity(View view) {

        Intent intent = new Intent(this, PreviewOrderActivity.class);

        startActivity(intent);

    }
}