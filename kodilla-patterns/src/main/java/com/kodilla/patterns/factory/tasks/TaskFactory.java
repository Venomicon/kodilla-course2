package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "ShoppingTask";
    public static final String PAINTING = "PaintingTask";
    public static final String DRIVING = "DrivingTask";

    public Task create(String taskType) {
        switch (taskType) {
            case SHOPPING:
                return new ShoppingTask("Shopping Task", "Apples", 20);
            case PAINTING:
                return new PaintingTask("Painting Task", "White", "Apartment");
            case DRIVING:
                return new DrivingTask("Driving Task", "Theatre", "Mercedes");
            default:
                System.out.println("Incorrect task type");
                return null;
        }
    }
}
