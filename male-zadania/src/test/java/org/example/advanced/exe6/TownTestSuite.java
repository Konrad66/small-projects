package org.example.advanced.exe6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TownTestSuite {

    private Town town = new Town();
    private Peasant konrad = new Peasant("Konrad");
    private Townsman wiktoria = new Townsman("Wiktoria");
    private Townsman przemek = new Townsman("Przemek");
    private King beata = new King("Beata");
    private Peasant wiktor = new Peasant("Wiktor");

    @Test
    public void testAddTown() {
        town.add(konrad);
        assertEquals(1, town.getCitizens().size());
    }

    @Test
    public void testCanVote() {
        town.add(beata);
        town.add(wiktor);
        town.add(przemek);

        assertEquals(1, town.howManyCanVote());
    }

    @Test
    public void testWhoCanVote(){
        List<String> expectedNames = new ArrayList<>();
        town.add(beata);
        town.add(wiktor);
        town.add(przemek);
        expectedNames.add("Przemek");

        assertEquals(expectedNames, town.whoCanVote());
    }
}