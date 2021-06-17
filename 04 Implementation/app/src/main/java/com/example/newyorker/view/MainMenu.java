package com.example.newyorker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.newyorker.R;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }


    public void goToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToCatalogue(View view) {
        Intent intent = new Intent(this, CatalogueActivity.class);
        startActivity(intent);
    }

    public void gotoContactActivity(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        intent.putExtra("URL", "https://www.new-yorker.dk/kontakt/");
        startActivity(intent);
    }

    public void goToFacebook(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        intent.putExtra("URL", "https://www.facebook.com/newyorkerdk");
        startActivity(intent);
    }

    public void goToInstagram(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        intent.putExtra("URL", "https://www.instagram.com/newyorkerdk/");
        startActivity(intent);
    }

    public void goToLinkedIn(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        intent.putExtra("URL", "https://www.instagram.com/newyorkerdk/");
        startActivity(intent);
    }

    public void goToPintrest(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        intent.putExtra("URL", "https://www.pinterest.dk/newyorkerdk/");
        startActivity(intent);
    }
}