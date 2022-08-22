package com.javarush.task.pro.task15.task1506;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var fileName = scanner.nextLine();
        try {
            var lines = Files.readAllLines(Paths.get(fileName));
            for (var line: lines) {
                System.out.println(line.replace(".", "")
                        .replace(",", "")
                        .replace(" ", ""));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

