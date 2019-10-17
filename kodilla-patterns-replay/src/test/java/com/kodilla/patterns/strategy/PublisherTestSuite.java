package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.social.Millenials;
import com.kodilla.patterns.strategy.social.YGeneration;
import com.kodilla.patterns.strategy.social.ZGeneration;
import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.*;

public class PublisherTestSuite {
    @Test
    public void testAssignedPublishers() {
        Millenials millenials = new Millenials("mil");
        YGeneration yGeneration = new YGeneration("yg");
        ZGeneration zGeneration = new ZGeneration("zg");

        Assert.assertEquals("Sharing to Facebook", millenials.sharePost());
        Assert.assertEquals("Sharing to Twitter", yGeneration.sharePost());
        Assert.assertEquals("Sharing to Snapchat", zGeneration.sharePost());
    }

    @Test
    public void testIndividualPublisher() {
        Millenials millenials = new Millenials("mil");

        millenials.sharePost();
        millenials.setSocialPublisher(new TwitterPublisher());
        millenials.sharePost();

        Assert.assertEquals("Sharing to Twitter", millenials.sharePost());
    }
}
