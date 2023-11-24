package org.example.basics.exe13;

import java.util.Scanner;

public class BMI {

    //TODO do poprawienia

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int age;
        double growth;
        double weight;

        do {
            System.out.println("How old are you?");
            age = scanner.nextInt();
            if (age >= 100) {
                System.out.println("We don't give advice to people over 100 years old.");
            } else if (age < 0) {
                System.out.println("We do not provide advice for absurd values.");
            } else if (age < 18) {
                System.out.println("Counseling for minors has a special clause.");
            } else {
                System.out.println("Correct data");
            }
        } while (age < 0 || age > 100);

        do {
            System.out.println("How tall are you? Enter in cm:");
            growth = scanner.nextDouble();
            if (growth < 30) {
                System.out.println("We do not provide advice for absurd values.");
            } else if (growth > 254) {
                System.out.println("We do not provide advice for absurd values.");
            } else {
                System.out.println("Correct data");
            }
        } while (growth < 30 || growth > 254);

        do {
            System.out.println("How much you weight? Enter in kg:");
            weight = scanner.nextDouble();
            if (weight < 1) {
                System.out.println("We do not provide advice for absurd values.");
            } else if (weight > 595) {
                System.out.println("We do not provide advice for absurd values.");
            } else {
                System.out.println("Correct data");
            }
        } while (weight < 1 || weight > 595);
    }
}