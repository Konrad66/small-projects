package org.example.advanced.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Service {

   private List<Card> cardDeck;
   private int maxNumberOfDecks = 8;
   private int numberOfDecks = 0;

    void createDecks() {
        cardDeck = new ArrayList<>();
        for (int k = 0; k < maxNumberOfDecks; k++) {
            createDeck();
        }
        for (Card card : cardDeck) {
            System.out.println(card);
        }
    }

    private void createDeck(){
        for (Color color : Color.values()) {
            for (Rank rank : Rank.values()) {
                cardDeck.add(new Card(color, rank));
            }
        }
    }

    void dealCards() {
        List<Card> playerDeck = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            int randomIndex = random.nextInt(cardDeck.size());
            playerDeck.add(cardDeck.get(randomIndex));
        }
    }


//    Card dealCard(){
//        return
//    }



    public int getNumberOfDecks() {
        return numberOfDecks;
    }

    public void setNumberOfDecks(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
    }

//    Player getPlayer(){
//        return new Player()
//    }
}


//zalozenia blackjack
// w najczestrzych konfiguracjach uzywa sie od 6 do 8 tali;
// krupier rozdaje dwie karty, a następnie gracz może prosić o dobranie kart, aż osiągnie 21 punktów
// Z kolei krupier dopiera karty do 17 oczek
// w grze moze maksymalnie uczestniczyc 7 graczy;