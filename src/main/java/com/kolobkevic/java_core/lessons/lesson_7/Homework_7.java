package com.kolobkevic.java_core.lessons.lesson_7;

public class Homework_7 {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Boris", 20), new Cat("Matilda", 40), new Cat("Garfield", 30)};
        for (Cat cat : cats) {
            System.out.println(cat);
        }
        Plate plate = new Plate(70);
        System.out.println(plate);
        System.out.println();

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println(plate);
        System.out.println();

        plate.addFood(20);
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println(plate);
    }
}
