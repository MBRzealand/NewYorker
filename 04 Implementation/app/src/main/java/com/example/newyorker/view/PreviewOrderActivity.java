package com.example.newyorker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.newyorker.R;
import com.example.newyorker.controller.NYBuilderController;
import com.example.newyorker.model.Observer;

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

        editButtons();

        totalPrice.setText(String.valueOf(controller.getTotalPrice() + controller.getWallPrice()));
    }

    private void editButtons() {

        switch(controller.getSizeOfListOfWalls()) {
            case 0: {
                Button btn1 = findViewById(R.id.button_wall1);
                btn1.setVisibility(View.VISIBLE);
                btn1.setEnabled(true);
                Button btn2 = findViewById(R.id.button_wall2);
                btn2.setVisibility(View.GONE);
                btn2.setEnabled(false);
                Button btn3 = findViewById(R.id.button_wall3);
                btn3.setVisibility(View.GONE);
                btn3.setEnabled(false);
                Button btn4 = findViewById(R.id.button_wall4);
                btn4.setVisibility(View.GONE);
                btn4.setEnabled(false);
                break;
            }
            case 1: {
                Button btn1 = findViewById(R.id.button_wall1);
                btn1.setVisibility(View.VISIBLE);
                btn1.setEnabled(true);
                Button btn2 = findViewById(R.id.button_wall2);
                btn2.setVisibility(View.VISIBLE);
                btn2.setEnabled(true);
                Button btn3 = findViewById(R.id.button_wall3);
                btn3.setVisibility(View.GONE);
                btn3.setEnabled(false);
                Button btn4 = findViewById(R.id.button_wall4);
                btn4.setVisibility(View.GONE);
                btn4.setEnabled(false);
                break;
            }
            case 2: {
                Button btn1 = findViewById(R.id.button_wall1);
                btn1.setVisibility(View.VISIBLE);
                btn1.setEnabled(true);
                Button btn2 = findViewById(R.id.button_wall2);
                btn2.setVisibility(View.VISIBLE);
                btn2.setEnabled(true);
                Button btn3 = findViewById(R.id.button_wall3);
                btn3.setVisibility(View.VISIBLE);
                btn3.setEnabled(true);
                Button btn4 = findViewById(R.id.button_wall4);
                btn4.setVisibility(View.GONE);
                btn4.setEnabled(false);
                break;
            }
            case 3: {
                Button btn1 = findViewById(R.id.button_wall1);
                btn1.setVisibility(View.VISIBLE);
                btn1.setEnabled(true);
                Button btn2 = findViewById(R.id.button_wall2);
                btn2.setVisibility(View.VISIBLE);
                btn2.setEnabled(true);
                Button btn3 = findViewById(R.id.button_wall3);
                btn3.setVisibility(View.VISIBLE);
                btn3.setEnabled(true);
                Button btn4 = findViewById(R.id.button_wall4);
                btn4.setVisibility(View.VISIBLE);
                btn4.setEnabled(true);
                break;
            }
        }

    }

    public void goToMainActivity(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("controller", controller);
        startActivity(intent);

    }

    public void goToSendRequest(View view) {

        Intent intent = new Intent(this, SendRequestActivity.class);
        intent.putExtra("controller", controller);
        startActivity(intent);

    }
}