package com.antoniano.tirociniolite.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

    public static String getProperty(String key, Context context) {
        Properties properties;
        try {
            properties = new Properties();
            InputStream inputStream = context.getAssets().open("config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }
}
