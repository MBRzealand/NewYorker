package com.example.newyorker.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.newyorker.R;
import com.example.newyorker.controller.NYBuilderController;

import static com.example.newyorker.R.color.dark_grey;

public class CatalogueActivity extends AppCompatActivity {

    NYBuilderController controller;

    ImageView et_fag_4_glas;
    ImageView to_fag_8_glas;
    ImageView to_fag_6_glas;
    ImageView doer_6_glas;
    ImageView dobbeltdoer_m_12_glas;
    ImageView skydedoer_m_6_glas;
    ImageView tre_fag_m_enkeltdoer_m_12_glas;
    ImageView fire_fag_m_dobbeltdoer_m_16_glas;
    ImageView fem_fag_m_enkeltdoer_m_20_glas;
    ImageView seks_fag_m_enkeltdoer_m_24_glas;

    int chosenWall;


    Button Button_select_wall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue);
        InitializeUIElements();

        Intent intent = getIntent();
        controller = (NYBuilderController) intent.getSerializableExtra("controller");

    }

    public void InitializeUIElements(){

        et_fag_4_glas = findViewById(R.id.et_fag_4_glas);
        to_fag_8_glas = findViewById(R.id.to_fag_8_glas);
        to_fag_6_glas = findViewById(R.id.to_fag_6_glas);
        doer_6_glas = findViewById(R.id.doer_m_6_glas);
        dobbeltdoer_m_12_glas = findViewById(R.id.dobbeltdoer_m_12_glas);
        skydedoer_m_6_glas = findViewById(R.id.skydedoer_m_6_glas);
        tre_fag_m_enkeltdoer_m_12_glas = findViewById(R.id.tre_fag_m_enkeltdoer_m_12_glas);
        fire_fag_m_dobbeltdoer_m_16_glas = findViewById(R.id.fire_fag_m_dobbeltdoer_m_16_glas);
        fem_fag_m_enkeltdoer_m_20_glas = findViewById(R.id.fem_fag_m_enkeltdoer_m_20_glas);
        seks_fag_m_enkeltdoer_m_24_glas = findViewById(R.id.seks_fag_m_enkeltdoer_m_24_glas);

        Button_select_wall = findViewById(R.id.Button_select_wall);

        disableNavigationButton();

    }


    public void clearImageHighlights(){

        et_fag_4_glas.setImageResource(R.mipmap.et_fag_m_4_glas);
        to_fag_8_glas.setImageResource(R.mipmap.to_fag_m_8_glas);
        to_fag_6_glas.setImageResource(R.mipmap.to_fag_m_6_glas);
        doer_6_glas.setImageResource(R.mipmap.doer_m_6_glas);
        dobbeltdoer_m_12_glas.setImageResource(R.mipmap.dobbeltdoer_m_12_glas);
        skydedoer_m_6_glas.setImageResource(R.mipmap.skydedoer_m_6_glas);
        tre_fag_m_enkeltdoer_m_12_glas.setImageResource(R.mipmap.tre_fag_m_12_glas_m_enkeltdoer);
        fire_fag_m_dobbeltdoer_m_16_glas.setImageResource(R.mipmap.fire_fag_m_16_glas_m_dobbeltdoer);
        fem_fag_m_enkeltdoer_m_20_glas.setImageResource(R.mipmap.fem_fag_m_20_glas_m_enkeltdoer);
        seks_fag_m_enkeltdoer_m_24_glas.setImageResource(R.mipmap.seks_fag_m_24_glas_m_enkeltdoer);

        et_fag_4_glas.setClickable(true);
        to_fag_8_glas.setClickable(true);
        to_fag_6_glas.setClickable(true);
        doer_6_glas.setClickable(true);
        dobbeltdoer_m_12_glas.setClickable(true);
        skydedoer_m_6_glas.setClickable(true);
        tre_fag_m_enkeltdoer_m_12_glas.setClickable(true);
        fire_fag_m_dobbeltdoer_m_16_glas.setClickable(true);
        fem_fag_m_enkeltdoer_m_20_glas.setClickable(true);
        seks_fag_m_enkeltdoer_m_24_glas.setClickable(true);

    }

    public void disableNavigationButton(){
        Button_select_wall.setVisibility(View.GONE);
        Button_select_wall.setEnabled(false);
    }

    public void enableNavigationButton(){
        Button_select_wall.setVisibility(View.VISIBLE);
        Button_select_wall.setEnabled(true);
    }

    public void selectEtFag4Glas(View view) {
        chosenWall = 1;
        clearImageHighlights();

        et_fag_4_glas.setClickable(false);
        et_fag_4_glas.setImageResource(R.mipmap.et_fag_m_4_glas_highlighted);

        enableNavigationButton();

    }

    public void SelectToFag8Glas(View view) {
        chosenWall = 2;
        clearImageHighlights();

        to_fag_8_glas.setClickable(false);
        to_fag_8_glas.setImageResource(R.mipmap.to_fag_m_8_glas_highlighted);

        enableNavigationButton();

    }

    public void SelectToFag6Glas(View view) {
        chosenWall = 3;
        clearImageHighlights();

        to_fag_6_glas.setClickable(false);
        to_fag_6_glas.setImageResource(R.mipmap.to_fag_m_6_glas_highlighted);

        enableNavigationButton();

    }

    public void SelectDoer6Glas(View view) {
        chosenWall = 4;
        clearImageHighlights();

        doer_6_glas.setClickable(false);
        doer_6_glas.setImageResource(R.mipmap.doer_m_6_glas_highlighted);

        enableNavigationButton();

    }

    public void SelectDobbeltdoer12Glas(View view) {
        chosenWall = 5;
        clearImageHighlights();

        dobbeltdoer_m_12_glas.setClickable(false);
        dobbeltdoer_m_12_glas.setImageResource(R.mipmap.dobbeltdoer_m_12_glas_highlighted);

        enableNavigationButton();


    }

    public void SelectSkydedoer6Glas(View view) {
        chosenWall = 6;
        clearImageHighlights();

        skydedoer_m_6_glas.setClickable(false);
        skydedoer_m_6_glas.setImageResource(R.mipmap.skydedoer_m_6_glas_highlighted);

        enableNavigationButton();

    }

    public void SelectTreFagEnkeltdoer12Glas(View view) {
        chosenWall = 7;
        clearImageHighlights();

        tre_fag_m_enkeltdoer_m_12_glas.setClickable(false);
        tre_fag_m_enkeltdoer_m_12_glas.setImageResource(R.mipmap.tre_fag_m_12_glas_m_enkeltdoer_highlighted);

        enableNavigationButton();

    }

    public void SelectFireFagDobbeltdoer16Glas(View view) {
        chosenWall = 8;
        clearImageHighlights();

        fire_fag_m_dobbeltdoer_m_16_glas.setClickable(false);
        fire_fag_m_dobbeltdoer_m_16_glas.setImageResource(R.mipmap.fire_fag_m_16_glas_m_dobbeltdoer_highlighted);

        enableNavigationButton();

    }

    public void SelectFemFagEnkeltdoer20Glas(View view) {
        chosenWall = 9;
        clearImageHighlights();

        fem_fag_m_enkeltdoer_m_20_glas.setClickable(false);
        fem_fag_m_enkeltdoer_m_20_glas.setImageResource(R.mipmap.fem_fag_m_20_glas_m_enkeltdoer_highlighted);

        enableNavigationButton();

    }

    public void SelectSeksFagEnkeltdoer24Glas(View view) {
        chosenWall = 10;
        clearImageHighlights();

        seks_fag_m_enkeltdoer_m_24_glas.setClickable(false);
        seks_fag_m_enkeltdoer_m_24_glas.setImageResource(R.mipmap.seks_fag_m_24_glas_m_enkeltdoer_highlighted);

        enableNavigationButton();

    }

    public void selectChosenWall(View view) {

        switch(chosenWall) {

            case 1:
                //Empty list of observers before serializing the object, so we can pass it on to the other activities.
                controller.removeWallObservers();

                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("controller", controller);

                intent.putExtra("wallName", "1 FAG M/ 4 GLAS");
                intent.putExtra("width", "40");
                intent.putExtra("height", "180");
                intent.putExtra("panelsInWidthIndex","0");
                intent.putExtra("panelsInHeightIndex","3");
                intent.putExtra("price","4925");

                startActivity(intent);
            break;

            case 2:
                //Empty list of observers before serializing the object, so we can pass it on to the other activities.
                controller.removeWallObservers();

                Intent intent2 = new Intent(this, MainActivity.class);
                intent2.putExtra("controller", controller);

                intent2.putExtra("wallName","2 FAG M/ 8 GLAS");
                intent2.putExtra("width", "80");
                intent2.putExtra("height", "180");
                intent2.putExtra("panelsInWidthIndex","1");
                intent2.putExtra("panelsInHeightIndex","3");
                intent2.putExtra("price","9850");

                startActivity(intent2);
            break;

            case 3:
                //Empty list of observers before serializing the object, so we can pass it on to the other activities.
                controller.removeWallObservers();

                Intent intent3 = new Intent(this, MainActivity.class);
                intent3.putExtra("controller", controller);

                intent3.putExtra("wallName","2 FAG M/ 6 GLAS");
                intent3.putExtra("width", "80");
                intent3.putExtra("height", "180");
                intent3.putExtra("panelsInWidthIndex","1");
                intent3.putExtra("panelsInHeightIndex","2");
                intent3.putExtra("price","7390");

                startActivity(intent3);
            break;

            case 4:
                //Empty list of observers before serializing the object, so we can pass it on to the other activities.
                controller.removeWallObservers();

                Intent intent4 = new Intent(this, MainActivity.class);
                intent4.putExtra("controller", controller);

                intent4.putExtra("wallName","DØR M/ 6 GLAS");
                intent4.putExtra("width", "80");
                intent4.putExtra("height", "180");
                intent4.putExtra("panelsInWidthIndex","1");
                intent4.putExtra("panelsInHeightIndex","2");
                intent4.putExtra("hasDoor","true");
                intent4.putExtra("doorType","0");
                intent4.putExtra("hasHandle","true");
                intent4.putExtra("price","9890");

                startActivity(intent4);
            break;

            case 5:
                //Empty list of observers before serializing the object, so we can pass it on to the other activities.
                controller.removeWallObservers();

                Intent intent5 = new Intent(this, MainActivity.class);
                intent5.putExtra("controller", controller);

                intent5.putExtra("wallName","DOBBELTDØR M/ 12 GLAS");
                intent5.putExtra("width", "160");
                intent5.putExtra("height", "180");
                intent5.putExtra("panelsInWidthIndex","2");
                intent5.putExtra("panelsInHeightIndex","2");
                intent5.putExtra("hasDoor","true");
                intent5.putExtra("doorType","2");
                intent5.putExtra("hasHandle","true");
                intent5.putExtra("price","19780");

                startActivity(intent5);
            break;

            case 6:
                //Empty list of observers before serializing the object, so we can pass it on to the other activities.
                controller.removeWallObservers();

                Intent intent6 = new Intent(this, MainActivity.class);
                intent6.putExtra("controller", controller);

                intent6.putExtra("wallName","SKYDEDØR M/ 6 GLAS");
                intent6.putExtra("width", "80");
                intent6.putExtra("height", "180");
                intent6.putExtra("panelsInWidthIndex","1");
                intent6.putExtra("panelsInHeightIndex","2");
                intent6.putExtra("hasDoor","true");
                intent6.putExtra("doorType","4");
                intent6.putExtra("hasHandle","true");
                intent6.putExtra("price","10490");

                startActivity(intent6);
            break;

            case 7:
                //Empty list of observers before serializing the object, so we can pass it on to the other activities.
                controller.removeWallObservers();

                Intent intent7 = new Intent(this, MainActivity.class);
                intent7.putExtra("controller", controller);

                intent7.putExtra("wallName","3 FAG M/ 12 GLAS M/ ENKELTDØR");
                intent7.putExtra("width", "75");
                intent7.putExtra("height", "180");
                intent7.putExtra("panelsInWidthIndex","1");
                intent7.putExtra("panelsInHeightIndex","3");
                intent7.putExtra("hasDoor","true");
                intent7.putExtra("doorType","0");
                intent7.putExtra("hasHandle","true");
                intent7.putExtra("price","17275");

                startActivity(intent7);
            break;

            case 8:
                //Empty list of observers before serializing the object, so we can pass it on to the other activities.
                controller.removeWallObservers();

                Intent intent8 = new Intent(this, MainActivity.class);
                intent8.putExtra("controller", controller);

                intent8.putExtra("wallName","4 FAG M/ 16 GLAS M/ DOBBELTDØR");
                intent8.putExtra("width", "160");
                intent8.putExtra("height", "180");
                intent8.putExtra("panelsInWidthIndex","2");
                intent8.putExtra("panelsInHeightIndex","3");
                intent8.putExtra("hasDoor","true");
                intent8.putExtra("doorType","2");
                intent8.putExtra("hasHandle","true");
                intent8.putExtra("price","34550");

                startActivity(intent8);
            break;

            case 9:
                //Empty list of observers before serializing the object, so we can pass it on to the other activities.
                controller.removeWallObservers();

                Intent intent9 = new Intent(this, MainActivity.class);
                intent9.putExtra("controller", controller);

                intent9.putExtra("wallName","5 FAG M/ 20 GLAS M/ ENKELTDØR");
                intent9.putExtra("width", "180");
                intent9.putExtra("height", "200");
                intent9.putExtra("panelsInWidthIndex","4");
                intent9.putExtra("panelsInHeightIndex","2");
                intent9.putExtra("hasDoor","true");
                intent9.putExtra("doorType","0");
                intent9.putExtra("hasHandle","true");
                intent9.putExtra("price","27125");

                startActivity(intent9);
            break;

            case 10:
                //Empty list of observers before serializing the object, so we can pass it on to the other activities.
                controller.removeWallObservers();

                Intent intent10 = new Intent(this, MainActivity.class);
                intent10.putExtra("controller", controller);

                intent10.putExtra("wallName","6 FAG M/ 24 GLAS M/ ENKELTDØR");
                intent10.putExtra("width", "240");
                intent10.putExtra("height", "200");
                intent10.putExtra("panelsInWidthIndex","5");
                intent10.putExtra("panelsInHeightIndex","2");
                intent10.putExtra("hasDoor","true");
                intent10.putExtra("doorType","0");
                intent10.putExtra("hasHandle","true");
                intent10.putExtra("price","32050");

                startActivity(intent10);
            break;

        }


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
        if (itemId == R.id.button_menu_preview_page) {
            Intent intent = new Intent(this, PreviewOrderActivity.class);
            intent.putExtra("controller", controller);
            startActivity(intent);
        }
        if (itemId == R.id.button_menu_katalog) {
            Intent intent = new Intent(this, CatalogueActivity.class);
            intent.putExtra("controller", controller);
            startActivity(intent);
        }
        if (itemId == R.id.button_menu_kontakt) {
            Intent intent = new Intent(this, ContactActivity.class);
            intent.putExtra("controller", controller);
            intent.putExtra("URL", "https://www.new-yorker.dk/kontakt/");
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }



}