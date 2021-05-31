package com.example.newyorker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.newyorker.model.Observer;
import com.example.newyorker.model.Specifications;
import com.example.newyorker.model.Wall;

public class PreviewOrderActivity extends AppCompatActivity {

    double wallPrice;
    TextView totalPrice;
    Specifications specifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_order);
        totalPrice = findViewById(R.id.textview_price_preview_order);
        Intent intent = getIntent();
        specifications = (Specifications) intent.getSerializableExtra("Specifications");

        specifications.getWall().addDataObserver(new Observer() {
            @Override
            public void update() {
                totalPrice.setText(String.valueOf(roundPrice(specifications.getWall())));
            }
        });
        totalPrice.setText(String.valueOf(roundPrice(specifications.getWall())));
    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public double roundPrice(Wall wall) {
        return Math.round(wall.getWallPrice() * 100.0) / 100.0;
    }


    public void goToSendRequest(View view) {
        specifications.getWall().removeObserver();
        Intent intent = new Intent(this, SendRequestActivity.class);
        intent.putExtra("Specifications", specifications);
        startActivity(intent);
    }
}