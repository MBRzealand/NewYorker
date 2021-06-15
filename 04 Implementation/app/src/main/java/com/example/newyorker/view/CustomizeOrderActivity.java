package com.example.newyorker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.newyorker.R;
import com.example.newyorker.controller.NYBuilderController;
import com.example.newyorker.model.Observer;

public class CustomizeOrderActivity extends AppCompatActivity  {

    NYBuilderController controller;

    CheckBox checkBoxDoor;
    CheckBox checkBoxLockbox;
    CheckBox checkBoxHandle;
    CheckBox checkBoxWetRoom;
    CheckBox checkBoxSpecialGlass;


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
        checkBoxWetRoom = findViewById(R.id.checkbox_wetroom);
        checkBoxSpecialGlass = findViewById(R.id.checkbox_special_glass);

        checkBoxLockbox = findViewById(R.id.checkbox_lockbox);
        checkBoxLockbox.setEnabled(false);

        checkBoxHandle = findViewById(R.id.checkbox_handle);
        checkBoxHandle.setEnabled(false);

        spinnerDoors = findViewById(R.id.spinner_doors);
        spinnerDoors.setEnabled(false);

        spinnerHandles = findViewById(R.id.spinner_handles);
        spinnerHandles.setEnabled(false);

        spinnerSpecialGlass = findViewById(R.id.spinner_special_glass);
        spinnerSpecialGlass.setEnabled(false);

        textViewCustomizeActivityPrice = findViewById(R.id.textview_price_customize_activity);
    }

    private void  initializeListeners() {

        checkBoxDoor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!spinnerDoors.isEnabled())
                    { spinnerDoors.setEnabled(true);
                    checkBoxLockbox.setEnabled(true);
                    checkBoxHandle.setEnabled(true); }
                else { spinnerDoors.setEnabled(false);
                    checkBoxLockbox.setEnabled(false);
                    checkBoxLockbox.setChecked(false);
                    checkBoxHandle.setEnabled(false);
                    checkBoxHandle.setChecked(false);
                    spinnerHandles.setEnabled(false);}


                controller.customizeWall((byte) 1, checkBoxDoor.isChecked());
                controller.getWall(0).calculateWallPrice(spinnerDoors.getSelectedItemPosition()
                                                                , spinnerHandles.getSelectedItemPosition()
                                                                , spinnerSpecialGlass.getSelectedItemPosition());
            }

        });

        checkBoxLockbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.customizeWall((byte) 2, checkBoxLockbox.isChecked());
                controller.getWall(0).calculateWallPrice(spinnerDoors.getSelectedItemPosition()
                        , spinnerHandles.getSelectedItemPosition()
                        , spinnerSpecialGlass.getSelectedItemPosition());
            }

        });

        checkBoxHandle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (spinnerHandles.isEnabled()){
                    spinnerHandles.setEnabled(false);
                }else{
                    spinnerHandles.setEnabled(true);
                }
                controller.customizeWall((byte) 3, checkBoxHandle.isChecked());
                controller.getWall(0).calculateWallPrice(spinnerDoors.getSelectedItemPosition()
                        , spinnerHandles.getSelectedItemPosition()
                        , spinnerSpecialGlass.getSelectedItemPosition());
            }

        });



        checkBoxSpecialGlass.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (spinnerSpecialGlass.isEnabled()){
                    spinnerSpecialGlass.setEnabled(false);
                }else{
                    spinnerSpecialGlass.setEnabled(true);
                }
                controller.customizeWall((byte) 5, checkBoxSpecialGlass.isChecked());
                controller.getWall(0).calculateWallPrice(spinnerDoors.getSelectedItemPosition()
                        , spinnerHandles.getSelectedItemPosition()
                        , spinnerSpecialGlass.getSelectedItemPosition());
            }

        });


        spinnerDoors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                controller.getWall(0).calculateWallPrice(spinnerDoors.getSelectedItemPosition()
                        , spinnerHandles.getSelectedItemPosition()
                        , spinnerSpecialGlass.getSelectedItemPosition());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerSpecialGlass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                controller.getWall(0).calculateWallPrice(spinnerDoors.getSelectedItemPosition()
                        , spinnerHandles.getSelectedItemPosition()
                        , spinnerSpecialGlass.getSelectedItemPosition());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerHandles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                controller.getWall(0).calculateWallPrice(spinnerDoors.getSelectedItemPosition()
                        , spinnerHandles.getSelectedItemPosition()
                        , spinnerSpecialGlass.getSelectedItemPosition());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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