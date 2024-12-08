package org.example.advanced.dice_game;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    public int readNumber() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}
