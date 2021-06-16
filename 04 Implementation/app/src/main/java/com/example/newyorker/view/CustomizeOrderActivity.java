package com.example.newyorker.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    CheckBox checkBoxHandle;
    CheckBox checkBoxWetRoom;
    CheckBox checkBoxSpecialGlass;


    Spinner spinnerDoors;
    Spinner spinnerHandles;
    Spinner spinnerSpecialGlass;
    Spinner spinnerWallColour;

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

        checkBoxHandle = findViewById(R.id.checkbox_handle);
        checkBoxHandle.setEnabled(false);

        spinnerDoors = findViewById(R.id.spinner_doors);
        spinnerDoors.setEnabled(false);

        spinnerHandles = findViewById(R.id.spinner_handles);
        spinnerHandles.setEnabled(false);

        spinnerSpecialGlass = findViewById(R.id.spinner_special_glass);
        spinnerSpecialGlass.setEnabled(false);

        spinnerWallColour = findViewById(R.id.spinner_colours);

        textViewCustomizeActivityPrice = findViewById(R.id.textview_price_customize_activity);
    }

    private void  initializeListeners() {

        checkBoxDoor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!spinnerDoors.isEnabled())
                    { spinnerDoors.setEnabled(true);
                    checkBoxHandle.setEnabled(true); }
                else { spinnerDoors.setEnabled(false);
                    checkBoxHandle.setEnabled(false);
                    checkBoxHandle.setChecked(false);
                    spinnerHandles.setEnabled(false);}


                controller.customizeWall((byte) 1, checkBoxDoor.isChecked());
                controller.getCurrentWall().calculateWallPrice(spinnerDoors.getSelectedItemPosition()
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
                controller.getCurrentWall().calculateWallPrice(spinnerDoors.getSelectedItemPosition()
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
                controller.getCurrentWall().calculateWallPrice(spinnerDoors.getSelectedItemPosition()
                        , spinnerHandles.getSelectedItemPosition()
                        , spinnerSpecialGlass.getSelectedItemPosition());
            }

        });

        checkBoxWetRoom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                controller.customizeWall((byte) 4, checkBoxWetRoom.isChecked());
                controller.getCurrentWall().calculateWallPrice(spinnerDoors.getSelectedItemPosition()
                        , spinnerHandles.getSelectedItemPosition()
                        , spinnerSpecialGlass.getSelectedItemPosition());
            }

        });




        spinnerDoors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                controller.getCurrentWall().calculateWallPrice(spinnerDoors.getSelectedItemPosition()
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
                controller.getCurrentWall().calculateWallPrice(spinnerDoors.getSelectedItemPosition()
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
                controller.getCurrentWall().calculateWallPrice(spinnerDoors.getSelectedItemPosition()
                        , spinnerHandles.getSelectedItemPosition()
                        , spinnerSpecialGlass.getSelectedItemPosition());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerWallColour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                controller.setWallColour(spinnerWallColour.getSelectedItemPosition());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                controller.setWallColour(0);
            }
        });






    }

    public void goToPreviewActivity(View view) {

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        controller.removeWallObservers();
        
        // Its done defining the wall.
        controller.addWallToList();

        Intent intent = new Intent(this, PreviewOrderActivity.class);
        intent.putExtra("controller", controller);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.button_menu_preview_page){
            controller.removeWallObservers();

            Intent intent = new Intent(this, PreviewOrderActivity.class);
            intent.putExtra("controller", controller);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}