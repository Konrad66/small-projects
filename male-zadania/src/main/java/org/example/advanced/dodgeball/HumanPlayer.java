package org.example.advanced.dodgeball;

import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void move() {
        boolean correctMove;
        do {
            Scanner reader = new Scanner(System.in);
            System.out.println("Chose your move: W, A, S, D");
            String input = reader.next();
            correctMove = executeMove(input);
            if (!correctMove) {
                System.out.println("Choose other direction");
            }
        } while (!correctMove);
    }
}
