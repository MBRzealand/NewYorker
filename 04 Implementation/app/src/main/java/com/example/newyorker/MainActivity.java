package com.example.newyorker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.newyorker.model.Observer;
import com.example.newyorker.model.Wall;


public class MainActivity extends AppCompatActivity {

    EditText heightInput;
    EditText widthInput;
    TextView textViewMainActivityPrice;

    Wall wall = new Wall();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initializeUIElements();
        initializeListeners();


        wall.addDataObserver(new Observer() {
            @Override
            public void update() {
                textViewMainActivityPrice.setText(String.valueOf(roundPrice(wall)));
            }
        });
    }

    private void initializeUIElements() {
        heightInput = findViewById(R.id.height_editText);
        widthInput = findViewById(R.id.width_editText);
        textViewMainActivityPrice = findViewById(R.id.textview_price_main_activity);
    }

    private void initializeListeners() {

        heightInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if (heightInput.getText() != null) {

                    if (!hasFocus) {
                        wall.setWallHeight(Double.parseDouble(heightInput.getText().toString()));
                    }

                    if ((!Double.isNaN(wall.getWallHeight())) && (!Double.isNaN(wall.getWallWidth()))) {
                        wall.calculateWallPrice(wall.getWallHeight(), wall.getWallWidth());
                    }

                }

            }
        });

        widthInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {


                if (heightInput.getText() != null) {

                    if (!hasFocus) {
                        wall.setWallWidth(Double.parseDouble(widthInput.getText().toString()));
                    }

                    if ((!Double.isNaN(wall.getWallHeight())) && (!Double.isNaN(wall.getWallWidth()))) {
                        wall.calculateWallPrice(wall.getWallHeight(), wall.getWallWidth());
                    }

                }

            }
        });

    }


    public void clearFocus() {
        heightInput.clearFocus();
        widthInput.clearFocus();
    }


    public double roundPrice(Wall wall) {
        return Math.round(wall.getWallPrice() * 100.0) / 100.0;
    }


    public void goToCustomizeOrder(View view) {


        clearFocus();

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        wall.removeObserver();


        Intent intent = new Intent(this, CustomizeOrderActivity.class);
        intent.putExtra("wallObject", wall);
        startActivity(intent);
    }


}