package com.kolobkevic.java_core.lessons.lesson_3;

import java.util.Arrays;

public class Lesson_3 {
    public static void main(String[] args) {
        invertArray();
        System.out.println();
        fillArray();
        System.out.println();
        doubleArray();
        System.out.println();
        diagArray();
        System.out.println();
        System.out.println(Arrays.toString(fillArray(4, 1)));
        System.out.println(Arrays.toString(fillArray(6, 7)));
        System.out.println(); // новая строка для удобства
        System.out.println("Пара мин. и макс. значений" + " " + Arrays.toString(searchingMinMax()));
        System.out.println(); // новая строка для удобства
        System.out.println(checkBalance(new int[]{4, 2, 3, 6, 2, 1}));// 9=9
        System.out.println(checkBalance(new int[]{4, 6, 2, 3, 2, 1}));// здесь баланса нет
        System.out.println(checkBalance(new int[]{4, -2, 3, 2, 2, 6, -1, 2, 2}));// 9=9
        System.out.println(); // новая строка для удобства
        System.out.println(Arrays.toString(new int[]{1, 2, 3, 4, 5}));
        System.out.println(Arrays.toString(displaceArray(new int[]{1, 2, 3, 4, 5}, -1)));
        System.out.println(Arrays.toString(displaceArray(new int[]{1, 2, 3, 4, 5}, 2)));
        System.out.println(); // новая строка для удобства
        System.out.println(Arrays.toString(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(Arrays.toString(displaceArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, -3)));
        System.out.println(Arrays.toString(displaceArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 4)));
    }

    static void invertArray() {
        int[] array = {1, 0, 1, 0, 1, 1, 0};
        System.out.println(Arrays.toString(array));// для удобства проверки печатаю оригинал массива
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 - array[i];
        }
        System.out.println(Arrays.toString(array));
    }

    static void fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++)
            array[i] = i + 1;
        System.out.println(Arrays.toString(array)); //не сообразил как сделать вывод не в виде такой длинной колбасы, используя toString
    }

    static void doubleArray() {
        int[] array = {1, 5, 3, -2, 11, 4, 5, 0, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array));// для удобства проверки печатаю оригинал массива
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] *= 2;
        }
        System.out.println(Arrays.toString(array));
    }

    static void diagArray() {
        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length - 1 - i] = 1;
            System.out.println(Arrays.toString(array[i]));
        }
    }

    static int[] fillArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);// IntelliJ IDEA предложила заменить мой цикл на встроенный метод, так и сделал
        return array;
    }

    static int[] searchingMinMax() {
        int[] array = {1, 5, 3, 2, 2, 11, 4, -11, 5, 2, 14, 4, 8, 9, 0};
        System.out.println(Arrays.toString(array));// для удобства проверки печатаю оригинал массива
        int minValue = array[0];
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (minValue > array[i])
                minValue = array[i];
            if (maxValue < array[i])
                maxValue = array[i];
        }
        return new int[]{minValue, maxValue};
    }

    static boolean checkBalance(int[] array) {
        int sum = 0;
        int halfSum = 0;
        for (int i : array
        ) {
            sum += i;
        }
        if (sum % 2 == 0) {
            for (int i : array
            ) {
                halfSum += i;
                if (halfSum == sum / 2)
                    return true;
                else if (halfSum > sum / 2)
                    return false;
            }
        }
        return false;
    }

    static int[] displaceArray(int[] array, int step) {
        int buffer;
        int tempStep = step;// ввел переменную, чтобы не писать циклы для положительного и отрицательного значения step
        if (step == array.length || step == 0)
            return array;
        else if (step > 0)
            tempStep = step;
        else
            tempStep = array.length + step;
        for (int i = 0; i < tempStep / 2; i++) {
            buffer = array[i + array.length - tempStep];
            array[i + array.length - tempStep] = array[array.length - 1 - i];
            array[array.length - 1 - i] = buffer;
        }
        for (int i = 0; i < (array.length - tempStep) / 2; i++) {
            buffer = array[i];
            array[i] = array[array.length - tempStep - i - 1];
            array[array.length - tempStep - i - 1] = buffer;
        }
        for (int i = 0; i < array.length / 2; i++) {
            buffer = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = buffer;
        }
        return array;
    }
}
