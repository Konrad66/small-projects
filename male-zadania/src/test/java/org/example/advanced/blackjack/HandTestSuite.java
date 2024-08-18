package org.example.advanced.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTestSuite {

    Hand playerHand = new Hand();
    Card card1 = new Card(Suit.CLUBS, CardValue.ACE);
    Card card2 = new Card(Suit.HEARTS, CardValue.ACE);
    Card card3 = new Card(Suit.DIAMONDS, CardValue.EIGHT);
    Card card4 = new Card(Suit.SPADES, CardValue.KING);

    @Test
    public void shouldAddCardsToPlayerHands() {
        playerHand.addCard(card1);
        playerHand.addCard(card4);
        assertEquals(2, playerHand.getPlayersCard().size());
    }

    @Test
    public void testIsBust() {
        playerHand.addCard(card4);
        playerHand.addCard(card4);
        playerHand.addCard(card3);
        assertTrue(playerHand.isBust());
    }

    @Test
    public void testIsntBust() {
        playerHand.addCard(card1);
        playerHand.addCard(card4);
        playerHand.addCard(card3);
        assertFalse(playerHand.isBust());
    }

    @Test
    public void testCalculateValue() {
        playerHand.addCard(card1);
        playerHand.addCard(card2);
        playerHand.addCard(card3);
        assertEquals(20, playerHand.getHandValue());
    }

    @Test
    public void test2CalculateValue() {
        playerHand.addCard(card1);
        playerHand.addCard(card4);
        playerHand.addCard(card3);
        playerHand.calculateValue();
        assertEquals(19, playerHand.getHandValue());
    }

    @Test
    public void testClearHand(){
        playerHand.addCard(card1);
        playerHand.addCard(card4);
        playerHand.addCard(card3);
        playerHand.clearHand();
        assertEquals(0, playerHand.getPlayersCard().size());
    }

    @Test
    public void testClearHandAndCalculateHandValue(){
        playerHand.addCard(card1);
        playerHand.addCard(card4);
        playerHand.addCard(card3);
        playerHand.clearHand();
        assertEquals(0, playerHand.getHandValue());
    }


}