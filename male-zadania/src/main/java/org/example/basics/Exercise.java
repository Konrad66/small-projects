package org.example.basics;

import java.util.Scanner;

public class Exercise {

    public static void main(String[] args) {
        String text = "Dzisiaj 13 pazdziernika jest deszczowy dzien.";
        //Stwórz program, który liczy liczbę wystąpień danego znaku w wprowadzonym przez użytkownika tekście.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz znak który policzyć w tekście poniżej.");
        System.out.println(text);


        char sign = scanner.next().charAt(0);
        int signCounter = 0;

        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == sign){
                signCounter++;
            }
        }


    }
}
