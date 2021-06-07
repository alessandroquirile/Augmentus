package com.antoniano.tirociniolite.implementations;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import com.antoniano.tirociniolite.exceptions.NoInternetConnectionException;
import com.antoniano.tirociniolite.interfaces.ARScanner;

public class ARScanner_UniteAR implements ARScanner {

    @Override
    public void scan(Context context) throws NoInternetConnectionException {
        String address = "https://web.unitear.com";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
        if (isConnected(context))
            context.startActivity(browserIntent);
        else
            throw new NoInternetConnectionException();
    }

    private boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI || activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE);
    }
}