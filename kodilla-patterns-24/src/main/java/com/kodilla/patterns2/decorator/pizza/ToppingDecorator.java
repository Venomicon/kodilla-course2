package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ToppingDecorator extends AbstractPizzaDecorator {
    private String topping;

    public ToppingDecorator(PizzaOrder pizzaOrder, String topping) {
        super(pizzaOrder);
        this.topping = topping;
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + " + topping;
    }
}
