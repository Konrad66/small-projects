package org.example.advanced.mastermind;

public class AnswerChecker {

  private static final   char UNAVAILABLE_SYMBOL = ')';

    private StringBuilder guessBuilder = new StringBuilder();
    private StringBuilder symbolsEncodeBuilder = new StringBuilder();


    String checkAnswer(String guess, String symbolsEncode){
        guessBuilder.append(guess);
        symbolsEncodeBuilder.append(symbolsEncode);
        int reds = deleteReds();
        int whites = deleteWhites();
        return "R".repeat(reds) + "W".repeat(whites);
    }

    private int deleteReds() {
        int howManyReds = 0;
        for (int i = 0; i < symbolsEncodeBuilder.length(); i++) {
            if (symbolsEncodeBuilder.charAt(i) == guessBuilder.charAt(i)) {
                howManyReds++;
                guessBuilder.setCharAt(i, UNAVAILABLE_SYMBOL);
                symbolsEncodeBuilder.setCharAt(i, UNAVAILABLE_SYMBOL);
            }
        }
        return howManyReds;
    }

    private int deleteWhites() {
        int howManyWhites = 0;
        for (int i = 0; i < symbolsEncodeBuilder.length(); i++) {
            for (int j = 0; j < guessBuilder.length(); j++) {
                char guessSymbol = guessBuilder.charAt(j);
                char encodeSymbol = symbolsEncodeBuilder.charAt(i);
                if (encodeSymbol == guessSymbol && encodeSymbol != UNAVAILABLE_SYMBOL && i != j) {
                    howManyWhites++;
                    guessBuilder.setCharAt(j, UNAVAILABLE_SYMBOL);
                    symbolsEncodeBuilder.setCharAt(i, UNAVAILABLE_SYMBOL);
                    break;
                }
            }
        }
        return howManyWhites;
    }

}
