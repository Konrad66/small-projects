package org.example.advanced.blackjack;

import java.util.*;

class Service {

    private List<Card> cardsDeck = new ArrayList<>();
    private Player player;
    private Dealer dealer;


    Service() {
        createDeck();
        shuffleDeck();
        player = new Player(drawCard(), drawCard(), 1000);
        dealer = new Dealer(drawCard());
    }

    private void createDeck() {
        for (Color color : Color.values()) {
            for (Rank rank : Rank.values()) {
                cardsDeck.add(new Card(color, rank));
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(cardsDeck);
    }

    private Card drawCard() {
        return cardsDeck.remove(0);
    }

    Player getPlayer() {
        return player;
    }

    Dealer getDealer() {
//        Card dealerCard = dealer.getCard2();
//        dealerCard.setHidden(false);
        return dealer;
    }


    void decide(String choice) {

    }

    //todo stworzenie krupiera narazie w service
    //todo gracz decyduje czy chce pasowac czy dobierac karte
    //todo warunek do wygrania
    //todo w przypadku komputera mozna zrobi ze jeden dobiera np od sumy 15 a drugi np tylko od 17
    //
}


//zalozenia blackjack
// w najczestrzych konfiguracjach uzywa sie od 6 do 8 tali;
// krupier rozdaje dwie karty, a następnie gracz może prosić o dobranie kart, aż osiągnie 21 punktów
// Z kolei krupier dopiera karty do 17 oczek
// w grze moze maksymalnie uczestniczyc 7 graczy;
//karta krupiera odzsłania się w momencie jak wszyscy gracze spasują


//wykładamy dwie karty, mamy informacje