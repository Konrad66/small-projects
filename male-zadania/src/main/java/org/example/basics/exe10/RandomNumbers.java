package org.example.basics.exe10;

import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {

    public static void main(String[] args) {

        System.out.println("The program will roll the dice for you and draw the teams! Please tell me how many sides the dice you are throwing have? ");
        Scanner cube = new Scanner(System.in);
        int wallNumber = cube.nextInt();
        System.out.println("I throw dice with " + wallNumber + " sides.");

        Random random = new Random();
        int randomNumber = random.nextInt(wallNumber);
        System.out.println("I got: " + randomNumber);

        System.out.println("Now we roll the same dice again, but give me a range for the result drawn: ");


        Random random1 = new Random();
        int start = cube.nextInt();
        int end = cube.nextInt();
        System.out.println("Your choose range: " + start + " - " + end);
        int randomNumberFromRange = random1.nextInt((end - start) - 1) + start;
        System.out.println(randomNumberFromRange);
    }
}