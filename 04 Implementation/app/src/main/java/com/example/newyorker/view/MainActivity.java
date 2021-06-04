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

    EditText heightInput;
    EditText widthInput;
    TextView textViewMainActivityPrice;

    TextView textview_height_exception;
    TextView textview_width_exception;

    TextView display_panel_height;
    TextView display_panel_width;
    TextView display_panel_count_height;
    TextView display_panel_count_width;

    SeekBar slider_height;
    SeekBar slider_width;

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

        controller.addWallDataObserver(new Observer() {
            @Override
            public void update() {
                textViewMainActivityPrice.setText(String.valueOf(controller.getWallPrice()));
            }
        });
    }

    private void initializeUIElements() {

        heightInput = findViewById(R.id.height_editText);
        widthInput = findViewById(R.id.width_editText);
        textViewMainActivityPrice = findViewById(R.id.textview_price_main_activity);
        textview_height_exception = findViewById(R.id.textview_height_exception);
        textview_width_exception = findViewById(R.id.textview_width_exception);

        slider_height = findViewById(R.id.slider_height);
        slider_width = findViewById(R.id.slider_width);

        display_panel_height = findViewById(R.id.display_panel_height);
        display_panel_width = findViewById(R.id.display_panel_width);
        display_panel_count_height = findViewById(R.id.display_panel_count_height);
        display_panel_count_width = findViewById(R.id.display_panel_count_width);

    }

    private void initializeListeners() {

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


        widthInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
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

        slider_height.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                display_panel_height.setText(Math.floor(controller.getWall(0).getFinalListOfPanelSizesHeight().get(slider_height.getProgress()) * 10.0) / 10.0 +" CM");
                int removeCommaFromDouble =  controller.getWall(0).getListOfPanelCountHeight().get(slider_height.getProgress()).intValue();
                display_panel_count_height.setText(String.valueOf(removeCommaFromDouble));
                if (!widthInput.getText().toString().isEmpty() && !heightInput.getText().toString().isEmpty()) {
                    controller.getWall(0).totalPanels(Integer.parseInt(display_panel_count_height.getText().toString()), Integer.parseInt(display_panel_count_width.getText().toString()));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        slider_width.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                display_panel_width.setText(Math.floor(controller.getWall(0).getFinalListOfPanelSizesWidth().get(slider_width.getProgress()) * 10.0) / 10.0 +" CM");
                int removeCommaFromDouble =  controller.getWall(0).getListOfPanelCountWidth().get(slider_width.getProgress()).intValue();
                display_panel_count_width.setText(String.valueOf(removeCommaFromDouble));
                if (!widthInput.getText().toString().isEmpty() && !heightInput.getText().toString().isEmpty()) {
                    controller.getWall(0).totalPanels(Integer.parseInt(display_panel_count_height.getText().toString()), Integer.parseInt(display_panel_count_width.getText().toString()));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void clearFocus() {
        heightInput.clearFocus();
        widthInput.clearFocus();
    }



    public void setUpSeekbarHeight(){

        int maxProgress = controller.getWall(0).getListOfPanelCountHeight().size();

        slider_height.setProgress(1);
        slider_height.setMax(maxProgress-1);

    }

    public void setUpSeekbarWidth(){

        int maxProgress = controller.getWall(0).getListOfPanelCountWidth().size();

        slider_width.setProgress(1);
        slider_width.setMax(maxProgress-1);

    }


    public void goToCustomizeOrder(View view) {

        clearFocus();

        //Empty list of observers before serializing the object, so we can pass it on to the other activities.
        controller.removeWallObservers();

        Intent intent = new Intent(this, CustomizeOrderActivity.class);
        intent.putExtra("controller", controller);
        startActivity(intent);
    }

}