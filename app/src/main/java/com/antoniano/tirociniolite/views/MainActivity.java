package com.antoniano.tirociniolite.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.antoniano.tirociniolite.R;
import com.antoniano.tirociniolite.controllers.MainActivityController;

public class MainActivity extends AppCompatActivity {

    private MainActivityController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initController();
        controller.bootProperActivity();
    }

    private void initController() {
        controller = new MainActivityController(this);
    }
}