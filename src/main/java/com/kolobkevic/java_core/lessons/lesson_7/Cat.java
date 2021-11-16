package com.kolobkevic.java_core.lessons.lesson_7;

class Cat {
    private String name;
    private int appetite;
    private boolean isHungry;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isHungry = true;
    }

    @Override
    public String toString() {
        return "Cat: " + name + ", appetite: " + appetite + ", isHungry: " + isHungry;
    }

    void eat(Plate plate) {
        if (!isHungry) {
            System.out.println(name + " is not hungry");
        } else if (plate.decreaseFood(appetite)) {
            isHungry = false;
        } else System.out.println("There is no so much food for " + name);
    }
}
