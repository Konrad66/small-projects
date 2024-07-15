package org.example.advanced.blackjack;

class Controller {

    private boolean running = true;
    private Input input = new Input();
    private Service service = new Service();

    void startProgram() {
        do {
            printOptions();
            int choice = input.readNumber();
            executeOptions(choice);
        } while (running);
    }

    private void printOptions() {
        System.out.println("Witaj w grze karcianej - wojna.");
        System.out.println("0. Opuść gre");
        System.out.println("1. Zagraj z komputerem");
    }

    private void executeOptions(int choice) {
        switch (choice) {
            case 0:
                running = false;
            case 1:
                play();
        }
    }

    private void play(){
        service.createCards();
        service.dealCards();
    }
}