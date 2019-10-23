package com.kodilla.patterns2.adapter.oldhrsystem;

public class Workers {
    private String[][] workers = {
            {"6703", "John", "Smith"},
            {"6208", "Ivone", "Novak"},
            {"7502", "Jessie", "Pinkman"},
            {"7501", "Walter", "White"},
            {"7507", "Clara", "Lanson"}};
    private double[] salaries = {
            4500.00,
            3700.00,
            4350.00,
            9000.00,
            6200.00};

    public String getWorker(int n) {
        if (n > salaries.length) {
            return "";
        }
        return workers[n][0] + ", " + workers[n][1];
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
