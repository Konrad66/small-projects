package org.example.advanced.hangman;

import java.util.*;

public class HangmanService {

    private String correctWord = randomWord();
    private List<Character> availableLetters = preaperAvailableLetters();
    private int wrongAnswer = 0;


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

    public List<Character> getAvailableLetters() {
        return availableLetters;
    }

    String encodeWord(String word) {
        String result = "";
        word = word.toLowerCase();
        List<Character> notAvailableLetters = getNotAvailableLetters();
        for (int i = 0; i < notAvailableLetters.size(); i++) {
            notAvailableLetters.set(i, Character.toLowerCase(notAvailableLetters.get(i)));
        }
        for (int i = 0; i < word.length(); i++) {
            boolean guessed = false;
            for (int j = 0; j < notAvailableLetters.size(); j++) {
                if (word.charAt(i) == (notAvailableLetters.get(j))) {
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

    List<Character> getNotAvailableLetters() {
        List<Character> notAvailableLetters = new ArrayList<>();
        List<Character> allLetters = preaperAvailableLetters();

        for (Character letter : allLetters) {
            if (!availableLetters.contains(letter)) {
                notAvailableLetters.add(letter);
            }
        }
        return notAvailableLetters;
    }

    void clearLetters() {
        availableLetters = preaperAvailableLetters();
    }


    //todo omówić metodę czy nie lepiej jest zrobić ją w metodzie wyżej jako jedną a nie 2 osobne
    boolean userGuessed(String word) {
        String encodeWord = encodeWord(word);
        return !encodeWord.contains("-");
    }

    TryResult tryInput(String guess) {

        if (correctWord.equals(guess) || userGuessed(correctWord)) {
            clearLetters();
            return TryResult.YOU_GUESSED_WORD;
        }

        if (guess.length() <= 1) {
            availableLetters.remove(Character.valueOf(guess.charAt(0)));
            if (correctWord.contains(guess)) {
                return TryResult.YOU_GUESSED_LETTER;
            }
        }

        wrongAnswer++;
        printHangman(wrongAnswer);
        if (wrongAnswer == 6) {
            clearLetters();
            return TryResult.YOU_DONT_GUESSED_WORD;
        }
        return TryResult.YOU_DONT_GUESSED;
    }

    private List<Character> preaperAvailableLetters() {
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