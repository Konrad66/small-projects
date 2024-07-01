package org.example.advanced.hangman;

import java.util.*;

public class HangmanService {

    private String correctWord = randomWord();
    private List<Character> availableLetters = prepareAvailableLetters();
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

    String encodeWord() {
        String result = "";
        correctWord = correctWord.toLowerCase();
        List<Character> notAvailableLetters = getNotAvailableLetters();
        for (int i = 0; i < notAvailableLetters.size(); i++) {
            notAvailableLetters.set(i, Character.toLowerCase(notAvailableLetters.get(i)));
        }
        for (int i = 0; i < correctWord.length(); i++) {
            boolean guessed = false;
            for (int j = 0; j < notAvailableLetters.size(); j++) {
                if (correctWord.charAt(i) == (notAvailableLetters.get(j))) {
                    guessed = true;
                }
            }
            String symbol;
            if (!guessed) {
                symbol = "-";
            } else {
                symbol = correctWord.charAt(i) + "";
            }
            result += " " + symbol + " ";
        }
        return result;
    }

    List<Character> getNotAvailableLetters() {
        List<Character> notAvailableLetters = new ArrayList<>();
        List<Character> allLetters = prepareAvailableLetters();

        for (Character letter : allLetters) {
            if (!availableLetters.contains(letter)) {
                notAvailableLetters.add(letter);
            }
        }
        return notAvailableLetters;
    }

    private List<Character> prepareAvailableLetters() {
        List<Character> availableLetters = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            availableLetters.add(ch);
        }
        return availableLetters;
    }

    void restartGame() {
        availableLetters = prepareAvailableLetters();
        wrongAnswer = 0;
        correctWord = randomWord();
    }

    TryResult tryInput(String guess) {

        if (correctWord.equals(guess) || !encodeWord().contains("-")) {
            restartGame();
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
            restartGame();
            return TryResult.YOU_DONT_GUESSED_WORD;
        }
        return TryResult.YOU_DONT_GUESSED;
    }

    void printHangman(int wrongAnswer) {
        if (wrongAnswer >= 0 && wrongAnswer < HANGMAN_STAGES.length) {
            System.out.println(HANGMAN_STAGES[wrongAnswer]);
        }
    }

    void   preparedTwoPlayerVersion(String userWord){
        correctWord = userWord;
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