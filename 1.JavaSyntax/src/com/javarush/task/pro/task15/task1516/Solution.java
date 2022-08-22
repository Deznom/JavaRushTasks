package com.javarush.task.pro.task15.task1516;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файл или директория
*/

public class Solution {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        while (true) {
            var path = Path.of(scanner.nextLine());

            if (!Files.exists(path)) {
                break;
            }

            if (Files.isDirectory(path)) {
                System.out.println(path + THIS_IS_DIR);
            } else if (Files.isRegularFile(path)) {
                System.out.println(path + THIS_IS_FILE);
            }
        }
    }
}

