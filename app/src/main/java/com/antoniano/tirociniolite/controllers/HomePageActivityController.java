package com.antoniano.tirociniolite.controllers;

import android.content.Intent;
import android.net.Uri;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.antoniano.tirociniolite.R;
import com.antoniano.tirociniolite.exceptions.NoInternetConnectionException;
import com.antoniano.tirociniolite.factories.ARScannerFactory;
import com.antoniano.tirociniolite.interfaces.ARScanner;
import com.antoniano.tirociniolite.utils.ConfigFileReader;
import com.antoniano.tirociniolite.utils.MusicPlayer;
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
        setListenerOnButtonSitoWeb(homePageActivity.getButtonSitoWeb());
        setListenerOnButtonMappa(homePageActivity.getButtonMappa());
        setListenerOnLottieAnimation(homePageActivity.getLottieAnimationView());
    }

    private void setListenerOnButtonMappa(Button buttonMappa) {
        buttonMappa.setOnClickListener(view -> {
            String location = Uri.encode("Fondazione Istituto Antoniano");
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
            homePageActivity.startActivity(intent);
        });
    }

    private void setListenerOnButtonSitoWeb(Button buttonSitoWeb) {
        buttonSitoWeb.setOnClickListener(view -> {
            String url = "https://www.istitutoantoniano.it";
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            homePageActivity.startActivity(browserIntent);
        });
    }

    private void setListenerOnButtonScan(Button buttonScan) {
        buttonScan.setOnClickListener(view -> {
            arScannerFactory = ARScannerFactory.getInstance();
            String technology = ConfigFileReader.getProperty("ar_scanner_technology", view.getContext());
            arScanner = arScannerFactory.getARScanner(technology);
            try {
                arScanner.scan(view.getContext());
            } catch (NoInternetConnectionException e) {
                MusicPlayer.play(homePageActivity.getApplicationContext(), R.raw.not_connected);
            }
        });
    }

    private void setListenerOnLottieAnimation(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setOnClickListener(view -> MusicPlayer.play(homePageActivity.getApplicationContext(), R.raw.tutorial));
    }

    public void play(int resId) {
        MusicPlayer.play(homePageActivity.getApplicationContext(), resId);
    }

    public void stop() {
        MusicPlayer.stopPlayer();
    }
}
