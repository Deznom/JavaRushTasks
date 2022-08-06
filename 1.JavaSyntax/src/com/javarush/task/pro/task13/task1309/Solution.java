package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Петров", 3.2);
        grades.put("Иванов", 4.0);
        grades.put("Сергеев", 2.8);
        grades.put("Сычев", 4.1);
        grades.put("Анон", 4.6);
    }
}
