package com.antoniano.tirociniolite.views;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.antoniano.tirociniolite.R;
import com.antoniano.tirociniolite.controllers.WelcomePageActivityController;

public class WelcomePageActivity extends AppCompatActivity {

    private Button buttonIniziamo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        initViewComponents();
        initController();
    }

    private void initViewComponents() {
        buttonIniziamo = findViewById(R.id.button_iniziamo);
    }

    private void initController() {
        WelcomePageActivityController controller = new WelcomePageActivityController(this);
        controller.setListeners();
        controller.bootProperActivity();
    }

    public Button getButtonIniziamo() {
        return buttonIniziamo;
    }
}