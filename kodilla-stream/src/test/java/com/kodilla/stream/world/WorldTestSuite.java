package com.kodilla.stream.world;

import org.junit.*;

import java.math.BigDecimal;
import java.util.*;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        Country poland = new Country(38000000);
        Country germany = new Country(72000000);
        Country france = new Country(54000000);
        Continent europe = new Continent();
        europe.add(poland);
        europe.add(germany);
        europe.add(france);

        Country china = new Country(120000000);
        Country japan = new Country(100000000);
        Country india = new Country(183000000);
        Continent asia = new Continent();
        asia.add(china);
        asia.add(japan);
        asia.add(india);

        Country usa = new Country(150000000);
        Country canada = new Country(78000000);
        Country mexico = new Country(65000000);
        Continent america = new Continent();
        america.add(usa);
        america.add(canada);
        america.add(mexico);

        World world = new World();
        world.add(europe);
        world.add(asia);
        world.add(america);

        //When
        BigDecimal population = world.getPeopleQuantity();

        //Then
        BigDecimal expected = new BigDecimal("860000000");
        Assert.assertEquals(expected, population);
    }
}
