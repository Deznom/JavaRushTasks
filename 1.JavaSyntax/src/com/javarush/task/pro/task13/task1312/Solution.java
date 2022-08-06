package com.javarush.task.pro.task13.task1312;

import java.util.ArrayList;
import java.util.HashMap;

/* 
ArrayList vs HashMap
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getProgrammingLanguages());
    }

    public static HashMap<Integer, String> getProgrammingLanguages() {
        ArrayList<String> programmingLanguagesArray = new ArrayList<>();
        programmingLanguagesArray.add("Java");
        programmingLanguagesArray.add("Kotlin");
        programmingLanguagesArray.add("Go");
        programmingLanguagesArray.add("Javascript");
        programmingLanguagesArray.add("Typescript");
        programmingLanguagesArray.add("Python");
        programmingLanguagesArray.add("PHP");
        programmingLanguagesArray.add("C++");

        var programmingLanguages = new HashMap<Integer, String>();

        for (var i = 0; i < programmingLanguagesArray.size(); i++) {
            programmingLanguages.put(i, programmingLanguagesArray.get(i));
        }

        return programmingLanguages;
    }

}
