package com.antoniano.tirociniolite.controllers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.antoniano.tirociniolite.views.BootActivity;
import com.antoniano.tirociniolite.views.HomePageActivity;
import com.antoniano.tirociniolite.views.WelcomePageActivity;

public class BootActivityController {

    private final BootActivity bootActivity;

    public BootActivityController(BootActivity bootActivity) {
        this.bootActivity = bootActivity;
    }

    public void bootProperActivity() {
        SharedPreferences sharedPreferences = bootActivity.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean("firstTime", true)) {
            boot(WelcomePageActivity.class);
            sharedPreferences.edit().putBoolean("firstTime", false).apply();
        } else {
            boot(HomePageActivity.class);
        }
    }

    private void boot(Class<?> cls) {
        Intent intent = new Intent(bootActivity.getApplicationContext(), cls);
        bootActivity.startActivity(intent);
    }
}
