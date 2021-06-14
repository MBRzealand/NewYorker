package com.example.newyorker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.newyorker.R;

import static com.example.newyorker.R.color.dark_grey;

public class CatalogueActivity extends AppCompatActivity {

    ImageView et_fag_4_glas;
    ImageView to_fag_8_glas;
    ImageView to_fag_6_glas;
    ImageView doer_6_glas;
    Button Button_select_wall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue);
        InitializeUIElements();
    }

    public void InitializeUIElements(){

        et_fag_4_glas = findViewById(R.id.et_fag_4_glas);
        to_fag_8_glas = findViewById(R.id.to_fag_8_glas);
        to_fag_6_glas = findViewById(R.id.to_fag_6_glas);
        doer_6_glas = findViewById(R.id.doer_m_6_glas);
        Button_select_wall = findViewById(R.id.Button_select_wall);

        Button_select_wall.setBackgroundColor(getResources().getColor(R.color.grey));
        Button_select_wall.setEnabled(false);

    }


    public void clearImageHighlights(){

        et_fag_4_glas.setImageResource(R.mipmap.et_fag_m_4_glas);
        to_fag_8_glas.setImageResource(R.mipmap.to_fag_m_8_glas);
        to_fag_6_glas.setImageResource(R.mipmap.to_fag_m_6_glas);
        doer_6_glas.setImageResource(R.mipmap.doer_m_6_glas);
    }

    public void enableNavigationButton(){
        Button_select_wall.setBackgroundColor(getResources().getColor(R.color.orange));
        Button_select_wall.setEnabled(true);
    }

    public void selectEtFag4Glas(View view) {
        clearImageHighlights();
        et_fag_4_glas.setImageResource(R.mipmap.et_fag_m_4_glas_highlighted);

        enableNavigationButton();
    }

    public void SelectToFag8Glas(View view) {
        clearImageHighlights();
        to_fag_8_glas.setImageResource(R.mipmap.to_fag_m_8_glas_highlighted);

        enableNavigationButton();
    }

    public void SelectToFag6Glas(View view) {
        clearImageHighlights();
        to_fag_6_glas.setImageResource(R.mipmap.to_fag_m_6_glas_highlighted);

        enableNavigationButton();
    }

    public void SelectDoer6Glas(View view) {
        clearImageHighlights();
        doer_6_glas.setImageResource(R.mipmap.doer_m_6_glas_highlighted);

        enableNavigationButton();
    }
}