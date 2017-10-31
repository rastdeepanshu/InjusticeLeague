package com.injusticeleague.maps;

import org.junit.Test;

public class MapFactoryTest {

    @Test
    public void testGetMap() {
        MapFactory factory = new MapFactory();

        Map mountainMap = factory.getMap("mountain");
        Map seaMap = factory.getMap("sea");
        Map cityMap = factory.getMap("city");
        Map desertMap = factory.getMap("desert");

        assert(mountainMap instanceof MountainMap);
        assert(seaMap instanceof SeaMap);
        assert(cityMap instanceof CityMap);
        assert(desertMap instanceof DesertMap);
    }
}
