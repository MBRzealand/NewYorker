package com.example.newyorker.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newyorker.R;
import com.example.newyorker.controller.NYBuilderController;

public class PreviewOrderActivity extends AppCompatActivity {

    TextView totalPrice;
    NYBuilderController controller;
    Button btnWall1;
    Button btnWall2;
    Button btnWall3;
    Button btnWall4;
    TextView detailsTextview;
    Button btnPriceOverview;
    ImageView imageViewDrawing;
    Button btnDrawing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_order);

        totalPrice = findViewById(R.id.textview_price_preview_order);
        Intent intent = getIntent();
        controller = (NYBuilderController) intent.getSerializableExtra("controller");

        btnWall1 = findViewById(R.id.button_wall1);
        btnWall2 = findViewById(R.id.button_wall2);
        btnWall3 = findViewById(R.id.button_wall3);
        btnWall4 = findViewById(R.id.button_wall4);
        detailsTextview = findViewById(R.id.textViewWallDetails);
        btnPriceOverview = findViewById(R.id.button_price_overview);
        imageViewDrawing = findViewById(R.id.imageViewDrawing);
        btnDrawing = findViewById(R.id.button_drawing);

        editButtons();
        btnDrawing.callOnClick();
        btnWall1.callOnClick();

        totalPrice.setText(String.valueOf(controller.getTotalPrice()));
    }

    private void editButtons() {

        switch(controller.getSizeOfListOfWalls()) {
            case 0: {

                btnWall1.setVisibility(View.GONE);
                btnWall1.setEnabled(false);
                btnWall2.setVisibility(View.GONE);
                btnWall2.setEnabled(false);
                btnWall3.setVisibility(View.GONE);
                btnWall3.setEnabled(false);
                btnWall4.setVisibility(View.GONE);
                btnWall4.setEnabled(false);
                break;
            }
            case 1: {

                btnWall1.setVisibility(View.VISIBLE);
                btnWall1.setEnabled(true);
                btnWall2.setVisibility(View.GONE);
                btnWall2.setEnabled(false);
                btnWall3.setVisibility(View.GONE);
                btnWall3.setEnabled(false);
                btnWall4.setVisibility(View.GONE);
                btnWall4.setEnabled(false);
                break;
            }
            case 2: {
                btnWall1.setVisibility(View.VISIBLE);
                btnWall1.setEnabled(true);
                btnWall2.setVisibility(View.VISIBLE);
                btnWall2.setEnabled(true);
                btnWall3.setVisibility(View.GONE);
                btnWall3.setEnabled(false);
                btnWall4.setVisibility(View.GONE);
                btnWall4.setEnabled(false);
                break;
            }
            case 3: {
                btnWall1.setVisibility(View.VISIBLE);
                btnWall1.setEnabled(true);
                btnWall2.setVisibility(View.VISIBLE);
                btnWall2.setEnabled(true);
                btnWall3.setVisibility(View.VISIBLE);
                btnWall3.setEnabled(true);
                btnWall4.setVisibility(View.GONE);
                btnWall4.setEnabled(false);
                break;
            }
            case 4: {
                btnWall1.setVisibility(View.VISIBLE);
                btnWall1.setEnabled(true);
                btnWall2.setVisibility(View.VISIBLE);
                btnWall2.setEnabled(true);
                btnWall3.setVisibility(View.VISIBLE);
                btnWall3.setEnabled(true);
                btnWall4.setVisibility(View.VISIBLE);
                btnWall4.setEnabled(true);
                break;
            }
        }

    }
    
    public void wall1(View view) {
        wallButtons(0);
    }

    public void wall2(View view) {
        wallButtons(1);
    }

    public void wall3(View view) {
        wallButtons(2);
    }

    public void wall4(View view) {
        wallButtons(3);
    }

    public void wallButtons(int btnIndex) {

        controller.getWall(btnIndex);
        String[] doorNames = getResources().getStringArray(R.array.door_array);
        detailsTextview.setText(controller.getWallDetails(doorNames));

        btnWall1.setBackgroundColor(getResources().getColor(R.color.light_grey));
        btnWall2.setBackgroundColor(getResources().getColor(R.color.light_grey));
        btnWall3.setBackgroundColor(getResources().getColor(R.color.light_grey));
        btnWall4.setBackgroundColor(getResources().getColor(R.color.light_grey));

        switch (btnIndex) {
            case 0: {
                btnWall1.setBackgroundColor(getResources().getColor(R.color.orange));
                break;
            }
            case 1: {
                btnWall2.setBackgroundColor(getResources().getColor(R.color.orange));
                break;
            }
            case 2: {
                btnWall3.setBackgroundColor(getResources().getColor(R.color.orange));
                break;
            }
            case 3: {
                btnWall4.setBackgroundColor(getResources().getColor(R.color.orange));
                break;
            }
        }

    }

    public void getWallDetails(View view) {
        btnPriceOverview.setBackgroundColor(getResources().getColor(R.color.orange));
        btnDrawing.setBackgroundColor(getResources().getColor(R.color.light_grey));
        detailsTextview.setEnabled(true);
        detailsTextview.setVisibility(View.VISIBLE);
        imageViewDrawing.setVisibility(View.INVISIBLE);
    }

    public void getWallDrawing(View view) {
        btnPriceOverview.setBackgroundColor(getResources().getColor(R.color.light_grey));
        btnDrawing.setBackgroundColor(getResources().getColor(R.color.orange));
        detailsTextview.setEnabled(false);
        detailsTextview.setVisibility(View.GONE);

        // Make something similar, since .setImage() doesnt exist.
        // imageViewDrawing.setImage('Generated image for wall');

        imageViewDrawing.setVisibility(View.VISIBLE);
    }

    public void removeWall(View view) {
        int listSize = controller.getSizeOfListOfWalls();
        if (listSize > 0) {
            controller.destroyWall();
            editButtons();
            if (listSize > 1) {
                btnWall1.callOnClick();
            } else {
                detailsTextview.setText("");
            }
        }
    }

    public void goToMainActivity(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("controller", controller);
        startActivity(intent);

    }

    public void goToSendRequest(View view) {

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
        if (itemId == R.id.button_menu_katalog) {
            controller.removeWallObservers();

            Intent intent = new Intent(this, CatalogueActivity.class);
            intent.putExtra("controller", controller);
            startActivity(intent);
        }
        if (itemId == R.id.button_menu_kontakt) {
            controller.removeWallObservers();

            Intent intent = new Intent(this, ContactActivity.class);
            intent.putExtra("URL", "https://www.new-yorker.dk/kontakt/");
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
