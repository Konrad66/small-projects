package org.example.advanced.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> cardsDeck = new ArrayList<>();

    public Deck() {
        createDeck();
        shuffleDeck();
    }

    void restartDeck() {
        createDeck();
        shuffleDeck();
    }

    private void createDeck() {
        cardsDeck.clear();
        for (Suit suit : Suit.values()) {
            for (CardValue cardValue : CardValue.values()) {
                cardsDeck.add(new Card(suit, cardValue));
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(cardsDeck);
    }

    Card drawCard() {
        return cardsDeck.remove(0);
    }
}