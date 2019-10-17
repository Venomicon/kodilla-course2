package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private static final String ROLL = "roll";
    private static final String SESAME = "sesame";
    private static final String STANDARD = "standard";
    private static final String THOUSAND = "thousand island";
    private static final String BBQ = "barbecue";
    private static final String SALAD = "salad";
    private static final String ONION = "onion";
    private static final String BACON = "bacon";
    private static final String PICKLE = "pickles";
    private static final String CHILI = "chili peppers";
    private static final String MUSHROOM = "mushrooms";
    private static final String SHRIMP = "shrimps";
    private static final String CHEESE = "cheese";

    private final String bun;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    private Bigmac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public static class BigmacBuilder {
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun) {
            if (bun.equals(ROLL) || bun.equals(SESAME)) {
                this.bun = bun;
                return this;
            } else {
                throw new IllegalStateException(bun + " is not available.");
            }
        }

        public BigmacBuilder burgers(int burgers) {
            if (burgers >= 0) {
                this.burgers = burgers;
                return this;
            } else {
                throw new IllegalStateException("Number of beef patties can't be negative");
            }
        }

        public BigmacBuilder sauce(String sauce) {
            if (sauce.equals(STANDARD) || sauce.equals(THOUSAND) || sauce.equals(BBQ)) {
                this.sauce = sauce;
                return this;
            } else {
                throw new IllegalStateException(sauce + " is not available.");
            }
        }

        public BigmacBuilder ingredient(String ingredient) {
            if (ingredient.equals(SALAD) || ingredient.equals(ONION) || ingredient.equals(BACON) || ingredient.equals(PICKLE)
                    || ingredient.equals(CHILI) || ingredient.equals(MUSHROOM) || ingredient.equals(SHRIMP) || ingredient.equals(CHEESE)) {
                this.ingredients.add(ingredient);
                return this;
            } else {
                throw new IllegalStateException(ingredient + " is not available.");
            }
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
