package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("sesame")
                .sauce("barbecue")
                .burgers(3)
                .ingredient("onion")
                .ingredient("salad")
                .ingredient("bacon")
                .build();
        System.out.println(bigmac);
        //When
        int ingredients = bigmac.getIngredients().size();
        String sauce = bigmac.getSauce();
        //Then
        Assert.assertEquals(3, ingredients);
        Assert.assertEquals("barbecue", sauce);
    }
}
