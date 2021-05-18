package com.antoniano.tirociniolite.implementations;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.antoniano.tirociniolite.interfaces.ARScanner;

public class ARScanner_UniteAR implements ARScanner {

    @Override
    public void scan(Context context) {
        String address = "https://web.unitear.com";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
        context.startActivity(browserIntent);
    }
}
