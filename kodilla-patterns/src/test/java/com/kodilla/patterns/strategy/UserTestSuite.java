package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.social.Millenials;
import com.kodilla.patterns.strategy.social.TwitterPublisher;
import com.kodilla.patterns.strategy.social.YGeneration;
import com.kodilla.patterns.strategy.social.ZGeneration;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSocialPublisher() {
        //Given
        Millenials john = new Millenials("John");
        YGeneration mark = new YGeneration("Mark");
        ZGeneration tom = new ZGeneration("Tom");
        //When
        String johnsPost = john.sharePost();
        System.out.println("John --> " + johnsPost);
        String marksPost = mark.sharePost();
        System.out.println("Mark --> " + marksPost);
        String tomsPost = tom.sharePost();
        System.out.println("Tom --> " + tomsPost);
        //Then
        Assert.assertEquals("Now sharing posts to Facebook", johnsPost);
        Assert.assertEquals("Now sharing posts to Twitter", marksPost);
        Assert.assertEquals("Now sharing posts to Snapchat", tomsPost);
    }

    @Test
    public void testSetSocialPublisher() {
        //Given
        Millenials john = new Millenials("John");
        //When
        String johnsDefault = john.sharePost();
        System.out.println("John --> " + johnsDefault);
        john.setSocialPublisher(new TwitterPublisher());
        String johnsPost = john.sharePost();
        System.out.println("Now John --> " + johnsPost);
        //Then
        Assert.assertEquals("Now sharing posts to Twitter", johnsPost);
    }
}
