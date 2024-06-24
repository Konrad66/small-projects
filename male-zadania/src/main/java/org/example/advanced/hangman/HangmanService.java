package org.example.advanced.hangman;

import java.util.*;

public class HangmanService {

    private String correctWord = randomWord();

    String randomWord() {
        FileControl fileControl = new FileControl();
        List<String> words = fileControl.loadWords();
        Random random = new Random();
        int indexWord = random.nextInt(words.size());
        return words.get(indexWord);
    }

    public String getCorrectWord() {
        return correctWord;
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


    //todo omówić metodę czy nie lepiej jest zrobić ją w metodzie wyżej jako jedną a nie 2 osobne
    boolean userGuessed(String word, List<String> guessedLetter) {
        String encodeWord = encodeWord(word, guessedLetter);
        return !encodeWord.contains("-");
    }

    void tryInput(String guess) {

    }

    List<Character> availableLetters() {
        List<Character> availableLetters = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            availableLetters.add(ch);
        }
        return availableLetters;
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