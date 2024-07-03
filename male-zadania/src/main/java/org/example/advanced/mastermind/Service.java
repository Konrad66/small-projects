package org.example.advanced.mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Service {

    private List<String> symbols =  new ArrayList<>(List.of("+", "-", "*", "=", "!", "?"));
    private int numberOfSymbols = 0;


//po uruchomineniu programu
    // program wyswietla 4 uzyte znaki ktore zostaly zakodowane
    // program losuje dwie niewiadome z 4
    //uzytkownik ma mozliwosc wpisania niewiadomych
    // po wpisaniu wszystkich
    // program sprawdza czy sie zgadzaja


    // + * - = ? !


    void randomCode() {
        Random random = new Random();
        int randomIndex = random.nextInt(symbols.size());
        System.out.println(symbols.get(randomIndex));


        for (int i = 0; i < getNumberOfSymbols(); i++){

        }
    }

//    void encode(){
//        String result = " ";
//        System.out.println(symbols);
//        for (int i = 0; i < getNumberOfSymbols(); i++){
//            boolean guessed = false;
//        }
//        for (int j = 0; j < symbols.size(); j++){
//            if (){
//            }
//        }
//    }




    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }
}
