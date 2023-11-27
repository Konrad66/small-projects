package org.example.basics.exe20;

import java.util.Arrays;

public class Exercise1 {

    //TODO do sprawdzenia

    public static void main(String[] args) {

        double[] number = {1.21, 2.25, 4.85, 6.75};
        boolean[] booleans = {true, false};
        char[] chars = {'j', 'a', 'v', 'a'};

        System.out.println("Floating point array: " + Arrays.toString(number));
        System.out.println("Boolean array: " + Arrays.toString(booleans));
        System.out.println("Array of characters: " + Arrays.toString(chars));
    }
}