package com.kodilla.patterns2.observer.forum;

import org.junit.*;

public class ForumUserTestSuite {
    @Test
    public void testUpdate() {
        //Given
        ForumTopic javaHelpForum = new JavaHelpForumTopic();
        ForumTopic javaToolsForum = new JavaToolsForumTopic();
        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser ivoneEscobar = new ForumUser("Ivone Escobar");
        ForumUser jessiePinkman = new ForumUser("Jessie Pinkman");
        javaHelpForum.registerObserver(johnSmith);
        javaHelpForum.registerObserver(jessiePinkman);
        javaToolsForum.registerObserver(jessiePinkman);
        javaToolsForum.registerObserver(ivoneEscobar);
        //When
        javaHelpForum.addPost("Post 1");
        javaHelpForum.addPost("Post 2");
        javaToolsForum.addPost("Tools post 1");
        javaHelpForum.addPost("Post 3");
        javaToolsForum.addPost("Tools post 2");
        //Then
        Assert.assertEquals(3, johnSmith.getUpdateCount());
        Assert.assertEquals(2, ivoneEscobar.getUpdateCount());
        Assert.assertEquals(5, jessiePinkman.getUpdateCount());
    }
}
