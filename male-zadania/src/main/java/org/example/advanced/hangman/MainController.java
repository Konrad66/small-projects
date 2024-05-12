package org.example.advanced.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainController {


    void program() {
        String word = "komputer";
        System.out.println("Zagrajmy w wisielca, musisz odgadnąc słowo:");
        Scanner scanner = new Scanner(System.in);
        String guess = scanner.next();
        if (guess.equals(word)) {
            System.out.println("Brawo odgadłeś słowo");
        } else {
            System.out.println("Nie udało się :( Spróbuj następnym razem.");
        }

        int result = word.length();
        System.out.println(result);

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            System.out.print(letter + "-");
        }


    }


    //Rozlosuj


    // 1. Graj
    // 2. Tryb gry dwuosobowej - rywalizacja
    // 3. Tryb gry dwuosobowej - na przemian
    // 4. Wybierz słowo - użytkownik może wybrać długość słowa i takie zostanie wylosowane (int result = word.length();)
    // 0. opuść program
}
