package org.example.advanced.mastermind;

public class Controller {

    private Service service = new Service();
    private Input input = new Input();

    void play(){
        System.out.println("Witaj w grze mastermind. Powodzenia!");

        System.out.println("Wybierz ile znakow chcesz odgadnac");
        int numberOfSymbols = input.readNumber();
        service.setNumberOfSymbols(numberOfSymbols);


        service.drawSymbol();
        System.out.println();
        String guess = input.readText();

        service.checkAnswer(guess);
    }



}
