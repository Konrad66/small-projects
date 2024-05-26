package org.example.advanced.hangman;

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

    String encodeWord(String word, List<String> guessedLetter) {
        String result = "";
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

    boolean userGuessed(String word, List<String> guessedLetter) {
        String encodeWord = encodeWord(word, guessedLetter);
        return !encodeWord.contains("-");
    }

    void printHangman(int wrongAnswer) {
        if (wrongAnswer >= 0 && wrongAnswer < HANGMAN_STAGES.length) {
            System.out.println(HANGMAN_STAGES[wrongAnswer]);
        }
    }

    private static final String[] HANGMAN_STAGES = {
            """
          +---+
          |   |
              |
              |
              |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
              |
              |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
          |   |
              |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
         /|   |
              |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
         /|\\  |
              |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
         /|\\  |
         /    |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
         /|\\  |
         / \\  |
              |
        =========
        """
    };
}