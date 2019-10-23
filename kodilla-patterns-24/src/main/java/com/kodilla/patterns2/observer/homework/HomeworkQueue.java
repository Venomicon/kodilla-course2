package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class HomeworkQueue implements Observable {
    private final List<Observer> mentors;
    private final List<String> homeworks;
    private final String name;

    public HomeworkQueue(String name) {
        this.name = name;
        mentors = new ArrayList<>();
        homeworks = new ArrayList<>();
    }

    public List<String> getHomeworks() {
        return homeworks;
    }

    public String getName() {
        return name;
    }

    public List<Observer> getMentors() {
        return mentors;
    }

    public void addHomework(String homework) {
        homeworks.add(homework);
        notifyMentors();
    }

    @Override
    public void registerMentor(Observer observer) {
        mentors.add(observer);
    }

    @Override
    public void notifyMentors() {
        for (Observer observer : mentors) {
            observer.update(this);
        }
    }

    @Override
    public void removeMentor(Observer observer) {
        mentors.remove(observer);
    }
}
