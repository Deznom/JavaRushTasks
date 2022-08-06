package com.javarush.task.pro.task13.task1318;

/* 
Следующий месяц, пожалуйста
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getNextMonth(Month.JANUARY));
        System.out.println(getNextMonth(Month.JULY));
    }

    public static Month getNextMonth(Month month) {
        var index = month.ordinal() + 1;
        if (month.ordinal() == Month.values().length -1) {
            index = 0;
        }
        return Month.values()[index];
    }
}
