package org.example.advanced.blackjack;

class Controller {

    private boolean running = true;
    private Input input = new Input();
    private Service service = new Service();

    void startProgram() {
        do {
            printOptions();
            int choice = input.readNumber();
            executeOptions(choice);
        } while (running);
    }

    private void printOptions() {
        System.out.println("Witaj w grze karcianej - wojna.");
        System.out.println("0. Opuść gre");
        System.out.println("1. Zagraj z komputerem");
    }

    private void executeOptions(int choice) {
        switch (choice) {
            case 0:
                running = false;
            case 1:
                play();
        }
    }

    private void play() {
        System.out.println("Ile chcesz obstawić");
        Player player = service.getPlayer();
        Dealer dealer = service.getDealer();
        System.out.println("Player 1:");
        System.out.println(player);
        System.out.println("*****************");
        System.out.println("Dealer: ");
        System.out.println(dealer);
        System.out.println("*****************");
        System.out.println("Wybierz czy chcesz pociągnąć kolejną kartę czy chcesz spasować ruch");
        int choice = input.readNumber();

        decideAction(choice, player);
    }

    void decideAction(int choice, Player player){

        switch (choice){
            case 1: //draw
                player.takeCard();
                break;
            case 2: //pass
                //System.out.println("Gracz " + );
                break;
        }
    }



        /*

        ile chcemy dac pieniedzy na stół - masz ich 200
        20
        Gracz 2 tez daje 20

        Gracz 1:
        karta 1: 9
        karta 2 5
        ilosc pieniedzy na stole: 20
        *******************************
        gracz 2 (komputer)
        karta 1 10
        karta 2 9
        ilosc pieniedzy na stole : 20

        Krupier:
        karta 1 : 7
        zakryta karta 2: tej nie widzimy




        czy chcemy dobrac karte czy chcemy spasowac (decide): możesz napisać  "hit" lub "pass"
        hit


        GRacz dobrał karte wylosowała się: 7 kiero
        Gracz 2 (klomputer) nic nie dobrał, czyli spasował
        Gracz 1:
        karta 1: 9
        karta 2: 5
        Karta 3: 7
        ilosc pieniedzy na stole: 20
        *******************************
        gracz 2 (komputer)
        karta 1 10
        karta 2 9
        ilosc pieniedzy na stole : 20

        Krupier:
        karta 1 : 7
        zakryta karta 2: tej nie widzimy

        (sprawdzenie wyników)

        czy chcemy dobrac karte czy chcemy spasowac (decide): możesz napisać  "hit" lub "pass"
        pass

        gracz spasował
        komputer spasował
        krupier odsłania karte
        Gracz 1:
        karta 1: 9
        karta 2: 5
        Karta 3: 7
        ilosc pieniedzy na stole: 20
        *******************************
        gracz 2 (komputer)
        karta 1 10
        karta 2 9
        ilosc pieniedzy na stole : 20

        Krupier:
        karta 1 : 7
        zakryta karta 2: 7

        krupier musi dobrac kolejna karte, dobrał karte 8

        suma punktów krupiera wynosi 22
        Gracze wygrali


         */




//        int choice = input.readNumber();
//        service.numberOfDecksChecker(choice);
//        service.createDecks();
//        Player player1 = service.getPlayer();
//        System.out.println(player1);
//        service.dealCards();
//        service.dealRandomCard();



}