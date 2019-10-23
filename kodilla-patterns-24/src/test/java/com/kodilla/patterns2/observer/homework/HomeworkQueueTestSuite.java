package com.kodilla.patterns2.observer.homework;

import org.junit.*;

public class HomeworkQueueTestSuite {
    @Test
    public void testHomeworkQueue() {
        //Given
        Mentor mentor1 = new Mentor("Mentor #1");
        Mentor mentor2 = new Mentor("Mentor #2");
        Mentor mentor3 = new Mentor("Mentor #3");
        HomeworkQueue queue1 = new HomeworkQueue("Queue from User 1");
        HomeworkQueue queue2 = new HomeworkQueue("Queue from User 2");
        queue1.registerMentor(mentor1);
        queue1.registerMentor(mentor2);
        queue2.registerMentor(mentor2);
        queue2.registerMentor(mentor3);
        //When
        queue1.addHomework("Homework 1");
        queue1.addHomework("Homework 2");
        queue1.addHomework("Homework 3");
        queue2.addHomework("Homework 1");
        queue2.addHomework("Homework 2");
        //Then
        Assert.assertEquals(3, mentor1.getUpdateCount());
        Assert.assertEquals(2, mentor3.getUpdateCount());
        Assert.assertEquals(5, mentor2.getUpdateCount());
    }
}
