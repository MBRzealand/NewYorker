package com.example.newyorker.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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

        controller.addWallDataObserver(new Observer() {
            @Override
            public void update() {
                totalPrice.setText(String.valueOf(controller.getWallPrice()));
            }
        });

        totalPrice.setText(String.valueOf(controller.getWallPrice()));
    }

    public void goToMainActivity(View view) {

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        controller.removeWallObservers();

        Intent intent = new Intent(this, MainActivity.class);
        controller.newWall();
        intent.putExtra("controller", controller);
        startActivity(intent);

    }

    public void goToSendRequest(View view) {

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        controller.removeWallObservers();

        Intent intent = new Intent(this, SendRequestActivity.class);
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