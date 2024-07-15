package org.example.advanced.blackjack;

import java.util.Scanner;

class Input {
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