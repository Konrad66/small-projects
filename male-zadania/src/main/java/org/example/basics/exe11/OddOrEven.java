package org.example.basics.exe11;

import java.util.Scanner;

public class OddOrEven {

    public static void main(String[] args) {

        System.out.println("Give me a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(number);

        if (number < 0 ){
            System.out.println("number is negative");
        } else if (number == 0) {
            System.out.println("Number is equals 0");
        } else {
            System.out.println("Number is positive");
        }


    }
}
