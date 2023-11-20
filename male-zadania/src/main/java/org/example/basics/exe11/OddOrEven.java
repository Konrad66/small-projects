package org.example.basics.exe11;

import java.util.Scanner;

public class OddOrEven {
    public static void main(String[] args) {

        System.out.println("Give me a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("number " + number + " is negative");
        } else if (number == 0) {
            System.out.println("number " + number + " is equals 0");
        } else {
            System.out.println("number " + number + " is positive");
        }

        if (number % 2 == 0) {
            System.out.println("number " + number + " is even");
        } else {
            System.out.println("number " + number + " is odd");
        }

        System.out.println("Give me 3 different numbers: ");
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();

        //TODO sprawdzić inne sposoby
        if (number1 > number2 && number1 > number3) {
            System.out.println("Number " + number1 + " is the biggest ");
        } else if (number2 > number1 && number2 > number3) {
            System.out.println("Number " + number2 + " is the biggest ");
        } else {
            System.out.println("Number " + number3 + " is the biggest ");
        }

        //int biggest = Math.max(Math.max(number1, number2), number3);
        //System.out.println("The biggest number is: " + biggest);
    }
}