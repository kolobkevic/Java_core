package com.kolobkevic.java_core.lessons.lesson_6;

public class Homework_6 {
    public static void main(String[] args) {
        IAnimal[] animals = {new Cat("Barsik", "black", 7, 100, 0),
                new Dog("Rex", "brown", 3, 200, 100),
                new Dog("Lucky", "white", 5, 250, 140),
                new Cat("Matilda", "grey", 10, 50, 0),
                new Dog("Dazy", "silver", 4, 150, 130)};
        for (IAnimal animal : animals) {
            System.out.println(animal);
            System.out.println(animal.voice());
            System.out.println(animal.swim(120));
            System.out.println(animal.run(190));
            System.out.println();
        }
        System.out.println("There are " + Animal.getAnimalCount() + " animals. " + Cat.getCatsCount() + " cats, " + Dog.getDogsCount() + " dogs.");
    }
}
