package org.example.basics.exe18;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    //TODO przeanalizować


    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int number = random.nextInt(10) + 1;
        int guess;
        int counter = 0;

        System.out.println("We play in guessing game. Guess the number from 1 to 10.");

        do {
            counter++;
            guess = scanner.nextInt();
            if (guess < number) {
                System.out.println("Za mało");
            } else if (guess > number) {
                System.out.println("Za dużo!");
            } else {
                System.out.println("You did it!");
            }
            int difference = Math.abs(guess - number);
            if (difference > 2) {
                System.out.println("Cold!");
            } else {
                System.out.println("Warm!");
            }
        } while (number != guess);
        System.out.println("You guessed it after " + counter + " shots");
    }
}
