package com.antoniano.tirociniolite.views;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.antoniano.tirociniolite.R;
import com.antoniano.tirociniolite.controllers.HomePageActivityController;

public class HomePageActivity extends AppCompatActivity {

    private Button buttonScan;
    private TextView textViewFondazione;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        initViewComponents();
        initController();
    }

    public void initViewComponents() {
        buttonScan = findViewById(R.id.button_scan);
        textViewFondazione = findViewById(R.id.text_view_fondazione);
    }

    public void initController() {
        HomePageActivityController homePageActivityController = new HomePageActivityController(this);
        homePageActivityController.setListeners();
    }

    public Button getButtonScan() {
        return buttonScan;
    }

    public TextView getTextViewFondazione() {
        return textViewFondazione;
    }
}