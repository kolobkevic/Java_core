package com.kolobkevic.java_core.lessons.lesson_6;

public class Cat extends Animal {
    private static int catsCount = 0;

    Cat(String name, String color, int age, int maxDistanceRun, int maxDistanceSwim) {
        super(name, color, age, maxDistanceRun, maxDistanceSwim);
        catsCount++;
    }

    @Override
    public String voice() {
        return "Meow";
    }

    @Override
    public String swim(int distanceSwim) {
        return (name + " doesn't swim");
    }

    public static int getCatsCount() {
        return catsCount;
    }
}
