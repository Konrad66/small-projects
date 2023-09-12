package org.example.advanced.dodgeball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardTestSuite {

    @Test
    public void createPlayersShouldCreate4Players(){
        Board board = new Board();
        board.createPlayers();
        int result = board.numberOfPlayers();
        Assertions.assertEquals(4, result);
    }

    @Test
    public void testBoard() {
        String expectedBoard = " K  *  *  *  *  *  *  *  *  P \n" +
                " *  *  *  *  *  *  *  *  *  * \n" +
                " *  *  *  *  *  *  *  *  *  * \n" +
                " *  *  *  *  *  *  *  *  *  * \n" +
                " *  *  *  *  *  *  *  *  *  * \n" +
                " *  *  *  *  *  *  *  *  *  * \n" +
                " *  *  *  *  *  *  *  *  *  * \n" +
                " *  *  *  *  *  *  *  *  *  * \n" +
                " *  *  *  *  *  *  *  *  *  * \n" +
                " W  *  *  *  *  *  *  *  *  D \n";

        Board board = new Board();
        board.createPlayers();
        Assertions.assertEquals(expectedBoard,board.composeBoardView());
    }
}