package org.example.advanced.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> playersCard = new ArrayList<>();
    private int money;

    void addCard(Card card) {
        playersCard.add(card);
    }

    void clearHand() {
        playersCard.clear();
    }

    public List<Card> getPlayersCard() {
        return playersCard;
    }

    int calculateValue() {
        int handValue = 0;
        int aceCount = 0;
        for (Card card : playersCard) {
            handValue += card.getPower();
            if (card.getRank().equals(CardValue.ACE)) {
                aceCount++;
            }
        }
        while (handValue > 21 && aceCount > 0) {
            handValue -= 10;
            aceCount--;
        }
        return handValue;
    }

    boolean isBust() {
        return calculateValue() > 21;
    }
}