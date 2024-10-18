package org.example.basics.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        reverseArray();
        minimalValue();
        countAttempts();
    }


    public static void reverseArray() {
        int[] liczby = {1, 2, 3, 4, 5};
        int length = liczby.length;

        for (int i = 0; i < length / 2; i++) {
            int temp = liczby[i];
            liczby[i] = liczby[length - i - 1];
            liczby[length - i - 1] = temp;
        }

        System.out.println(Arrays.toString(liczby)); // Wyjście: [5, 4, 3, 2, 1]
    }

    public static void minimalValue() {
        /*
        Zadanie 1: Znajdowanie minimalnej wartości w tablicy

Stwórz tablicę int o dowolnych wartościach.
Znajdź i wypisz najmniejszą wartość w tej tablicy.
         */

        int[] numbers = {4, 3, 66, 1, 15, -2};
        int minValue = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            if (minValue > numbers[i]) {
                minValue = numbers[i];
            }
        }
        System.out.println(minValue);
    }

    public static void countAttempts() {
        /*
        Zadanie 2: Liczenie wystąpień liczby w tablicy

Stwórz tablicę liczb całkowitych oraz zmienną szukanaLiczba.
Napisz program, który zliczy, ile razy szukanaLiczba występuje w tablicy.
         */

        System.out.println("Podaj liczbe którą chcesz policzyć ile razy wystąpiła");
        Scanner scanner = new Scanner(System.in);
        int searchedNumber = scanner.nextInt();
        int counter = 0;
        int[] number = {1, 2, 45, -4, 1, 25, 1, 7};
        for (int i = 0; i < number.length; i++) {
            if (searchedNumber == number[i]) {
                counter++;
            }
        }
        System.out.println("Szukana liczba wystąpiła: " + counter + " razy w tablicy");
    }

    public static void isPalindrom() {
        int[] numbers = {1, 2, 3, 2, 1};

        for (int i = 0; i < numbers.length / 2; i++) {
            if(numbers[i] == numbers[numbers.length - i -1]){

            }
        }
    }
}