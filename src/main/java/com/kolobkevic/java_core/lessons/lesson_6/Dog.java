package com.kolobkevic.java_core.lessons.lesson_6;

public class Dog extends Animal {
    private static int dogsCount = 0;

    public Dog(String name, String color, int age, int maxDistanceRun, int maxDistanceSwim) {
        super(name, color, age, maxDistanceRun, maxDistanceSwim);
        dogsCount++;
    }

    @Override
    public String voice() {
        return "Woof";
    }

    public static int getDogsCount() {
        return dogsCount;
    }
}
