package com.example.newyorker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.newyorker.model.NYBuilderController;
import com.example.newyorker.model.Observer;
import com.example.newyorker.model.Specifications;
import com.example.newyorker.model.Wall;

public class CustomizeOrderActivity extends AppCompatActivity  {

    NYBuilderController controller;

    CheckBox checkBoxDoor;
    CheckBox checkBoxLockbox;
    CheckBox checkBoxHandle;
    CheckBox checkBoxWetRoom;
    CheckBox checkBoxSpecialGlass;
    CheckBox checkBoxShowerWall;

    Spinner spinnerDoors;
    Spinner spinnerHandles;
    Spinner spinnerSpecialGlass;

    TextView textViewCustomizeActivityPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_order);

        Intent intent = getIntent();
        controller = (NYBuilderController) intent.getSerializableExtra("controller");

        initializeUIElements();
        initializeListeners();

        controller.addWallDataObserver(new Observer() {
            @Override
            public void update() {
                textViewCustomizeActivityPrice.setText(String.valueOf(controller.getWallPrice()));
            }
        });

        textViewCustomizeActivityPrice.setText(String.valueOf(controller.getWallPrice()));

    }

    private void initializeUIElements() {
        checkBoxDoor = findViewById(R.id.checkbox_door);
        checkBoxLockbox = findViewById(R.id.checkbox_lockbox);
        checkBoxHandle = findViewById(R.id.checkbox_handle);
        checkBoxWetRoom = findViewById(R.id.checkbox_wetroom);
        checkBoxSpecialGlass = findViewById(R.id.checkbox_special_glass);
        checkBoxShowerWall = findViewById(R.id.checkbox_shower_wall);

        spinnerDoors = findViewById(R.id.spinner_doors);
        spinnerHandles = findViewById(R.id.spinner_handles);
        spinnerSpecialGlass = findViewById(R.id.spinner_special_glass);

        textViewCustomizeActivityPrice = findViewById(R.id.textview_price_customize_activity);
    }

    private void  initializeListeners() {
        checkBoxDoor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                controller.customizeWall((byte) 1, checkBoxDoor.isChecked());
            }

        });

        checkBoxLockbox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                controller.customizeWall((byte) 2, checkBoxLockbox.isChecked());
            }

        });

        checkBoxHandle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                controller.customizeWall((byte) 3, checkBoxHandle.isChecked());
            }

        });

        checkBoxWetRoom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                controller.customizeWall((byte) 4, checkBoxWetRoom.isChecked());
            }

        });

        checkBoxSpecialGlass.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                controller.customizeWall((byte) 5, checkBoxSpecialGlass.isChecked());
            }

        });

        checkBoxShowerWall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                controller.customizeWall((byte) 6, checkBoxShowerWall.isChecked());
            }

        });
    }

    public void goToPreviewActivity(View view) {

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        controller.removeWallObservers();


        Intent intent = new Intent(this, PreviewOrderActivity.class);
        intent.putExtra("controller", controller);
        startActivity(intent);

    }
}