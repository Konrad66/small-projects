package org.example.basics.exe11;

import java.util.Scanner;

public class OddOrEven {

    public static void main(String[] args) {

        System.out.println("Give me a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number < 0 ){
            System.out.println("number " + number + " is negative");
        } else if (number == 0) {
            System.out.println("number " + number + " is equals 0");
        } else {
            System.out.println("number " + number + " is positive");
        }

        if (number % 2 == 0){
            System.out.println("number " + number + " is even");
        } else {
            System.out.println("number " + number + " is odd");
        }


    }
}
