package com.antoniano.tirociniolite.controllers;

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
        homePageActivity.getButtonScan().setOnClickListener(view -> {
            arScannerFactory = ARScannerFactory.getInstance();
            String technology = ConfigFileReader.getProperty("ar_scanner_technology", view.getContext());
            arScanner = arScannerFactory.getARScanner(technology);
            arScanner.scan(view.getContext());
        });
    }
}
