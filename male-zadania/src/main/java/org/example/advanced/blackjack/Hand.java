package org.example.advanced.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> playersCard = new ArrayList<>();

/*
addCard(Card card): Dodaje kartę do ręki.
calculateValue(): Oblicza łączną wartość kart w ręce, uwzględniając zasady Blackjacka (np. wartość AS-a).
isBust(): Sprawdza, czy wartość kart przekracza 21.
 */

    void addCard(Card card){
        playersCard.add(card);
    }

    void calculateValue(){
        int sum = 0;
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



}