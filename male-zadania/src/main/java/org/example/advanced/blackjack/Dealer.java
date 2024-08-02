package org.example.advanced.blackjack;

public class Dealer {

    private Card card1;
    private Card card2;

    public Dealer(Card card1) {
        this.card1 = card1;
    }

    public Card getCard1() {
        return card1;
    }

    public Card getCard2() {
        return card2;
    }

    @Override
    public String toString() {
        return card1 + "";
    }
}