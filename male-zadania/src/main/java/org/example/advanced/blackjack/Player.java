package org.example.advanced.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Hand playerHand = new Hand();
    private Deck deck = new Deck();

    void takeCard() {
        playerHand.addCard(deck.drawCard());
    }

    int getHandValue() {
       return playerHand.calculateValue();
    }


}