package com.kolobkevic.java_core.lessons.lesson_6;

abstract class Animal implements IAnimal {
    String name;
    String color;
    int age;
    int maxDistanceSwim;
    int maxDistanceRun;
    private static int animalCount = 0;

    Animal(String name, String color, int age, int maxDistanceRun, int maxDistanceSwim) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxDistanceSwim = maxDistanceSwim;
        this.maxDistanceRun = maxDistanceRun;
        animalCount++;
    }

    @Override
    public String run(int distanceRun) {
        return (distanceRun <= maxDistanceRun ? (name + " runs " + distanceRun + "m") : ("Too long distance for " + name + ", max distance is-" + maxDistanceRun + "m"));
    }

    @Override
    public String swim(int distanceSwim) {
        return (distanceSwim <= maxDistanceSwim ? (name + " swims " + distanceSwim + "m") : ("Too long distance for " + name + ", max distance is-" + maxDistanceSwim + "m"));
    }

    @Override
    public String toString() {
        return "name: " + name + ", color: " + color + ", age: " + age;
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}

