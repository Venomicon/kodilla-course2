package com.kodilla.stream.world;

import java.math.*;

public final class Country {
    private final int population;

    public Country(int population) {
        this.population = population;
    }

    public BigDecimal getPeopleQuantity() {
        BigDecimal quantity = new BigDecimal(population);
        return quantity;
    }
}
