package com.javarush.task.pro.task15.task1505;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Что-то не копируется...
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             var inputStream = Files.newInputStream(Paths.get(scanner.nextLine()));
             var outputStream = Files.newOutputStream(Paths.get(scanner.nextLine()))
        ) {
            while (inputStream.available() > 0) {
                int read = inputStream.read();
                outputStream.write(read);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}