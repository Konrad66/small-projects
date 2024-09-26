package org.example.advanced.blackjack;

public class Player {

    private Hand playerHand = new Hand();



    int getHandValue() {
       return playerHand.calculateValue();

    }

}