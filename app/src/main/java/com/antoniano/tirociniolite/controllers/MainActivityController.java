    package com.antoniano.tirociniolite.controllers;

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
    }

    public void setListeners() {
        mainActivity.getButton().setOnClickListener(view -> {
            arScannerFactory = ARScannerFactory.getInstance();
            String technology = ConfigFileReader.getProperty("ar_scanner_technology", view.getContext());
            arScanner = arScannerFactory.getARScanner(technology);
            arScanner.scan(view.getContext());
        });
    }
}
