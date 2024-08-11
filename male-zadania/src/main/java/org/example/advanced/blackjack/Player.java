package org.example.advanced.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {


    //lista zamiast osobno definiowac karty w zmiennych

    private List<Card> playerCards = new ArrayList<>();


    private Card card1;
    private Card card2;
    private int money;

    public Player(Card card1, Card card2, int money) {
        this.card1 = card1;
        this.card2 = card2;
        this.money = money;
    }

    public Card getCard1() {
        return card1;
    }

    public Card getCard2() {
        return card2;
    }

    public int countPoint(){
        return card1.getRank().power + card2.getRank().power;
    }

    @Override
    public String toString() {
        return card1 + " \n" + card2 + " \nMoney left: " + money;
    }
}