package org.example.advanced.dice_game;

import java.util.List;

public class Player {

    private String name;
    private int playerPoints;
    private boolean isActive;

    public Player(String name) {
        this.name = name;
        this.playerPoints = 0;
    }

    public String getName() {
        return name;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }


}