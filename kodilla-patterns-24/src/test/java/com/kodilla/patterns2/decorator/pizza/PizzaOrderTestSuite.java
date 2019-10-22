package com.kodilla.patterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrder() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        BigDecimal theCost = pizzaOrder.getCost();
        System.out.println(theCost);
        String description = pizzaOrder.getDescription();
        System.out.println(description);
        //Then
        Assert.assertEquals(new BigDecimal(15), theCost);
        Assert.assertEquals("Pizza with tomato sauce and cheese", description);
    }

    @Test
    public void testExtraCheesePizzaOrder() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        //When
        BigDecimal theCost = pizzaOrder.getCost();
        System.out.println(theCost);
        String description = pizzaOrder.getDescription();
        System.out.println(description);
        //Then
        Assert.assertEquals(new BigDecimal(20), theCost);
        Assert.assertEquals("Pizza with tomato sauce and cheese + extra cheese", description);
    }

    @Test
    public void testExtraToppingPizzaOrder() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ToppingDecorator(pizzaOrder, "ham");
        //When
        BigDecimal theCost = pizzaOrder.getCost();
        System.out.println(theCost);
        String description = pizzaOrder.getDescription();
        System.out.println(description);
        //Then
        Assert.assertEquals(new BigDecimal(17), theCost);
        Assert.assertEquals("Pizza with tomato sauce and cheese + ham", description);
    }

    @Test
    public void testExtraCheeseAndExtraToppingsPizzaOrder() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ToppingDecorator(pizzaOrder, "ham");
        pizzaOrder = new ToppingDecorator(pizzaOrder, "mushrooms");
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        //When
        BigDecimal theCost = pizzaOrder.getCost();
        System.out.println(theCost);
        String description = pizzaOrder.getDescription();
        System.out.println(description);
        //Then
        Assert.assertEquals(new BigDecimal(24), theCost);
        Assert.assertEquals("Pizza with tomato sauce and cheese + ham + mushrooms + extra cheese", description);
    }
}
