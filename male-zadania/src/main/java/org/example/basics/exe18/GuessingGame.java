package org.example.basics.exe18;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    //TODO zapytac o ifa, zrobic wariant trudniejszy

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
                System.out.println("Cold!");
            } else if (guess > number) {
                System.out.println("Warm!");
            } else {
                System.out.println("You did it!");
            }
        } while (number != guess);
        System.out.println("You guessed it after " + counter + " shots");
    }
}
