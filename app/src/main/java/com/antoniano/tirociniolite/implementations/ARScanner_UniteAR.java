package com.antoniano.tirociniolite.implementations;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.widget.Toast;

import com.antoniano.tirociniolite.interfaces.ARScanner;

public class ARScanner_UniteAR implements ARScanner {

    @Override
    public void scan(Context context) {
        String address = "https://web.unitear.com";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
        if (isConnected(context))
            context.startActivity(browserIntent);
        else
            Toast.makeText(context, "Connettiti a internet", Toast.LENGTH_LONG).show();
    }

    private boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI || activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE);
    }
}