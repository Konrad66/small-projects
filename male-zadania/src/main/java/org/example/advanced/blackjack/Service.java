package org.example.advanced.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Service {

   private List<Card> cardDeck;

    void createCards() {
        cardDeck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 16; j++) {
                cardDeck.add(new Card(i, j));
            }
        }
//        for (Card card : cardDeck) {
//            System.out.println(card);
//        }
    }



    void dealCards() {
        List<Card> playerDeck = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            int randomIndex = random.nextInt(cardDeck.size());
            playerDeck.add(cardDeck.get(randomIndex));
        }
    }

    //tasowanie kart i rozdanie dla graczy

    //mamy listę kart chcemy je rozdzielić na 1 gracza;


}

//chcemy wylosować połowę elementów z jednej listy i dodać je do drugiej listy


// 56 kart
// 28 na gracza