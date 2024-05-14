package org.example.advanced.hangman;

import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);

    int readNumber() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    String readText() {
        return scanner.nextLine();
    }
}