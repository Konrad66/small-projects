package org.example.advanced.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTestSuite {

   private Hand playerHand = new Hand();
   private Card ace = new Card(Suit.CLUBS, CardValue.ACE);
   private Card eight = new Card(Suit.DIAMONDS, CardValue.EIGHT);
   private Card king = new Card(Suit.SPADES, CardValue.KING);

    @Test
    public void shouldAddCardsToPlayerHands() {
        playerHand.addCard(ace);
        playerHand.addCard(king);
        assertEquals(2, playerHand.getPlayersCard().size());
    }

    @Test
    public void testIsBust() {
        playerHand.addCard(king);
        playerHand.addCard(king);
        playerHand.addCard(eight);
        assertTrue(playerHand.isBust());
    }

    @Test
    public void testIsntBust() {
        playerHand.addCard(ace);
        playerHand.addCard(king);
        playerHand.addCard(eight);
        assertFalse(playerHand.isBust());
    }

    @Test
    public void testCalculateValueWithTwoAces() {
        playerHand.addCard(ace);
        playerHand.addCard(ace);
        playerHand.addCard(eight);
        assertEquals(20, playerHand.calculateValue());
    }

    @Test
    public void test2CalculateValueWithAce() {
        playerHand.addCard(ace);
        playerHand.addCard(king);
        playerHand.addCard(eight);
        assertEquals(19, playerHand.calculateValue());
    }

    @Test
    public void testClearHand(){
        playerHand.addCard(ace);
        playerHand.addCard(king);
        playerHand.addCard(eight);
        playerHand.clearHand();
        assertEquals(0, playerHand.getPlayersCard().size());
    }

    @Test
    public void testClearHandAndCalculateHandValue(){
        playerHand.addCard(ace);
        playerHand.addCard(king);
        playerHand.addCard(eight);
        playerHand.clearHand();
        assertEquals(0, playerHand.calculateValue());
    }

    @Test
    public void test3CalculateValue() {
        playerHand.addCard(ace);
        playerHand.addCard(king);
        assertEquals(21, playerHand.calculateValue());
    }


    //todo testy parametryzowane



}