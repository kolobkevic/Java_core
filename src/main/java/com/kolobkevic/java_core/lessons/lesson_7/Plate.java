package com.kolobkevic.java_core.lessons.lesson_7;

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Plate: " + food;
    }

    void addFood(int food) {
        this.food += food;
    }

    boolean decreaseFood(int food) {
        if (food <= this.food) {
            this.food -= food;
            return true;
        } else return false;
    }
}
