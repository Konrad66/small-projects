package org.example.basics.exe21;

import java.util.Arrays;

public class Exercise21 {

    //TODO do sprawdzenia

    public static void main(String[] args) {
        int[] numbers = {4, 20, 349, 571, 707, 501, 696, 83, 946, 851};

        System.out.println("Our array: " + Arrays.toString(numbers));

        System.out.print("Numbers greater than 100: ");
        for (int number : numbers) {
            if (number > 100) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
        System.out.print("Odd numbers lower than 750: ");
        for (int number : numbers) {
            if (number % 2 != 0 && number < 750) {
                System.out.print(number + " ");
            }
        }

        System.out.println();
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        double average = sum / numbers.length;
        System.out.println("Average from our numbers equals: " + average);
    }
}