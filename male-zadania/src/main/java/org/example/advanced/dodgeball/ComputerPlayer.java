package org.example.advanced.dodgeball;

import java.util.Random;

public class ComputerPlayer extends Player {
    public ComputerPlayer(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void move() {
        boolean correctMove;
        do {
            Random random = new Random();
            String[] directions = {"W", "A", "S", "D"};
            String input = directions[random.nextInt(4)];
            correctMove = executeMove(input);
        } while (!correctMove);
    }

}
