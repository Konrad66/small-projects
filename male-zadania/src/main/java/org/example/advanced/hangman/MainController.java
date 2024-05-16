package org.example.advanced.hangman;

import java.util.ArrayList;

public class MainController {

    private boolean running = true;
    private Input input = new Input();

    void startProgram() {
        do {
            printOptions();
            int decision = input.readNumber();
            executeOptions(decision);
        } while (running);
    }

    void printOptions() {
        System.out.println("Witaj w grze wisielec. Poniżej masz do wyboru kilka trybów rozgrywki.");

        System.out.println("1. Tryb gry podstawowej");
        System.out.println("0. Opuść program");
    }

    private void executeOptions(int decission) {
        switch (decission) {
            case 0:
                running = false;
                break;
            case 1:
                program();
                break;
            default:
                System.out.println("Wybierz z opcji poniżej.");
        }

    }

    void program() {
        ArrayList<String> letters = new ArrayList<>();
        HangmanService hangmanService = new HangmanService();
        String word = hangmanService.randomWord();
        while (true) {
            System.out.println("Zagrajmy w wisielca, musisz odgadnąc słowo:");
            System.out.println(hangmanService.encodeWord(word, letters));
            String guess = input.readText();
            letters.add(guess);
            if (guess.equals(word)) {
                System.out.println("Brawo odgadłeś słowo");
            } else {
                System.out.println("Nie udało się :( Spróbuj następnym razem.");
            }
        }
    }

    //mam haslo niezakodowane
    //zamieniam wszystkie slowa na myslinki
    //efekt dla "Ala" -> "_ _ _"

    //Rozlosuj


    // 1. Graj
    // 2. Tryb gry dwuosobowej - rywalizacja
    // 3. Tryb gry dwuosobowej - na przemian
    // 4. Wybierz słowo - użytkownik może wybrać długość słowa i takie zostanie wylosowane (int result = word.length();)
    // 0. opuść program
    // mozna dorobic "logowanie gracza" aby wybrac postac na ktorej beda sie liczyc pkt i robic statystyki


    //kolko i krzyzyk
    //blackjack
    //wojna
    //kamien paoier nozyce
    //poker
    //moje zadania z arkusza
    //mastermind -> z symbolami lub liczbami
}