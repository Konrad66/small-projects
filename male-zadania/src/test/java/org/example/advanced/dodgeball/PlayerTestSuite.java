package org.example.advanced.dodgeball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTestSuite {

    static Player player = new HumanPlayer("Player1", 1, 0);


    @ParameterizedTest
    @CsvSource({"S,1,1", "D,2,1", "W,2,0", "D,3,0"})
    public void executeMoveShouldChangePositions(String input, int expectedX, int expectedY) {
        boolean correctMove = player.executeMove(input);
        Assertions.assertEquals(expectedX, player.getX());
        Assertions.assertEquals(expectedY, player.getY());
        Assertions.assertTrue(correctMove);
    }

    @Test
    public void newPlayerShouldStoreData() {
        Player newplayer = new HumanPlayer("newPlayer", 1, 0);
        Assertions.assertEquals(1, newplayer.getX());
        Assertions.assertEquals(0, newplayer.getY());
        Assertions.assertEquals("newPlayer", newplayer.getName());
    }

    @ParameterizedTest
    @CsvSource({"W,0,0", "A,0,0", "S,9,9", "D,9,9"})
    public void shouldNotAllowCrossingBorder(String input, int startingX, int startingY) {
        Player cornerPlayer = new HumanPlayer(null, startingX, startingY);
        boolean correctMove = cornerPlayer.executeMove(input);
        Assertions.assertEquals(startingX, cornerPlayer.getX());
        Assertions.assertEquals(startingY, cornerPlayer.getY());
        Assertions.assertFalse(correctMove);
    }


    //TODO sprawdzić co się stanie jeżeli wybiorę inny ruch

}