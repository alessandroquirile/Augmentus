package com.antoniano.tirociniolite.interfaces;

import android.content.Context;

import com.antoniano.tirociniolite.exceptions.NoInternetConnectionException;

public interface ARScanner {
    void scan(Context context) throws NoInternetConnectionException;
}
