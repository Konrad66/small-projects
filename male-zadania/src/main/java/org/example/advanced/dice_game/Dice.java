package org.example.advanced.dice_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {

    private int numberOfSides;
    private int lastRoll;
    private Random random;
    private List<Integer> rollHistory;

    public Dice(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        random = new Random();
        rollHistory = new ArrayList<>();
    }

    int rollDice() {
        lastRoll = random.nextInt(numberOfSides);
        rollHistory.add(lastRoll);
        return lastRoll;
    }

    List<Integer> getRollHistory() {
        return rollHistory;
    }
}