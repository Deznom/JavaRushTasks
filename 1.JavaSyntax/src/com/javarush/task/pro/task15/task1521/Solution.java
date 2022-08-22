package com.javarush.task.pro.task15.task1521;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Временное сохранение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        URL url = new URL(line);
        InputStream urlInput = url.openStream();
        Path tempFile = Files.createTempFile(null, null);
        Files.write(tempFile, urlInput.readAllBytes());
    }
}