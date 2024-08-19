package org.example.advanced.blackjack;

public class Card {

    private final Suit suit;
    private final CardValue cardValue;

    public Card(Suit suit, CardValue cardValue) {
        this.suit = suit;
        this.cardValue = cardValue;
    }

    public CardValue getRank() {
        return cardValue;
    }

    int getPower() {
        return cardValue.power;
    }

    @Override
    public String toString() {
        return cardValue + " of " + suit;
    }
}