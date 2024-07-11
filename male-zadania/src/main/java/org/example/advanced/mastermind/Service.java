package org.example.advanced.mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Service {

    private List<String> symbols = new ArrayList<>(List.of("+", "-", "*", "=", "!", "?", "/", "#"));
    private int numberOfSymbols = 0;
    private String symbolsEncode = "";
    private int attempts = 0;
    private final int maxAttempts = 10;

    //todo zrobic warunek do wygrania i przegrania
    //todo powtarzanie rozgrywki
    //todo sprobowac znalezc błąd w drukowaniu wyników
    //todo zastanowic sie co dodac od siebie do gry
    //tryb dla dwóch graczy
    //jakieś statystyki (punktacja, po jakim czasie odgadneliśmy hasło)
    //może by się udało w LibGDX graficzną wersje albo coś innego
    //może historię rozgrywek?
    //todo pomyslec nad kolejna gra
    //gra w kółko i krzyżyk
    //może kolejna aplikacja do zarządzania czymś? (biblioteka, wypożyczalnia samochodów, zarządzanie danymi osobowymi,
    //blackjack
    //wojna
    //kamien papier nozyce
    //poker


    void restartGame() {
        attempts = 0;
    }

    void drawSymbol() {
        symbolsEncode = "";
        Random random = new Random();
        for (int i = 0; i < getNumberOfSymbols(); i++) {
            int randomIndex = random.nextInt(symbols.size());
            symbolsEncode += symbols.get(randomIndex);
        }
        printEncodeSymbols();
    }

    private void printEncodeSymbols() {
        System.out.println(symbolsEncode);
    }

    String checkAnswer(String guess) {
        StringBuilder guessBuilder = new StringBuilder(guess);
        StringBuilder symbolsEncodeBuilder = new StringBuilder(symbolsEncode);
        char unavailableSymbol = ')';
        String result = "";
        attempts++;
        for (int i = 0; i < symbolsEncode.length(); i++) {
            if (symbolsEncodeBuilder.charAt(i) == guessBuilder.charAt(i)) {
                result += "R";
                guessBuilder.setCharAt(i, unavailableSymbol);
                symbolsEncodeBuilder.setCharAt(i, unavailableSymbol);
            }
        }

        for (int i = 0; i < symbolsEncodeBuilder.length(); i++) {
            for (int j = 0; j < guess.length(); j++) {
                char guessSymbol = guessBuilder.charAt(j);
                char encodeSymbol = symbolsEncodeBuilder.charAt(i);
                if (encodeSymbol == guessSymbol && encodeSymbol != unavailableSymbol && i != j) {
                    result += "W";
                    guessBuilder.setCharAt(j, unavailableSymbol);
                    symbolsEncodeBuilder.setCharAt(i, unavailableSymbol);
                    break;
                }
            }
        }
        return result;
    }


    private int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }

    int getAttempts() {
        return attempts;
    }

    boolean isCorrectGuess(String guess) {
        // /++!
        // ----  -> false
        // /--- -> true
        for (int i = 0; i < numberOfSymbols; i++) {
            if (symbolsEncode.charAt(i) != guess.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    boolean hasAttemptsLeft() {
        if (attempts >= maxAttempts) {
            return false;
        }
        return true;
    }

    // +++-
    // //++
    //RW     // RWW ?

    // +---
    // //++
    // W

    //- For each color in your guess that is in the correct color but is NOT in the correct position in the code sequence,
    // the computer display a small white color on the right side of the current guess.
    // +---
    // /+++
    //W
    //WWW?

    //String = "R"
    // + # ! = wersja dla nas
    // # ! # !       -     - nasze odp

// R W


    /// sprawdzanie
    // ?!-!
    // ?!??
    // [R, R, B, W]


    //dostajemy znak
    // sprawdzamy znak z kazdym miejscem zakodowanego hasla
    // jezeli znak zgadza sie z ktoryms w zakodowanym hasle/
    // prinmtujemy odpowiedz


//    String encodeSymbol(){
//        String result = " ";
//
//
//
//    }


}

// czarne - nie trafiony i nie ma symbolu w zakodowanym haśle
// biały - symbol znajduje się w zakodowanym haśle ale na innym miejscu
// czerwony - symbol znajduje się w zakodowanym haśle i jest w dobrym miejscu


//zakodowane znaki zostaną odkodowane w momencie gdy uzytkownik wygra lub przegra

//Spróbuj znaleźć zakodowane symbole:
// + * - = ? ! / #
//( + # ! =) wersja dla nas
// - - - -
// +-/! -- nasze odp

// R W

// -!/= -- nasze odp

// R W


//po uruchomineniu programu
// program wyswietla 4 uzyte znaki ktore zostaly zakodowane
// program losuje dwie niewiadome z 4
//uzytkownik ma mozliwosc wpisania niewiadomych
// po wpisaniu wszystkich
// program sprawdza czy sie zgadzaja


//+++ - zakodowane hasło
// dodatkowa zmienna

// +--
// +++
// R, B, B

//ładowanie naszego hasła

// ++-


// -=*/#/
// /))))/
// [B, B, B, W, B, W]


