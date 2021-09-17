package com.antoniano.tirociniolite.factories;

import com.antoniano.tirociniolite.exceptions.TechnologyNotSupportedYetException;
import com.antoniano.tirociniolite.implementations.MapService_GoogleMaps;
import com.antoniano.tirociniolite.interfaces.MapService;

public class MapServiceFactory {
    private static MapServiceFactory singletonInstance = null;

    private MapServiceFactory() {

    }

    public static synchronized MapServiceFactory getInstance() {
        if (singletonInstance == null)
            singletonInstance = new MapServiceFactory();
        return singletonInstance;
    }

    public MapService getMapService(String mapServiceTechnology) {
        if (mapServiceTechnology.equals("google_maps"))
            return new MapService_GoogleMaps();
        else
            throw new TechnologyNotSupportedYetException(mapServiceTechnology);
    }
}
