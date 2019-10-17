package com.kodilla.patterns.singleton;

import org.junit.*;

public class LoggetTestSuite {
    @Test
    public void testGetLastLog() {
        //Given
        Logger.getInstance().log("New log");

        //When
        String last = Logger.getInstance().getLastLog();

        //Then
        Assert.assertEquals("New log", last);
    }
}
