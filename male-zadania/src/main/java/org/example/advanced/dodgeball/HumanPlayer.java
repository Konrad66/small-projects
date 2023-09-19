package org.example.advanced.dodgeball;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, int x, int y) {
        super(name, x, y);
    }


    //TODO // usunąc powtórzenie kodu pomiędzy klasami human i computer obie używają tej samej pętli
    @Override
    public void move() {
        for (int i = 0; i < 2; i++) {
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

    public void playerMethod() {
        System.out.println("player method");
    }
}
