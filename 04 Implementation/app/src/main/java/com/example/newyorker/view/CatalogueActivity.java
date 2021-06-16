package com.example.newyorker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
        Button_select_wall.setBackgroundColor(getResources().getColor(R.color.grey));
        Button_select_wall.setEnabled(false);
    }

    public void enableNavigationButton(){
        Button_select_wall.setBackgroundColor(getResources().getColor(R.color.orange));
        Button_select_wall.setEnabled(true);
    }

    public void selectEtFag4Glas(View view) {
        clearImageHighlights();

        et_fag_4_glas.setClickable(false);
        et_fag_4_glas.setImageResource(R.mipmap.et_fag_m_4_glas_highlighted);

        enableNavigationButton();

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        controller.removeWallObservers();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("controller", controller);

        intent.putExtra("width", "40");
        intent.putExtra("height", "180");
        intent.putExtra("panelsInWidthIndex","0");
        intent.putExtra("panelsInHeightIndex","3");
        intent.putExtra("price","4925");

        startActivity(intent);


    }

    public void SelectToFag8Glas(View view) {
        clearImageHighlights();

        to_fag_8_glas.setClickable(false);
        to_fag_8_glas.setImageResource(R.mipmap.to_fag_m_8_glas_highlighted);

        enableNavigationButton();

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        controller.removeWallObservers();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("controller", controller);

        intent.putExtra("width", "80");
        intent.putExtra("height", "180");
        intent.putExtra("panelsInWidthIndex","1");
        intent.putExtra("panelsInHeightIndex","3");
        intent.putExtra("price","9850");

        startActivity(intent);
    }

    public void SelectToFag6Glas(View view) {
        clearImageHighlights();

        to_fag_6_glas.setClickable(false);
        to_fag_6_glas.setImageResource(R.mipmap.to_fag_m_6_glas_highlighted);

        enableNavigationButton();

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        controller.removeWallObservers();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("controller", controller);

        intent.putExtra("width", "80");
        intent.putExtra("height", "180");
        intent.putExtra("panelsInWidthIndex","1");
        intent.putExtra("panelsInHeightIndex","2");
        intent.putExtra("price","7390");

        startActivity(intent);
    }

    public void SelectDoer6Glas(View view) {
        clearImageHighlights();

        doer_6_glas.setClickable(false);
        doer_6_glas.setImageResource(R.mipmap.doer_m_6_glas_highlighted);

        enableNavigationButton();

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        controller.removeWallObservers();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("controller", controller);

        intent.putExtra("width", "80");
        intent.putExtra("height", "180");
        intent.putExtra("panelsInWidthIndex","1");
        intent.putExtra("panelsInHeightIndex","2");
        intent.putExtra("hasDoor","true");
        intent.putExtra("hasHandle","true");
        intent.putExtra("price","9890");

        startActivity(intent);
    }

    public void SelectDobbeltdoer12Glas(View view) {
        clearImageHighlights();

        dobbeltdoer_m_12_glas.setClickable(false);
        dobbeltdoer_m_12_glas.setImageResource(R.mipmap.dobbeltdoer_m_12_glas_highlighted);

        enableNavigationButton();

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        controller.removeWallObservers();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("controller", controller);

        intent.putExtra("width", "160");
        intent.putExtra("height", "180");
        intent.putExtra("panelsInWidthIndex","2");
        intent.putExtra("panelsInHeightIndex","2");
        intent.putExtra("hasDoor","true");
        intent.putExtra("hasHandle","true");
        intent.putExtra("price","19780");

        startActivity(intent);
    }

    public void SelectSkydedoer6Glas(View view) {
        clearImageHighlights();

        skydedoer_m_6_glas.setClickable(false);
        skydedoer_m_6_glas.setImageResource(R.mipmap.skydedoer_m_6_glas_highlighted);

        enableNavigationButton();
    }

    public void SelectTreFagEnkeltdoer12Glas(View view) {
        clearImageHighlights();

        tre_fag_m_enkeltdoer_m_12_glas.setClickable(false);
        tre_fag_m_enkeltdoer_m_12_glas.setImageResource(R.mipmap.tre_fag_m_12_glas_m_enkeltdoer_highlighted);

        enableNavigationButton();
    }

    public void SelectFireFagDobbeltdoer16Glas(View view) {
        clearImageHighlights();

        fire_fag_m_dobbeltdoer_m_16_glas.setClickable(false);
        fire_fag_m_dobbeltdoer_m_16_glas.setImageResource(R.mipmap.fire_fag_m_16_glas_m_dobbeltdoer_highlighted);

        enableNavigationButton();
    }

    public void SelectFemFagEnkeltdoer20Glas(View view) {
        clearImageHighlights();

        fem_fag_m_enkeltdoer_m_20_glas.setClickable(false);
        fem_fag_m_enkeltdoer_m_20_glas.setImageResource(R.mipmap.fem_fag_m_20_glas_m_enkeltdoer_highlighted);

        enableNavigationButton();
    }

    public void SelectSeksFagEnkeltdoer24Glas(View view) {
        clearImageHighlights();

        seks_fag_m_enkeltdoer_m_24_glas.setClickable(false);
        seks_fag_m_enkeltdoer_m_24_glas.setImageResource(R.mipmap.seks_fag_m_24_glas_m_enkeltdoer_highlighted);

        enableNavigationButton();
    }
}