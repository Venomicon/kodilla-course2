package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testCreateTasks() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task task1 = factory.create(TaskFactory.SHOPPING);
        Task task2 = factory.create(TaskFactory.PAINTING);
        Task task3 = factory.create(TaskFactory.DRIVING);
        //Then
        Assert.assertEquals("Shopping Task", task1.getTaskName());
        Assert.assertEquals("Painting Task", task2.getTaskName());
        Assert.assertEquals("Driving Task", task3.getTaskName());
    }

    @Test
    public void testExecuteTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        Task task1 = factory.create(TaskFactory.SHOPPING);
        //When
        task1.executeTask();
        //Then
        Assert.assertEquals(true, task1.isTaskExecuted());
    }
}
