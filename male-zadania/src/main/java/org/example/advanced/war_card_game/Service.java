package org.example.advanced.war_card_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Service {

    List<Card> cardDeck;

    void createCards() {
        cardDeck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 16; j++) {
                cardDeck.add(new Card(i, j));
            }
        }
        for (Card card : cardDeck) {
            System.out.println(card);
        }
    }


    void shuffleCards() {
        List<Card> playerDeck = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < cardDeck.size(); i++){
            for (int j = 0; j < 28; j++){
                int randomIndex = random.nextInt(cardDeck.size());


            }


        }


    }

    //tasowanie kart i rozdanie dla graczy

    //mamy listę kart chcemy je rozdzielić na 1 gracza;



}

//chcemy wylosować połowę elementów z jednej listy i dodać je do drugiej listy





// 56 kart
// 28 na gracza
