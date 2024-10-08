package org.example.advanced.mastermind;

class Controller {

    private boolean running = true;
    private Service service = new Service();
    private Input input = new Input();

    void startProgram() {
        do {
            printOptions();
            int decision = input.readNumber();
            executeOptions(decision);
        } while (running);
    }

    private void printOptions() {
        System.out.println("Witaj w grze mastermind. Powodzenia!");
        System.out.println("0. Wyjdz");
        System.out.println("1. Graj");
    }

    private void executeOptions(int decision) {
        switch (decision) {
            case 0:
                running = false;
                break;
            case 1:
                play();
        }
    }

    private void play() {
        service.restartGame();
        System.out.println("Wybierz ile znakow chcesz odgadnac");
        int numberOfSymbols = input.readNumber();
        service.setNumberOfSymbols(numberOfSymbols);
        service.drawSymbol();

        String guess;
        do {
            guess = input.readText();
            System.out.println(service.checkAnswer(guess));
            System.out.println("Pozostało Ci " + (10 - service.getAttempts()) + " prob!");
        } while (!service.isCorrectGuess(guess) && service.hasAttemptsLeft());
    }
}