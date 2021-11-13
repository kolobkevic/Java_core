package com.kolobkevic.java_core.lessons.lesson_5;

public class Homework_5 {
    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Joe Biden", "founder", "founder@mail.ru", "+79288888888", 1000000, 79);
        employeeArray[1] = new Employee("Boris Johnson", "manager", "manager@mail.ru", "+440455443333", 300000, 57);
        employeeArray[2] = new Employee("Pavel Durov", "accountant", "accountant@mail.ru", "+79011232344", 400000, 37);
        employeeArray[3] = new Employee("Angela Merkel", "director", "director@mail.ru", "+491939194500", 200000, 67);
        employeeArray[4] = new Employee("Edward Snowden", "IT specialist", "hacker@mail.ru", "+79639636363", 10000, 38);

        for (Employee employee : employeeArray) {
            if (employee.getAge() > 40) {
                System.out.println(employee);
            }
        }
    }
}
