package org.example.basics;

import java.util.*;

public class Lottery {

    /*
    Projekt Loteria
Symulator loterii liczbowej:
wprowadzenie 6 liczb (1-24)
wylosowanie 6 liczb (1-24)
sprawdzenie, które liczby są trafione
wyświetlenie wyniku i nagrody:
0-2 = 0zł, 3 = 16 zł
4 = 200zł, 5 = 4 000 zł
6 = 1 500 000 zł
Użyj każdego z poznanych narzędzi: zmienna, operatory, warunek, tablice, Scanner, Random, Pętle..


wariant trudniejszy: Liczby wprowadzane ani liczby losowane nie mogą się  powtarzać.
     */

    public static void main(String[] args) {

        Set<Integer> myNumbers = new HashSet<>();
        Set<Integer> randomNumbers = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Wybierz 6 liczb z zakresu 1-24");


        while (myNumbers.size() < 6) {
            System.out.println("Podaj liczbę. Aktualnie podałeś: " + myNumbers.size());
            int myNumber = scanner.nextInt();
            if (0 >= myNumber || myNumber >= 25) {
                System.out.println("Nieprawidłowa liczba. Wybierz jeszcze raz.");
            } else {
                myNumbers.add(myNumber);
            }
        }

        System.out.print("Twoje liczby to: ");
        for (int number : myNumbers) {
            System.out.print(number + ", ");
        }
        System.out.println();

        while (randomNumbers.size() < 6) {
            int randomNumber = random.nextInt(24) + 1;
            randomNumbers.add(randomNumber);
        }

        System.out.print("Wylosowana liczby to: ");
        for (int number : randomNumbers) {
            System.out.print(number + ", ");
        }
        System.out.println();

        int guessed = 0;
        for (int myNumber : myNumbers) {
            for (int randomNumber : randomNumbers) {
                if (myNumber == randomNumber) {
                    guessed++;
                }
            }
        }
        System.out.println("Trafiłeś " + guessed);
        if (guessed <= 2) {
            System.out.println("Twoja nagroda to 0 zł");
        } else if (guessed == 3) {
            System.out.println("Twoja nagroda to 16 zł");
        } else if (guessed == 4) {
            System.out.println("Twoja nagroda to 200 zł");
        } else if (guessed == 5) {
            System.out.println("Twoja nagroda to 4 000zł");
        } else {
            System.out.println("Twoja nagroda to 1 500 000 zł");
        }
    }
}

//Wprowadź 6 liczb
//Podaj liczbę:
//4
//Podaj liczbę:
//3
//Podaj liczbę:
//4
//> już wybrałeś te liczbę!
//Podaj liczbę:
//8
//Podaj liczbę:
//1
//Podaj liczbę:
//88
//> za duża liczba!
//Podaj liczbę:
//22
//Podaj liczbę:
//13
//Wprowadzone liczby:
//4, 3, 8, 1, 22, 13
//Wylosowane liczby:
//1, 12, 4, 2, 21, 3
//Trafione liczby: 3
//Twoja nagroda: 16 zł!


//docelowo
//Podaj 6 liczb:
//3,6,4,8,1,12