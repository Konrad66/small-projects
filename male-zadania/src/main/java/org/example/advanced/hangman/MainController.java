package org.example.advanced.hangman;


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
                twoPlayerVersion();
            default:
                System.out.println("Wybierz z opcji poniżej.");
        }
    }

    private void soloPlayerVersion() {
        System.out.println("Celem gry jest odgadnięcie zakodowanego słowa. Powodzenia!");
        while (true) {
            printAlphabet();
            System.out.println("Zgadnij słowo: ");
            //System.out.println(hangmanService.getCorrectWord());
            System.out.println(hangmanService.encodeWord());
            String guess = input.readText();
            TryResult result = hangmanService.tryInput(guess);
            printResult(result);
        }
    }

    private void twoPlayerVersion() {
        System.out.println("Tryb rywalizacji w którym sami wpisujecie słowa do odgadnięcia. Powodzenia!");
        System.out.println("Wpisz ile rund chcecie rozegrac.");

        int numberOfRounds = input.readNumber();
        hangmanService.setNumberOfRounds(numberOfRounds);

        for(int i = 0; i < hangmanService.getNumberOfRounds(); i++){
            System.out.println("Wpisz słowo dla swojego przeciwnika: ");
            System.out.println("Gracz 1");
            String word1 = input.readText();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            play(word1);

            System.out.println("Pora się odegrać, wpisz słowo dla gracza 1:");
            System.out.println("Gracz 2");
            String word2 = input.readText();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            play(word2);
        }


    }

    private void printAlphabet() {
        for (Character c : hangmanService.getAvailableLetters()) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private void printResult(TryResult result) {
        switch (result) {
            case YOU_GUESSED_WORD:
                System.out.println("Brawo! Odgadłeś słowo!");
                return;
            case YOU_DONT_GUESSED_WORD:
                System.out.println("Przegrałeś!");
                return;
            case YOU_DONT_GUESSED:
                System.out.println("Nie trafiłeś. Spróbuj jeszcze raz.");
                break;
            case YOU_GUESSED_LETTER:
                System.out.println("Prawiodłowa litera! Brawo!");
                break;
        }
    }

    private void play(String word){
        while (true) {
            printAlphabet();
            System.out.println("Zgadnij słowo: ");
            hangmanService.preparedTwoPlayerVersion(word);
            System.out.println(hangmanService.encodeWord());
            String guess = input.readText();
            TryResult result = hangmanService.tryInput(guess);
            printResult(result);
            if(result.equals(TryResult.YOU_GUESSED_WORD)){
                break;
            } else if (result.equals(TryResult.YOU_DONT_GUESSED_WORD)) {
                break;
            }
        }
    }

// mozna dorobic "logowanie gracza" aby wybrac postac na ktorej beda sie liczyc pkt i robic statystyki
}