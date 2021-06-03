package com.antoniano.tirociniolite.controllers;

import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.TextView;

import com.antoniano.tirociniolite.factories.ARScannerFactory;
import com.antoniano.tirociniolite.interfaces.ARScanner;
import com.antoniano.tirociniolite.utils.ConfigFileReader;
import com.antoniano.tirociniolite.views.HomePageActivity;

public class HomePageActivityController {

    private final HomePageActivity homePageActivity;
    private ARScannerFactory arScannerFactory;
    private ARScanner arScanner;

    public HomePageActivityController(HomePageActivity homePageActivity) {
        this.homePageActivity = homePageActivity;
    }

    public void setListeners() {
        setListenerOnButtonScan(homePageActivity.getButtonScan());
        setListenerOnTextViewFondazione(homePageActivity.getTextViewFondazione());
    }

    private void setListenerOnButtonScan(Button buttonScan) {
        buttonScan.setOnClickListener(view -> {
            arScannerFactory = ARScannerFactory.getInstance();
            String technology = ConfigFileReader.getProperty("ar_scanner_technology", view.getContext());
            arScanner = arScannerFactory.getARScanner(technology);
            arScanner.scan(view.getContext());
        });
    }

    private void setListenerOnTextViewFondazione(TextView textViewFondazione) {
        textViewFondazione.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:40.822860,14.356440?q=40.822860,14.356440(Label+Name)"));
            homePageActivity.startActivity(intent);
        });
    }
}
