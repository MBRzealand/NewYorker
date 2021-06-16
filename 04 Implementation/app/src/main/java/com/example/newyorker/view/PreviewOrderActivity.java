package com.example.newyorker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newyorker.R;
import com.example.newyorker.controller.NYBuilderController;
import com.example.newyorker.model.Observer;

public class PreviewOrderActivity extends AppCompatActivity {

    TextView totalPrice;
    NYBuilderController controller;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    TextView detailsTextview;
    Button btnPriceOverview;
    ImageView imageViewDrawing;
    Button btnDrawing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_order);

        totalPrice = findViewById(R.id.textview_price_preview_order);
        Intent intent = getIntent();
        controller = (NYBuilderController) intent.getSerializableExtra("controller");

        btn1 = findViewById(R.id.button_wall1);
        btn2 = findViewById(R.id.button_wall2);
        btn3 = findViewById(R.id.button_wall3);
        btn4 = findViewById(R.id.button_wall4);
        detailsTextview = findViewById(R.id.textViewWallDetails);
        btnPriceOverview = findViewById(R.id.button_price_overview);
        imageViewDrawing = findViewById(R.id.imageViewDrawing);
        btnDrawing = findViewById(R.id.button_drawing);

        editButtons();

        totalPrice.setText(String.valueOf(controller.getTotalPrice() + controller.getWallPrice()));
    }

    private void editButtons() {

        switch(controller.getSizeOfListOfWalls()) {
            case 1: {

                btn1.setVisibility(View.VISIBLE);
                btn1.setEnabled(true);
                btn2.setVisibility(View.GONE);
                btn2.setEnabled(false);
                btn3.setVisibility(View.GONE);
                btn3.setEnabled(false);
                btn4.setVisibility(View.GONE);
                btn4.setEnabled(false);
                break;
            }
            case 2: {
                btn1.setVisibility(View.VISIBLE);
                btn1.setEnabled(true);
                btn2.setVisibility(View.VISIBLE);
                btn2.setEnabled(true);
                btn3.setVisibility(View.GONE);
                btn3.setEnabled(false);
                btn4.setVisibility(View.GONE);
                btn4.setEnabled(false);
                break;
            }
            case 3: {
                btn1.setVisibility(View.VISIBLE);
                btn1.setEnabled(true);
                btn2.setVisibility(View.VISIBLE);
                btn2.setEnabled(true);
                btn3.setVisibility(View.VISIBLE);
                btn3.setEnabled(true);
                btn4.setVisibility(View.GONE);
                btn4.setEnabled(false);
                break;
            }
            case 4: {
                btn1.setVisibility(View.VISIBLE);
                btn1.setEnabled(true);
                btn2.setVisibility(View.VISIBLE);
                btn2.setEnabled(true);
                btn3.setVisibility(View.VISIBLE);
                btn3.setEnabled(true);
                btn4.setVisibility(View.VISIBLE);
                btn4.setEnabled(true);
                break;
            }
        }

    }
    
    public void wall1(View view) {
        controller.getWall(0);
        btn1.setBackgroundColor(getResources().getColor(R.color.orange));
        btn2.setBackgroundColor(getResources().getColor(R.color.light_grey));
        btn3.setBackgroundColor(getResources().getColor(R.color.light_grey));
        btn4.setBackgroundColor(getResources().getColor(R.color.light_grey));
    }

    public void wall2(View view) {
        controller.getWall(1);
        btn1.setBackgroundColor(getResources().getColor(R.color.light_grey));
        btn2.setBackgroundColor(getResources().getColor(R.color.orange));
        btn3.setBackgroundColor(getResources().getColor(R.color.light_grey));
        btn4.setBackgroundColor(getResources().getColor(R.color.light_grey));
    }

    public void wall3(View view) {
        controller.getWall(2);
        btn1.setBackgroundColor(getResources().getColor(R.color.light_grey));
        btn2.setBackgroundColor(getResources().getColor(R.color.light_grey));
        btn3.setBackgroundColor(getResources().getColor(R.color.orange));
        btn4.setBackgroundColor(getResources().getColor(R.color.light_grey));
    }

    public void wall4(View view) {
        controller.getWall(3);
        btn1.setBackgroundColor(getResources().getColor(R.color.light_grey));
        btn2.setBackgroundColor(getResources().getColor(R.color.light_grey));
        btn3.setBackgroundColor(getResources().getColor(R.color.light_grey));
        btn4.setBackgroundColor(getResources().getColor(R.color.orange));
    }

    public void getWallDetails(View view) {
        btnPriceOverview.setBackgroundColor(getResources().getColor(R.color.orange));
        btnDrawing.setBackgroundColor(getResources().getColor(R.color.light_grey));
        detailsTextview.setEnabled(true);
        detailsTextview.setVisibility(View.VISIBLE);
        detailsTextview.setText(controller.getWallDetails());
        imageViewDrawing.setVisibility(View.INVISIBLE);
    }

    public void getWallDrawing(View view) {
        btnPriceOverview.setBackgroundColor(getResources().getColor(R.color.light_grey));
        btnDrawing.setBackgroundColor(getResources().getColor(R.color.orange));
        detailsTextview.setEnabled(false);
        detailsTextview.setVisibility(View.GONE);

        // Make something similar, since .setImage() doesnt exist.
        // imageViewDrawing.setImage('Generated image for wall');

        imageViewDrawing.setVisibility(View.VISIBLE);
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