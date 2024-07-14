package org.example.advanced.war_card_game;

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