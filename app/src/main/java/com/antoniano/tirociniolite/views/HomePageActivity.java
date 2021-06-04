package com.antoniano.tirociniolite.views;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.antoniano.tirociniolite.R;
import com.antoniano.tirociniolite.controllers.HomePageActivityController;

public class HomePageActivity extends AppCompatActivity {

    private Button buttonScan;
    private Button buttonSitoWeb;
    private Button buttonMappa;
    private LottieAnimationView lottieAnimationView;
    private HomePageActivityController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        initViewComponents();
        initController();
        controller.playAudio(R.raw.tutorial);
    }

    public void initViewComponents() {
        buttonScan = findViewById(R.id.button_scan);
        buttonSitoWeb = findViewById(R.id.button_sito_web);
        buttonMappa = findViewById(R.id.button_mappa);
        lottieAnimationView = findViewById(R.id.lottie_animation_view);
    }

    public void initController() {
        controller = new HomePageActivityController(this);
        controller.setListeners();
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

    public LottieAnimationView getLottieAnimationView() {
        return lottieAnimationView;
    }
}