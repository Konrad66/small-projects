package org.example.advanced.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> playersCard = new ArrayList<>();
    int sum = 0;


    void addCard(Card card){
        playersCard.add(card);
    }

    void calculateValue(){
        for (Card card : playersCard) {

            if (sum != 21){
                if(card.getRank().power == CardValue.ACE.power){
                    int newValueOfACE = CardValue.ACE.power - 10;
                    sum += newValueOfACE;
                }
            }
            sum += card.getRank().power;
        }
    }

    boolean isBust(){
        if (sum > 21){
            return true;
        }
        return false;
    }
}