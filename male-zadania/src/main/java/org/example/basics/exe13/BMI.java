package org.example.basics.exe13;

import java.util.Scanner;

public class BMI {

    //TODO do sprawdzenia
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How old are you?");
        int age = scanner.nextInt();
        System.out.println("How tall are you? Enter in cm:");
        double growth = scanner.nextDouble();
        System.out.println("How much you weight? Enter in kg:");
        double weight = scanner.nextDouble();

        if (age < 0 || growth <= 0 || weight <= 0) {
            System.out.println("We do not provide advice for absurd values.");
        } else if (age > 100) {
            System.out.println("We don't give advice to people over 100 years old.");
        } else if (age < 18) {
            System.out.println("Counseling for minors has a special clause.");
        } else if (age == 14 && weight > 100) {
            System.out.println("Warning");
        } else if (age > 14 && weight < 40 && growth > 100) {
            System.out.println("Anorexic warning.");
        } else if (weight > 100 && growth < 200) {
            System.out.println("Overweight warning.");
        } else {
            System.out.println("Keep going.");
        }
    }
}