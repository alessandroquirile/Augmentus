package com.antoniano.tirociniolite.implementations;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.antoniano.tirociniolite.interfaces.MapService;

public class MapService_GoogleMaps implements MapService {
    @Override
    public void openMapAt(String location, Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
        context.startActivity(intent);
    }
}
