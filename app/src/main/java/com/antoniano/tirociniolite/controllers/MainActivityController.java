package com.antoniano.tirociniolite.controllers;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.antoniano.tirociniolite.factories.ARScannerFactory;
import com.antoniano.tirociniolite.interfaces.ARScanner;
import com.antoniano.tirociniolite.utils.ConfigFileReader;
import com.antoniano.tirociniolite.views.MainActivity;

public class MainActivityController {

    private final MainActivity mainActivity;
    private ARScannerFactory arScannerFactory;
    private ARScanner arScanner;

    public MainActivityController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        /*SharedPreferences sharedPreferences = mainActivity.getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE);
        saveData(sharedPreferences);*/
    }

    public void setListeners() {
        mainActivity.getButton().setOnClickListener(view -> {
            arScannerFactory = ARScannerFactory.getInstance();
            String technology = ConfigFileReader.getProperty("ar_scanner_technology", view.getContext());
            arScanner = arScannerFactory.getARScanner(technology);
            arScanner.scan(view.getContext());
            //retrieveData();
        });
    }

    private void saveData(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("STRING_KEY", "CIAOOOO");
        editor.apply();
    }

    private void retrieveData() {
        SharedPreferences sharedPreferences = mainActivity.getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE);
        String savedString = sharedPreferences.getString("STRING_KEY", null);
        Toast.makeText(mainActivity, savedString, Toast.LENGTH_SHORT).show();
    }
}
