package com.antoniano.tirociniolite.controllers;

import android.content.Intent;

import com.antoniano.tirociniolite.utils.MusicPlayer;
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
            stop();
        });
    }

    public void play(int resId) {
        MusicPlayer.play(welcomePageActivity.getApplicationContext(), resId);
    }

    public void stop() {
        MusicPlayer.stopPlayer();
    }
}
