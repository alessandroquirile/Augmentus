package com.antoniano.tirociniolite.views;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.antoniano.tirociniolite.R;
import com.antoniano.tirociniolite.controllers.MainActivityController;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewComponents();
        initController();
    }

    public void initViewComponents() {
        button = findViewById(R.id.button);
    }

    public void initController() {
        MainActivityController mainActivityController = new MainActivityController(this);
        mainActivityController.setListeners();
    }

    public Button getButton() {
        return button;
    }
}