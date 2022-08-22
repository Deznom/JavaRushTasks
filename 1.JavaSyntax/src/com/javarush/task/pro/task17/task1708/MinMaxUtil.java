package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

public class MinMaxUtil {
    public static int min (int a1, int a2) {
        return Math.min(a1, a2);
    }

    public static int min (int a1, int a2, int a3) {
        return min(a1, min(a2, a3));
    }

    public static int min (int a1, int a2, int a3, int a4) {
        return min(a1, min(a2, min(a3, a4)));
    }

    public static int min (int a1, int a2, int a3, int a4, int a5) {
        return min(a1, min(a2, min(a3, min(a4, a5))));
    }

    public static int max (int a1, int a2) {
        return Math.max(a1, a2);
    }

    public static int max (int a1, int a2, int a3) {
        return max(a1, max(a2, a3));
    }

    public static int max (int a1, int a2, int a3, int a4) {
        return max(a1, max(a2, max(a3, a4)));
    }

    public static int max (int a1, int a2, int a3, int a4, int a5) {
        return max(a1, max(a2, max(a3, max(a4, a5))));
    }
}
