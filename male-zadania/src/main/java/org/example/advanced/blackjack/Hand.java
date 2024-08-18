package org.example.advanced.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> playersCard = new ArrayList<>();
    private int handValue;


    void addCard(Card card) {
        playersCard.add(card);
        calculateValue();
    }

    void clearHand(){
        playersCard.clear();
        handValue = 0;
    }

    public List<Card> getPlayersCard() {
        return playersCard;
    }

     void calculateValue() {
        handValue = 0;
        int aceCount = 0;
        for (Card card : playersCard) {
            handValue += card.getRank().power;
            if (card.getRank().power == CardValue.ACE.power) {
                aceCount++;
            }
        }
        while (getHandValue() > 21 && aceCount > 0) {
            handValue -= 10;
            aceCount--;
        }
    }

    int getHandValue() {
        return handValue;
    }

    boolean isBust() {
        return getHandValue() > 21;
    }
}