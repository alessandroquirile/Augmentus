package com.antoniano.tirociniolite.views;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.antoniano.tirociniolite.R;
import com.antoniano.tirociniolite.controllers.HomePageActivityController;

public class HomePageActivity extends AppCompatActivity {

    private Button buttonScan;
    private Button buttonSitoWeb;
    private Button buttonMappa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        initViewComponents();
        initController();
    }

    public void initViewComponents() {
        buttonScan = findViewById(R.id.button_scan);
        buttonSitoWeb = findViewById(R.id.button_sito_web);
        buttonMappa = findViewById(R.id.button_mappa);
    }

    public void initController() {
        HomePageActivityController homePageActivityController = new HomePageActivityController(this);
        homePageActivityController.setListeners();
    }

    public Button getButtonScan() {
        return buttonScan;
    }

    public Button getButtonSitoWeb() {
        return buttonSitoWeb;
    }

    public Button getButtonMappa() {
        return buttonMappa;
    }
}