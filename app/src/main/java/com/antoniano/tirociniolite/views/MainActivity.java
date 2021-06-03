package com.antoniano.tirociniolite.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.antoniano.tirociniolite.R;
import com.antoniano.tirociniolite.controllers.MainActivityController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initController();
    }

    private void initController() {
        MainActivityController controller = new MainActivityController(this);
        controller.bootProperActivity();
    }
}