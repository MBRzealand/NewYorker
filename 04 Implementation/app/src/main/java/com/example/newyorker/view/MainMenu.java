package com.example.newyorker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.newyorker.R;
import com.example.newyorker.controller.NYBuilderController;

import java.io.Serializable;

public class MainMenu extends AppCompatActivity implements Serializable {


    NYBuilderController controller;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        /* It gets an intent from previewOrder if the user adds a new wall.
           If an intent is null, then it is the beginning of the app.*/
        if (getIntent().getSerializableExtra("controller") != null) {
            Intent intent = getIntent();
            controller = (NYBuilderController) intent.getSerializableExtra("controller");
        } else {
            controller = new NYBuilderController();
        }
    }


    public void goToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("controller", controller);
        startActivity(intent);
    }

    public void goToCatalogue(View view) {
        Intent intent = new Intent(this, CatalogueActivity.class);
        intent.putExtra("controller", controller);
        startActivity(intent);
    }

    public void gotoContactActivity(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        intent.putExtra("controller", controller);
        intent.putExtra("URL", "https://www.new-yorker.dk/kontakt/");
        startActivity(intent);
    }

    public void goToFacebook(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        intent.putExtra("controller", controller);
        intent.putExtra("URL", "https://www.facebook.com/newyorkerdk");
        startActivity(intent);
    }

    public void goToInstagram(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        intent.putExtra("controller", controller);
        intent.putExtra("URL", "https://www.instagram.com/newyorkerdk/");
        startActivity(intent);
    }

    public void goToLinkedIn(View view) {

        Intent intent = new Intent(this, ContactActivity.class);
        intent.putExtra("controller", controller);
        intent.putExtra("URL", "https://www.instagram.com/newyorkerdk/");
        startActivity(intent);
    }

    public void goToPintrest(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        intent.putExtra("controller", controller);
        intent.putExtra("URL", "https://www.pinterest.dk/newyorkerdk/");
        startActivity(intent);
    }
}