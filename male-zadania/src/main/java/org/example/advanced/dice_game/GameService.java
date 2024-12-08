package org.example.advanced.dice_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameService {


    private List<Player> playerList = new ArrayList<>();
    Dice dice1;
    Dice dice2;
    private final int maxScore = 100;
    private boolean isGameRunning;


    void round(int choice){
        switch (choice){
            case 1:

                System.out.println("Twoje aktualne punkty: ");
            default:
                System.out.println("Zły wybór");
        }
    }


    void checkConditionToWin(){
        //if (player1.getPlayerPoints() >= conditionToWin){

        //}
    }

}
