package com.antoniano.tirociniolite.utils;

import android.content.Context;
import android.media.MediaPlayer;

public class MusicPlayer extends MediaPlayer {

    private static MediaPlayer player;

    public static void play(Context context, int resId) {
        if (player == null) {
            player = MediaPlayer.create(context, resId);
            player.setOnCompletionListener(mp -> stopPlayer());
        }
        player.start();
    }

    public static void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    public void pause() {
        if (player != null)
            player.pause();
    }
}
