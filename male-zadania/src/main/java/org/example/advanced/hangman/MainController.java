package org.example.advanced.hangman;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MainController {

    private boolean running = true;
    private Input input = new Input();
    private HangmanService hangmanService = new HangmanService();

    void startProgram() {
        do {
            printOptions();
            int decision = input.readNumber();
            executeOptions(decision);
        } while (running);
    }

    private void printOptions() {
        System.out.println("Witaj w grze wisielec. Poniżej masz do wyboru kilka trybów rozgrywki.");
        System.out.println("1. Tryb gry jednoosobowej");
        System.out.println("2. Tryb gry dwuosobowej");
        System.out.println("0. Opuść program");
    }

    private void executeOptions(int decision) {
        switch (decision) {
            case 0:
                running = false;
                break;
            case 1:
                soloPlayerVersion();
                break;
            case 2:
                //twoPlayerVersion();
            default:
                System.out.println("Wybierz z opcji poniżej.");
        }
    }

    private void soloPlayerVersion() {
        String word = hangmanService.getCorrectWord();
        System.out.println("Celem gry jest odgadnięcie zakodowanego słowa. Powodzenia!");


        List<Character> availableLetters = hangmanService.getAvailableLetters();

        while (true) {
            for (Character c : availableLetters) {
                System.out.print(c + " ");
            }

            System.out.println();
            System.out.println("Zgadnij litere: ");
            System.out.println(word);
            System.out.println(hangmanService.encodeWord(word));
            String guess = input.readText();

            TryResult result = hangmanService.tryInput(guess);
            switch (result){
                case YOU_GUESSED_WORD -> System.out.println("Brawo! Odgadłeś słowo!");
                case YOU_DONT_GUESSED_WORD -> System.out.println("Przegrałeś!");
                case YOU_DONT_GUESSED -> System.out.println("Nie trafiłeś. Spróbuj jeszcze raz.");
                case YOU_GUESSED_LETTER -> System.out.println("Prawiodłowa litera! Brawo!");
            }
        }
    }

//    private void twoPlayerVersion() {
//        System.out.println("Tryb rywalizacji w którym na zmianę gracz wybiera słowo do odgadnięcia dla drugiego gracza. Powodzenia!");
//        System.out.println("Proszę aby gracz 1 wpisał słowo dla gracza 2:");
//        String word1 = input.readText();
//        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//
//
//        int wrongAnswer = 0;
//
//        while (true) {
//            System.out.println("Poniżej masz słowo do odgadnięcia powodzenia:");
//            System.out.println(hangmanService.encodeWord(word1, letters));
//            String guess = input.readText();
//            letters.add(guess);
//            if (!word1.contains(guess)) {
//                wrongAnswer++;
//                hangmanService.printHangman(wrongAnswer);
//            }
//            if (wrongAnswer == 6) {
//                System.out.println("Tym razem się nie udało. Spróbuj następnym razem. Słowo to " + word1);
//                break;
//            }
//            if (hangmanService.userGuessed(word1, letters)) {
//                System.out.println("Brawo! Odgadłeś słowo!");
//                break;
//            }
//        }
//
//        System.out.println("Pora się odegrać, wpisz słowo dla gracza 1:");
//        String word2 = input.readText();
//        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//        wrongAnswer = 0;
//
//        while (true) {
//            System.out.println("Poniżej masz słowo do odgadnięcia powodzenia:");
//            System.out.println(hangmanService.encodeWord(word2, letters));
//            String guess = input.readText();
//            letters.add(guess);
//            if (!word2.contains(guess)) {
//                wrongAnswer++;
//                hangmanService.printHangman(wrongAnswer);
//            }
//            if (wrongAnswer == 6) {
//                System.out.println("Tym razem się nie udało. Spróbuj następnym razem. Słowo to " + word2);
//                break;
//            }
//            if (hangmanService.userGuessed(word2, letters)) {
//                System.out.println("Brawo! Odgadłeś słowo!");
//                break;
//            }
//        }
//    }

    //todo wersja dwuosobowa


// mozna dorobic "logowanie gracza" aby wybrac postac na ktorej beda sie liczyc pkt i robic statystyki
}