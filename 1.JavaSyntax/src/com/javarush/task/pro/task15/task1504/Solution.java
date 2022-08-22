package com.javarush.task.pro.task15.task1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var filePath1 = scanner.nextLine();
        var filePath2 = scanner.nextLine();
        try (var inputStream = Files.newInputStream(Paths.get(filePath1));
             var outputStream = Files.newOutputStream(Paths.get(filePath2))) {
            while (inputStream.available() > 1) {
                var rBytes = inputStream.readNBytes(2);
                outputStream.write(rBytes[1]);
                outputStream.write(rBytes[0]);
            }

            if (inputStream.available() > 0) {
                outputStream.write(inputStream.read());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

