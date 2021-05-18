package com.antoniano.tirociniolite.factories;

import com.antoniano.tirociniolite.exceptions.TechnologyNotSupportedYetException;
import com.antoniano.tirociniolite.implementations.ARScanner_UniteAR;
import com.antoniano.tirociniolite.interfaces.ARScanner;

public class ARScannerFactory {

    private static ARScannerFactory singletonInstance = null;

    private ARScannerFactory() {

    }

    public static synchronized ARScannerFactory getInstance() {
        if (singletonInstance == null)
            singletonInstance = new ARScannerFactory();
        return singletonInstance;
    }

    public ARScanner getARScanner(String scannerTechnology) {
        if (scannerTechnology.equals("unite_ar"))
            return new ARScanner_UniteAR();
        else
            throw new TechnologyNotSupportedYetException(scannerTechnology);
    }
}
