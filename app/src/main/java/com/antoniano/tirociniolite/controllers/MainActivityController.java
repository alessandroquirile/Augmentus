package com.antoniano.tirociniolite.controllers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.antoniano.tirociniolite.views.HomePageActivity;
import com.antoniano.tirociniolite.views.MainActivity;
import com.antoniano.tirociniolite.views.WelcomePageActivity;

public class MainActivityController {

    private final MainActivity mainActivity;

    public MainActivityController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void bootProperActivity() {
        SharedPreferences sharedPreferences = mainActivity.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean("firstTime", true)) {
            boot(WelcomePageActivity.class);
            sharedPreferences.edit().putBoolean("firstTime", false).apply();
        } else {
            boot(HomePageActivity.class);
        }
    }

    private void boot(Class<?> cls) {
        Intent intent = new Intent(mainActivity.getApplicationContext(), cls);
        mainActivity.startActivity(intent);
    }
}
