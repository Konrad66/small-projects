package org.example.zaawansowane.zad6;

public class TownApplication {

    public static void main(String[] args) {
        Town town1 = new Town();

        Townsman konrad = new Townsman("Konrad");
        Townsman wiktoria = new Townsman("Wiktoria");
        Townsman przemek = new Townsman("Przemek");
        King beata = new King("Beata");
        Peasant wiktor = new Peasant("Wiktor");

        town1.add(konrad);
        town1.add(wiktor);
        town1.add(wiktoria);
        town1.add(przemek);
        town1.add(beata);

    }
}
