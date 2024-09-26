package org.example.advanced.blackjack;


class Service {

    private Player player = new Player();
    private Dealer dealer = new Dealer();
    private Deck deck = new Deck();


    void startGame() {
        deck.restartDeck();

    }




}
//todo stworzenie krupiera narazie w service
//todo gracz decyduje czy chce pasowac czy dobierac karte
//todo warunek do wygrania
//todo w przypadku komputera mozna zrobi ze jeden dobiera np od sumy 15 a drugi np tylko od 17
//


//zalozenia blackjack
// w najczestrzych konfiguracjach uzywa sie od 6 do 8 tali;
// krupier rozdaje dwie karty, a następnie gracz może prosić o dobranie kart, aż osiągnie 21 punktów
// Z kolei krupier dopiera karty do 17 oczek
// w grze moze maksymalnie uczestniczyc 7 graczy;
//karta krupiera odzsłania się w momencie jak wszyscy gracze spasują


//wykładamy dwie karty, mamy informacje