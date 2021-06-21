package com.example.newyorker.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newyorker.R;
import com.example.newyorker.controller.NYBuilderController;
import com.example.newyorker.model.Email;
import com.example.newyorker.model.Wall;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendRequestActivity extends AppCompatActivity {


    NYBuilderController controller;
    Email email = new Email();
    EditText customerName;
    EditText customerPhoneNumber;
    EditText customerEmailAddress;
    EditText customerAddress;
    EditText customerZIPCode;
    EditText notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__send__request);

        Intent intent = getIntent();
        controller = (NYBuilderController) intent.getSerializableExtra("controller");
        initializeUIElements();


    }



    public void sendRequest(View view){
        controller.setCustomerName(customerName.getText().toString());
        controller.setCustomerZIPCode(customerZIPCode.getText().toString());
        controller.setCustomerEmailAddress(customerEmailAddress.getText().toString());
        controller.setCustomerPhoneNumber(customerPhoneNumber.getText().toString());
        controller.setCustomerAddress(customerAddress.getText().toString());
        controller.setCustomerNotes(notes.getText().toString());



        email.sendEmail(controller.getCustomer(), compileDetails());
    }



    private void initializeUIElements() {
       customerName = findViewById(R.id.editText_name);
       customerAddress = findViewById(R.id.editText_address);
       customerEmailAddress = findViewById(R.id.editText_email_address);
       customerPhoneNumber = findViewById(R.id.editText_phone_number);
       customerZIPCode = findViewById(R.id.editText_zip_code);
       notes = findViewById(R.id.editText_notes);
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
        if (itemId == R.id.button_menu_preview_page && controller.getSizeOfListOfWalls() == 0) {
            Toast.makeText(this, "kurven er tom", Toast.LENGTH_SHORT).show();
        }

        if(itemId == R.id.button_menu_preview_page && controller.getSizeOfListOfWalls() > 0){
            controller.removeWallObservers();

            Intent intent = new Intent(this, PreviewOrderActivity.class);
            intent.putExtra("controller", controller);
            startActivity(intent);
        }
        if (itemId == R.id.button_menu_katalog) {
            controller.removeWallObservers();

            Intent intent = new Intent(this, CatalogueActivity.class);
            intent.putExtra("controller", controller);
            startActivity(intent);
        }if (itemId == R.id.button_menu_kontakt) {
            controller.removeWallObservers();

            Intent intent = new Intent(this, ContactActivity.class);
            intent.putExtra("URL", "https://www.new-yorker.dk/kontakt/");
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public String compileDetails(){
        String details = "";

        for (int i = 0; i < controller.getSizeOfListOfWalls(); i++) {
            controller.getWall(i);
            details += controller.getWallDetails(getResources().getStringArray(R.array.door_array)) + "\n\n";

        }
        return details;
    }

    public void goToMainMenu(View view) {
        Intent intent = new Intent(this, MainMenu.class);
        intent.putExtra("controller", controller);
        startActivity(intent);
    }

}