package org.example.basics.exe20;

import java.util.Arrays;
import java.util.Random;

public class Exercise20 {

    public static void main(String[] args) {

        double[] number = {1.21, 2.25, 4.85, 6.75};
        boolean[] booleans = {true, false};
        char[] chars = {'j', 'a', 'v', 'a'};

        System.out.println("Floating point array: " + Arrays.toString(number));
        System.out.println("Boolean array: " + Arrays.toString(booleans));
        System.out.println("Array of characters: " + Arrays.toString(chars));

        Random[] randoms = {new Random(), new Random(), new Random()};
        int randomNumber = randoms[1].nextInt(6);

        System.out.println("The number drawn: " + randomNumber);
    }
}