package com.example.newyorker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.newyorker.Exceptions.MissingWallHeightException;
import com.example.newyorker.Exceptions.MissingWallWidthException;
import com.example.newyorker.model.NYBuilderController;
import com.example.newyorker.model.Observer;
import com.example.newyorker.model.Wall;


public class MainActivity extends AppCompatActivity {

    EditText heightInput;
    EditText widthInput;
    TextView textViewMainActivityPrice;

    NYBuilderController controller = new NYBuilderController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUIElements();
        initializeListeners();

        controller.newWall();

        controller.addWallDataObserver(new Observer() {
            @Override
            public void update() {
                textViewMainActivityPrice.setText(String.valueOf(controller.getWallPrice()));
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
                        controller.setWallHeight(heightInput.getText().toString());
                    }

                    controller.calculateWallPrice();
                }

            }
        });

        widthInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if (widthInput.getText() != null) {
                    if (!hasFocus) {
                        controller.setWallWidth(widthInput.getText().toString());
                    }

                    controller.calculateWallPrice();
                }

            }
        });

    }

    public void clearFocus() {
        heightInput.clearFocus();
        widthInput.clearFocus();
    }



    public void goToCustomizeOrder(View view) {

        clearFocus();

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        controller.removeWallObservers();

        Intent intent = new Intent(this, CustomizeOrderActivity.class);
        intent.putExtra("controller", controller);
        startActivity(intent);
    }

}