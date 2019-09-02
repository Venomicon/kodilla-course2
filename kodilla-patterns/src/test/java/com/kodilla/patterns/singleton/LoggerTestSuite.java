package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void testGetLastLog() {
        //Given
        //When
        Logger.getInstance().log("abc");
        Logger.getInstance().log("def");
        String lastLog = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("def", lastLog);
    }
}
