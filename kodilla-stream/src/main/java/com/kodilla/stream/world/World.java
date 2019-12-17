package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {
    ArrayList<Continent> world = new ArrayList<>();

    public void add(Continent continent) {
        world.add(continent);
    }

    public BigDecimal getPeopleQuantity() {
        BigDecimal worldPopullation = world.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        return worldPopullation;
    }
}

