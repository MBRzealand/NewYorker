package com.example.newyorker.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.newyorker.R;
import com.example.newyorker.controller.NYBuilderController;
import com.example.newyorker.model.Observer;


public class MainActivity extends AppCompatActivity {

    EditText nameInput;
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

    NYBuilderController controller;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        initializeUIElements();
        initializeListeners();



            Intent intent = getIntent();
            controller = (NYBuilderController) intent.getSerializableExtra("controller");

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

        if(intent.getStringExtra("wallName") != null){
            controller.getCurrentWall().setWallName(intent.getStringExtra("wallName"));
            nameInput.setText(controller.getCurrentWall().getWallName());
        }

        if(intent.getStringExtra("height") != null){

            controller.setWallHeight(intent.getStringExtra("height"));
            heightInput.setText(String.valueOf(controller.getCurrentWall().getWallHeight()));

            controller.getCurrentWall().calculateWindowPanelsHeight(controller.getCurrentWall().getWallHeight());
            setUpSeekbarHeight();
            slider_height.setProgress(Integer.parseInt(intent.getStringExtra("panelsInHeightIndex")));

        }

        if(intent.getStringExtra("width") != null){

            controller.setWallWidth(intent.getStringExtra("width"));
            widthInput.setText(String.valueOf(controller.getCurrentWall().getWallWidth()));

            controller.getCurrentWall().calculateWindowPanelsWidth(controller.getCurrentWall().getWallWidth());
            setUpSeekbarWidth();
            slider_width.setProgress(Integer.parseInt(intent.getStringExtra("panelsInWidthIndex")));

        }

        if(intent.getStringExtra("price") != null){
            controller.getCurrentWall().setWallPrice(Double.parseDouble(intent.getStringExtra("price")));
            textViewMainActivityPrice.setText(String.valueOf(controller.getCurrentWall().getWallPrice()));
        }

        if(intent.getStringExtra("hasDoor") != null){
            controller.getCurrentWall().setHasDoor(Boolean.parseBoolean(intent.getStringExtra("hasDoor")));
            controller.getCurrentWall().setHasHandle(Boolean.parseBoolean(intent.getStringExtra("hasHandle")));
        }

        if(intent.getStringExtra("doorType") != null){
            controller.getCurrentWall().setDoorType(intent.getStringExtra("doorType"));
        }




    }

    private void initializeUIElements() {

        nameInput = findViewById(R.id.name_editText);
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

        slider_width.setEnabled(false);
        slider_height.setEnabled(false);

    }

    private void initializeListeners() {

        nameInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (!hasFocus) {
                    controller.getCurrentWall().setWallName(nameInput.getText().toString());
                }

            }
        });


        widthInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if (widthInput.getText() != null) {

                    if (!hasFocus) {
                        textview_width_exception.setText(controller.setWallWidth(widthInput.getText().toString()));
                        if (!textview_width_exception.getText().equals("Mangler bredde") || !textview_width_exception.getText().equals("Der kan ikke stå bogstaver i bredden")) {
                            controller.getCurrentWall().calculateWindowPanelsWidth(controller.getCurrentWall().getWallWidth());
                            setUpSeekbarWidth();
                        }
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
                        if (!textview_height_exception.getText().equals("Mangler højde") || !textview_height_exception.getText().equals("Der kan ikke stå bogstaver i højden")) {
                            controller.getCurrentWall().calculateWindowPanelsHeight(controller.getCurrentWall().getWallHeight());
                            setUpSeekbarHeight();
                        }
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
                if (!textview_width_exception.getText().equals("Mangler bredde") || !textview_width_exception.getText().equals("Der kan ikke stå bogstaver i bredden")) {
                    display_panel_width.setText(Math.floor(controller.getCurrentWall().getFinalListOfPanelSizesWidth().get(slider_width.getProgress()) * 10.0) / 10.0 +" CM");
                    int removeCommaFromDouble =  controller.getCurrentWall().getListOfPanelCountWidth().get(slider_width.getProgress()).intValue();
                    display_panel_count_width.setText(String.valueOf(removeCommaFromDouble));
                    if (!heightInput.getText().toString().isEmpty() && !widthInput.getText().toString().isEmpty()) {
                        controller.getCurrentWall().totalPanels(Integer.parseInt(display_panel_count_width.getText().toString()), Integer.parseInt(display_panel_count_height.getText().toString()));
                    }
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
                if (!textview_height_exception.getText().equals("Mangler højde") || !textview_height_exception.getText().equals("Der kan ikke stå bogstaver i højden")) {
                    display_panel_height.setText(Math.floor(controller.getCurrentWall().getFinalListOfPanelSizesHeight().get(slider_height.getProgress()) * 10.0) / 10.0 +" CM");
                    int removeCommaFromDouble =  controller.getCurrentWall().getListOfPanelCountHeight().get(slider_height.getProgress()).intValue();
                    display_panel_count_height.setText(String.valueOf(removeCommaFromDouble));
                    if (!heightInput.getText().toString().isEmpty() && !widthInput.getText().toString().isEmpty()) {
                        controller.getCurrentWall().totalPanels(Integer.parseInt(display_panel_count_width.getText().toString()), Integer.parseInt(display_panel_count_height.getText().toString()));
                    }
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

        if(controller.getCurrentWall().getWallWidth() != 0) {
            slider_width.setEnabled(true);
            int maxProgress = controller.getCurrentWall().getListOfPanelCountWidth().size();

            slider_width.setMax(maxProgress - 1);
        }
    }

    public void setUpSeekbarHeight(){
        if(controller.getCurrentWall().getWallHeight() != 0) {
            slider_height.setEnabled(true);
            int maxProgress = controller.getCurrentWall().getListOfPanelCountHeight().size();

            slider_height.setMax(maxProgress - 1);
        }
    }


    public void goToCustomizeOrder(View view) {

        clearFocus();

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        controller.removeWallObservers();

        Intent intent = new Intent(this, CustomizeOrderActivity.class);
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
        if (itemId == R.id.button_menu_preview_page) {
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
}
