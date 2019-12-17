package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {
    ArrayList<Country> countries = new ArrayList<>();

    public void add(Country country) {
        countries.add(country);
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }
}
