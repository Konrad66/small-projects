package org.example.advanced.blackjack;

public class Player {

    private Card card1;
    private Card card2;
    private int money;

    public Card getCard1() {
        return card1;
    }

    public Card getCard2() {
        return card2;
    }

    public Player(Card card2, Card card1, int money) {
        this.card2 = card2;
        this.card1 = card1;
        this.money = money;
    }


}
