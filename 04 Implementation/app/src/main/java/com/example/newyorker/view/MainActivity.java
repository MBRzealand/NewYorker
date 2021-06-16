package com.example.newyorker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.newyorker.R;
import com.example.newyorker.controller.NYBuilderController;
import com.example.newyorker.model.Observer;


public class MainActivity extends AppCompatActivity {

    EditText widthInput;
    EditText heightInput;
    TextView textViewMainActivityPrice;

    TextView textview_width_exception;
    TextView textview_height_exception;

    TextView display_panel_width;
    TextView display_panel_height;
    TextView display_panel_count_width;
    TextView display_panel_count_height;

    SeekBar slider_width;
    SeekBar slider_height;

    InputMethodManager imm;

    NYBuilderController controller = new NYBuilderController();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        initializeUIElements();
        initializeListeners();

        controller.newWall();

        getAllExtras();

        controller.addWallDataObserver(new Observer() {
            @Override
            public void update() {
                textViewMainActivityPrice.setText(String.valueOf(controller.getWallPrice()));
            }
        });
    }

    private void getAllExtras(){

        Intent intent = getIntent();

        if(intent.getStringExtra("height") != null){

            controller.setWallHeight(intent.getStringExtra("height"));
            heightInput.setText(String.valueOf(controller.getWall(0).getWallHeight()));

            controller.getWall(0).calculateWindowPanelsHeight(controller.getWall(0).getWallHeight());
            setUpSeekbarHeight();
            slider_height.setProgress(Integer.parseInt(intent.getStringExtra("panelsInHeightIndex")));

        }

        if(intent.getStringExtra("width") != null){

            controller.setWallWidth(intent.getStringExtra("width"));
            widthInput.setText(String.valueOf(controller.getWall(0).getWallWidth()));

            controller.getWall(0).calculateWindowPanelsWidth(controller.getWall(0).getWallWidth());
            setUpSeekbarWidth();
            slider_width.setProgress(Integer.parseInt(intent.getStringExtra("panelsInWidthIndex")));

        }

        if(intent.getStringExtra("price") != null){
            controller.getWall(0).setWallPrice(Double.parseDouble(intent.getStringExtra("price")));
            textViewMainActivityPrice.setText(String.valueOf(controller.getWall(0).getWallPrice()));
        }

        if(intent.getStringExtra("hasDoor") != null){
            controller.getWall(0).setHasDoor(Boolean.parseBoolean(intent.getStringExtra("hasDoor")));
            controller.getWall(0).setHasHandle(Boolean.parseBoolean(intent.getStringExtra("hasHandle")));
        }

        if(intent.getStringExtra("doorType") != null){
            controller.getWall(0).setDoorType(intent.getStringExtra("doorType"));
        }




    }

    private void initializeUIElements() {

        widthInput = findViewById(R.id.width_editText);
        heightInput = findViewById(R.id.height_editText);
        textViewMainActivityPrice = findViewById(R.id.textview_price_main_activity);
        textview_width_exception = findViewById(R.id.textview_width_exception);
        textview_height_exception = findViewById(R.id.textview_height_exception);

        slider_width = findViewById(R.id.slider_width);
        slider_height = findViewById(R.id.slider_height);

        display_panel_width = findViewById(R.id.display_panel_width);
        display_panel_height = findViewById(R.id.display_panel_height);
        display_panel_count_width = findViewById(R.id.display_panel_count_width);
        display_panel_count_height = findViewById(R.id.display_panel_count_height);

    }

    private void initializeListeners() {

        widthInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if (widthInput.getText() != null) {

                    if (!hasFocus) {
                        textview_width_exception.setText(controller.setWallWidth(widthInput.getText().toString()));
                        controller.getWall(0).calculateWindowPanelsWidth(controller.getWall(0).getWallWidth());
                        setUpSeekbarWidth();
                    }

                    controller.calculateWallPrice();
                }

            }
        });

        heightInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if (heightInput.getText() != null) {
                    if (!hasFocus) {
                        textview_height_exception.setText(controller.setWallHeight(heightInput.getText().toString()));
                        controller.getWall(0).calculateWindowPanelsHeight(controller.getWall(0).getWallHeight());
                        setUpSeekbarHeight();
                    }

                    controller.calculateWallPrice();
                }

            }
        });


        heightInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    v.clearFocus();

                    return true;
                }
                return false;
            }
        });

        slider_width.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                display_panel_width.setText(Math.floor(controller.getWall(0).getFinalListOfPanelSizesWidth().get(slider_width.getProgress()) * 10.0) / 10.0 +" CM");
                int removeCommaFromDouble =  controller.getWall(0).getListOfPanelCountWidth().get(slider_width.getProgress()).intValue();
                display_panel_count_width.setText(String.valueOf(removeCommaFromDouble));
                if (!heightInput.getText().toString().isEmpty() && !widthInput.getText().toString().isEmpty()) {
                    controller.getWall(0).totalPanels(Integer.parseInt(display_panel_count_width.getText().toString()), Integer.parseInt(display_panel_count_height.getText().toString()));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                slider_width.requestFocus();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                slider_width.clearFocus();
            }
        });

        slider_height.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                display_panel_height.setText(Math.floor(controller.getWall(0).getFinalListOfPanelSizesHeight().get(slider_height.getProgress()) * 10.0) / 10.0 +" CM");
                int removeCommaFromDouble =  controller.getWall(0).getListOfPanelCountHeight().get(slider_height.getProgress()).intValue();
                display_panel_count_height.setText(String.valueOf(removeCommaFromDouble));
                if (!heightInput.getText().toString().isEmpty() && !widthInput.getText().toString().isEmpty()) {
                    controller.getWall(0).totalPanels(Integer.parseInt(display_panel_count_width.getText().toString()), Integer.parseInt(display_panel_count_height.getText().toString()));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                slider_height.requestFocus();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                slider_height.clearFocus();
            }
        });


    }

    public void clearFocus() {
        widthInput.clearFocus();
        heightInput.clearFocus();
    }



    public void setUpSeekbarWidth(){

        int maxProgress = controller.getWall(0).getListOfPanelCountWidth().size();

        slider_width.setMax(maxProgress-1);

    }

    public void setUpSeekbarHeight(){

        int maxProgress = controller.getWall(0).getListOfPanelCountHeight().size();

        slider_height.setMax(maxProgress-1);

    }


    public void goToCustomizeOrder(View view) {

        clearFocus();

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        controller.removeWallObservers();

        Intent intent = new Intent(this, CustomizeOrderActivity.class);
        intent.putExtra("controller", controller);
        startActivity(intent);
    }

    public void goToCatalogue(View view) {    // delete this shit

        clearFocus();

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        controller.removeWallObservers();

        Intent intent = new Intent(this, CatalogueActivity.class);
        intent.putExtra("controller", controller);
        startActivity(intent);

    }
}