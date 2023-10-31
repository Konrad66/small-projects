package org.example.basics.exe9;

import java.util.Scanner;

public class Age {

    public static void main(String[] args) {

        System.out.println("Hello, what's your name?");
        Scanner name = new Scanner(System.in);
        String inputName = name.next();

        System.out.println("What's your surname?");
        Scanner surname = new Scanner(System.in);
        String inputSurname = surname.next();

        System.out.println("Hello " + inputName + " " + inputSurname + "! How old are you?");
        Scanner ageInput = new Scanner(System.in);
        int age = ageInput.nextInt();

        if (age >= 18) {
            System.out.println("I already know if you are of legal age: " + true);
        } else {
            System.out.println("I already know if you are of legal age: " + false);
        }

        if (age < 11){
            System.out.println("You are child.");
        } else if (age <= 19) {
            System.out.println("You are teenager.");
        } else if (age <= 65) {
            System.out.println("You are adult.");
        } else {
            System.out.println("You are retirement age.");
        }
    }
}