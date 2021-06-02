package com.antoniano.tirociniolite.controllers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.antoniano.tirociniolite.views.HomePageActivity;
import com.antoniano.tirociniolite.views.WelcomePageActivity;

public class WelcomePageActivityController {

    private final WelcomePageActivity welcomePageActivity;

    public WelcomePageActivityController(WelcomePageActivity welcomePageActivity) {
        this.welcomePageActivity = welcomePageActivity;
    }

    public void setListeners() {
        welcomePageActivity.getButtonIniziamo().setOnClickListener(view -> {
            Intent intent = new Intent(welcomePageActivity.getApplicationContext(), HomePageActivity.class);
            welcomePageActivity.startActivity(intent);
        });
    }

    public void bootProperActivity() {
        SharedPreferences sharedPreferences = welcomePageActivity.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        String firstTime = sharedPreferences.getString("FirstTime", "");
        if (firstTime.equals("Yes"))
            bootHomePageActivity();
        else
            update(sharedPreferences);
    }

    private void bootHomePageActivity() {
        Intent intent = new Intent(welcomePageActivity.getApplicationContext(), HomePageActivity.class);
        welcomePageActivity.startActivity(intent);
    }

    private void update(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("FirstTime", "Yes");
        editor.apply();
    }
}
