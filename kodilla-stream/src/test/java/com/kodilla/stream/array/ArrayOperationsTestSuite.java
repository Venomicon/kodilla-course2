package com.kodilla.stream.array;

import org.junit.*;

import java.util.OptionalDouble;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given
        int[] numbers = {3, 5, 2, 5, 2};

        //When
        double avg = ArrayOperations.getAverage(numbers);

        //Then
        double expected = 3.4;
        Assert.assertEquals(expected, avg, 0.0);
    }
}
