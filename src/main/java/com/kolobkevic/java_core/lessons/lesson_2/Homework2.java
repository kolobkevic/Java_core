package com.kolobkevic.java_core.lessons.lesson_2;

public class Homework2 {
    public static void main(String[] args) {
        System.out.println(isBetween(5, 5));
        System.out.println(isBetween(0, 5));
        System.out.println(isBetween(15, 5));
        System.out.println(isBetween(15, 25));
        System.out.println();
        isPositive(-5);
        isPositive(0);
        isPositive(10);
        System.out.println();
        System.out.println(isNegative(5));
        System.out.println(isNegative(-5));
        System.out.println(isNegative(0));
        System.out.println();
        printString("cat", 3);
        printString("cartoon network", 2);
        System.out.println();
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(1900));
        System.out.println(isLeapYear(1601));
        System.out.println(isLeapYear(2012));
    }

    public static boolean isBetween(int a, int b) {
        return ((a + b) >= 10 && (a + b) <= 20);
    }

    public static void isPositive(int a) {
        System.out.println((a >= 0) ? "Число положительное" : "Число отрицательное");
    }

    public static boolean isNegative(int a) {
        return a < 0;
    }

    public static void printString(String s, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(s);
        }
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0 & year % 100 != 0) | (year % 400 == 0));
    }
}
