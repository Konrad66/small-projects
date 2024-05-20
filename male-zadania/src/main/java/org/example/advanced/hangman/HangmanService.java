package org.example.advanced.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HangmanService {

    String randomWord() {
        FileControl fileControl = new FileControl();
        List<String> words = fileControl.loadWords();
        Random random = new Random();
        int indexWord = random.nextInt(words.size());
        return words.get(indexWord);
    }

    //masz slowo i odgadniete litery
    //zacznij od pustego napisu jako wynik
    //zamieniam slowo i odgadniete litery na male
    //dla kazdej litery slowa
    // która nie jest zadna z odgadnietych liter
    //dodaj do wyniku kreske
    // w przeciwnym razie dodaj odgadnieta litere


    //jesli ta litera == odgadnieta litera
    // zamien kreske na litere

    String encodeWord(String word, List<String> guessedLetter) {
        String result = "";
        int correctAttempts;
        word = word.toLowerCase();
        for (int i = 0; i < guessedLetter.size(); i++) {
            guessedLetter.set(i, guessedLetter.get(i).toLowerCase());
        }
        for (int i = 0; i < word.length(); i++) {
            boolean guessed = false;
            for (int j = 0; j < guessedLetter.size(); j++) {
                if ((word.charAt(i) + "").equals(guessedLetter.get(j))) {
                    guessed = true;
                }
            }
            String symbol;
            if (!guessed) {
                symbol = "-";
            } else {
                symbol = word.charAt(i) + "";
            }
            result += " " + symbol + " ";
        }
        return result;
    }

//    public static void main(String[] args) {
//        HangmanService hangmanService = new HangmanService();
//        ArrayList<String> letters = new ArrayList<>();
//        letters.add("k");
//        letters.add("o");
//        letters.add("h");
//        System.out.println(hangmanService.encodeWord("Komputer", letters));
//        // A _ a
//    }
}