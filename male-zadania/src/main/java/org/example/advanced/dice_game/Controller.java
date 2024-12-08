package org.example.advanced.dice_game;

public class Controller {

    private boolean running = true;
    private Input input = new Input();
    private GameService service = new GameService();

    void startGame() {
        do {
            printOption();
            int choice = input.readNumber();
            executeOptions(choice);
        } while (running);


    }

    void printOption() {
        System.out.println("Witaj w grze w kości:");
        System.out.println("0. Opuść program");
        System.out.println("1. Rozpocznij gre");
    }

    void executeOptions(int choice) {
        switch (choice) {
            case 0:
                running = false;
                System.out.println("Opuściłeś program.");
            case 1:
                printRoundOptions();
                int decision = input.readNumber();
                service.round(decision);

            default:
                System.out.println("Zły wybór. Spróbuj jeszcze raz.");
        }
    }

    void printRoundOptions(){
        System.out.println("1. Rzuć kośćmi");
        System.out.println("2. Zatrzymaj aktualne punkty");
    }
}