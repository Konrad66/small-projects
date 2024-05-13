package org.example.advanced.hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class MainController {

    void program() {
        ArrayList<String> letters = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        HangmanService hangmanService = new HangmanService();
        String word = hangmanService.losujSlowo();
        while (true) {
            System.out.println("Zagrajmy w wisielca, musisz odgadnąc słowo:");
            System.out.println(hangmanService.zakodujSlowo(word, letters));
            String guess = scanner.next();
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