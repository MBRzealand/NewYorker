package com.example.newyorker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.newyorker.R;
import com.example.newyorker.controller.NYBuilderController;
import com.example.newyorker.model.Observer;


public class MainActivity extends AppCompatActivity {

    EditText heightInput;
    EditText widthInput;
    TextView textViewMainActivityPrice;

    TextView textview_height_exception;
    TextView textview_width_exception;

    InputMethodManager imm;

    NYBuilderController controller = new NYBuilderController();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

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
        textview_height_exception = findViewById(R.id.textview_height_exception);
        textview_width_exception = findViewById(R.id.textview_width_exception);
    }

    private void initializeListeners() {

        heightInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if (heightInput.getText() != null) {

                    if (!hasFocus) {
                        textview_height_exception.setText(controller.setWallHeight(heightInput.getText().toString()));
                    }

                    controller.calculateWallPrice();
                }

            }
        });

        widthInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if (widthInput.getText() != null) {
                    if (!hasFocus) {
                        textview_width_exception.setText(controller.setWallWidth(widthInput.getText().toString()));
                    }

                    controller.calculateWallPrice();
                }

            }
        });


        widthInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    v.clearFocus();

                    return true;
                }
                return false;
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