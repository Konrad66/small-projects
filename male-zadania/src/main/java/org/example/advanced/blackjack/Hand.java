package org.example.advanced.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> playersCard = new ArrayList<>();
    int handValue = 0;


    void addCard(Card card) {
        playersCard.add(card);
    }

    void calculateValue() {
        for (Card card : playersCard) {
            handValue += card.getRank().power;
            if (getHandValue() > 21){
                if (card.getRank().power == CardValue.ACE.power){
                    int newHandValue = handValue - 10;
                }
            }

            if (card.getRank().power == CardValue.ACE.power) {
                if (getHandValue() > 21) {
                    int newValueOfACE = CardValue.ACE.power - 10;
                    handValue += newValueOfACE;
                }
            }
            handValue += card.getRank().power;
        }
    }

    public int getHandValue() {
        return handValue;
    }

    boolean isBust() {
        if (getHandValue() > 21) {
            return true;
        }
        return false;
    }
}