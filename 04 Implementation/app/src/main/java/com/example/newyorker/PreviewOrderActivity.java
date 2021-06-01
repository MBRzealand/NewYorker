package com.example.newyorker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.newyorker.model.NYBuilderController;
import com.example.newyorker.model.Observer;
import com.example.newyorker.model.Specifications;
import com.example.newyorker.model.Wall;

public class PreviewOrderActivity extends AppCompatActivity {

    TextView totalPrice;
    NYBuilderController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_order);

        totalPrice = findViewById(R.id.textview_price_preview_order);
        Intent intent = getIntent();
        controller = (NYBuilderController) intent.getSerializableExtra("controller");

        controller.addWallDataObserver(new Observer() {
            @Override
            public void update() {
                totalPrice.setText(String.valueOf(controller.getWallPrice()));
            }
        });

        totalPrice.setText(String.valueOf(controller.getWallPrice()));
    }

    public void goToMainActivity(View view) {

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        controller.removeWallObservers();

        Intent intent = new Intent(this, MainActivity.class);
        controller.newWall();
        intent.putExtra("controller", controller);
        startActivity(intent);

    }

    public void goToSendRequest(View view) {

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        controller.removeWallObservers();

        Intent intent = new Intent(this, SendRequestActivity.class);
        intent.putExtra("controller", controller);
        startActivity(intent);

    }
}