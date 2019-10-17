package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {
    String taskName;
    String color;
    String whatToPaint;
    boolean isExecuted = false;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public void executeTask() {
        isExecuted = true;
    }

    @Override
    public boolean isTaskExecuted() {
        if (isExecuted) {
            return true;
        } else {
            return false;
        }
    }
}
