package org.example.advanced.mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Service {

    private List<String> symbols =  new ArrayList<>(List.of("+", "-", "*", "=", "!", "?"));
    private int numberOfSymbols = 0;



    void mastermind() {

        //po uruchomineniu programu
        // program wyswietla 4 uzyte znaki ktore zostaly zakodowane
        // program losuje dwie niewiadome z 4
        //uzytkownik ma mozliwosc wpisania niewiadomych
        // po wpisaniu wszystkich
        // program sprawdza czy sie zgadzaja


        // + * - = ? !


        Random random = new Random();
        int randomIndex = random.nextInt(symbols.size());
        System.out.println(symbols.get(randomIndex));

    }


    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }
}
