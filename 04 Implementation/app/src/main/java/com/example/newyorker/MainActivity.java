package com.example.newyorker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.newyorker.model.Wall;

public class MainActivity extends AppCompatActivity {

    Wall wall = new Wall();

    EditText heightInput;
    EditText widthInput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightInput = findViewById(R.id.height_editText);
        widthInput = findViewById(R.id.width_editText);


    }

    public void goToCustomizeOrder(View view) {


        wall.setWallHeight(Double.parseDouble(heightInput.getText().toString()));
        wall.setWallWidth(Double.parseDouble(widthInput.getText().toString()));
        wall.setWallPrice(wall.calculateWallPrice(wall.getWallHeight(),wall.getWallWidth()));

        Intent intent = new Intent(this, CustomizeOrderActivity.class);

        intent.putExtra("wallPrice", wall.getWallPrice());

        startActivity(intent);


    }





}