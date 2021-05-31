package com.example.newyorker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.newyorker.model.Observer;
import com.example.newyorker.model.Wall;

public class CustomizeOrderActivity extends AppCompatActivity {

    Wall wall;

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

        wall = (Wall) intent.getSerializableExtra("wallObject");

        initializeUIElements();
        initializeListeners();

        wall.addDataObserver(new Observer() {
            @Override
            public void update() {
                textViewCustomizeActivityPrice.setText(String.valueOf(roundPrice(wall)));
            }
        });

        textViewCustomizeActivityPrice.setText(String.valueOf(roundPrice(wall)));

    }

    private void initializeUIElements(){
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


    private void  initializeListeners(){
        checkBoxDoor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                wall.setHasDoor(checkBoxDoor.isChecked());
            }

        });

        checkBoxLockbox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                wall.setHasLockbox(checkBoxLockbox.isChecked());
            }

        });

        checkBoxHandle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                wall.setHasHandle(checkBoxHandle.isChecked());
            }

        });

        checkBoxWetRoom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                wall.setHasWetroom(checkBoxWetRoom.isChecked());
            }

        });

        checkBoxSpecialGlass.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                wall.setHasSpecialGlass(checkBoxSpecialGlass.isChecked());
            }

        });

        checkBoxShowerWall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                wall.setHasShowerWall(checkBoxShowerWall.isChecked());
            }

        });
    }

    public double roundPrice(Wall wall){
        return Math.round(wall.getWallPrice() * 100.0) / 100.0;
    }

    public void goToPreviewActivity(View view) {

        Intent intent = new Intent(this, PreviewOrderActivity.class);

        startActivity(intent);

    }
}