package org.example.basics.exe15;

import java.util.Scanner;

public class CountingPoints {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points;
        int sum = 0;

        do {
            System.out.println("Enter a number (enter 0 to break): ");
            points = scanner.nextInt();
            sum += points;

        } while (points != -1);
        sum++;
        System.out.println("Your sum of points equals: " + sum);
    }
}