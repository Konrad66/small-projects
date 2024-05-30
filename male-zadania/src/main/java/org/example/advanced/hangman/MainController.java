package org.example.advanced.hangman;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MainController {

    private boolean running = true;
    private Input input = new Input();
    private HangmanService hangmanService = new HangmanService();
    private ArrayList<String> letters = new ArrayList<>();

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
                twoPlayerVersion();
            default:
                System.out.println("Wybierz z opcji poniżej.");
        }
    }

    private void soloPlayerVersion() {
        String word = hangmanService.randomWord();
        System.out.println("Celem gry jest odgadnięcie zakodowanego słowa. Powodzenia!");

        List<Character> availableLetters = new ArrayList<>();
        char ch;
        for (ch = 'A'; ch <= 'Z'; ++ch) {
            System.out.print(ch + " ");
            availableLetters.add(ch);
        }

        int wrongAnswer = 0;

        while (true) {
            System.out.println("Zgadnij litere: ");
            System.out.println();
            //System.out.println(word);
            System.out.println(hangmanService.encodeWord(word, letters));
            String guess = input.readText();

            letters.add(guess);

            if (!word.contains(guess)) {
                wrongAnswer++;
                hangmanService.printHangman(wrongAnswer);
            }
            if (wrongAnswer == 6) {
                System.out.println("Tym razem się nie udało. Spróbuj następnym razem. Słowo to " + word);
                //letters.removeAll(word);
                break;
            }
            if (hangmanService.userGuessed(word, letters)) {
                System.out.println("Brawo! Odgadłeś słowo!");
                break;
            }
        }
    }

    private void twoPlayerVersion() {
        System.out.println("Tryb rywalizacji w którym na zmianę gracz wybiera słowo do odgadnięcia dla drugiego gracza. Powodzenia!");
        System.out.println("Proszę aby gracz 1 wpisał słowo dla gracza 2:");
        String word1 = input.readText();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");


        int wrongAnswer = 0;

        while (true) {
            System.out.println("Poniżej masz słowo do odgadnięcia powodzenia:");
            System.out.println(hangmanService.encodeWord(word1, letters));
            String guess = input.readText();
            letters.add(guess);
            if (!word1.contains(guess)) {
                wrongAnswer++;
                hangmanService.printHangman(wrongAnswer);
            }
            if (wrongAnswer == 6) {
                System.out.println("Tym razem się nie udało. Spróbuj następnym razem. Słowo to " + word1);
                break;
            }
            if (hangmanService.userGuessed(word1, letters)) {
                System.out.println("Brawo! Odgadłeś słowo!");
                break;
            }
        }

        System.out.println("Pora się odegrać, wpisz słowo dla gracza 1:");
        String word2 = input.readText();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        wrongAnswer = 0;

        while (true) {
            System.out.println("Poniżej masz słowo do odgadnięcia powodzenia:");
            System.out.println(hangmanService.encodeWord(word2, letters));
            String guess = input.readText();
            letters.add(guess);
            if (!word2.contains(guess)) {
                wrongAnswer++;
                hangmanService.printHangman(wrongAnswer);
            }
            if (wrongAnswer == 6) {
                System.out.println("Tym razem się nie udało. Spróbuj następnym razem. Słowo to " + word2);
                break;
            }
            if (hangmanService.userGuessed(word2, letters)) {
                System.out.println("Brawo! Odgadłeś słowo!");
                break;
            }
        }
    }

    //jak zakonc

// 1. Graj
// 2. Tryb gry dwuosobowej - rywalizacja
// 3. Wybierz słowo - użytkownik może wybrać długość słowa i takie zostanie wylosowane (int result = word.length();)
// 0. opuść program
// mozna dorobic "logowanie gracza" aby wybrac postac na ktorej beda sie liczyc pkt i robic statystyki
}