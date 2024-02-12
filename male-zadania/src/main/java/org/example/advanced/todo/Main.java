package org.example.advanced.todo;

import java.util.*;

public class Main {

    /*
    Aplikacja ma pomóc w budowaniu nawyków i oznaczanie które zrobiliśmy

    //możliwość dodania nawyku - nazwa, zrobiony/nie
    //pokaze nawyki które dodaliśmy -> kolejny wybór jako nawyk skończony


    1. Dodaj nawyk
    2. Oznacz jak ci idzie - widzimy czy któreś są zrobione czy nie
     */

    /*

    Działanie programu
    1. Dodaj nawyk
    2. Oznacz jak ci idzie

    1

    Podaj nazwe:
    Wypicie butelki wody

    1. Dodaj nawyk
    2. Oznacz jak ci idzie

    1

    Podaj nazwe:
    przeczytałeś książke

    1. Dodaj nawyk
    2. Oznacz jak ci idzie

    2

    Twoje nawyki:
    1. Wypicie butelki wody - NZ
    2. przeczytałeś książke - NZ
    3. Powrót do menu

    2

    Twoje nawyki:
    1. Wypicie butelki wody - NZ
    2. przeczytałeś książke - Z
    3. Powrót do menu

    3

    1. Dodaj nawyk
    2. Oznacz jak ci idzie

    2

    Twoje nawyki:
    1. Wypicie butelki wody - NZ
    2. przeczytałeś książke - Z
    3. Powrót do menu

    1

    Twoje nawyki:
    1. Wypicie butelki wody - Z
    2. przeczytałeś książke - Z
    3. Powrót do menu
    Gratulacje zrobiłeś dziś wszystkie nawyki!
     */


    public static void main(String[] args) {


        List<String> habits = new ArrayList<>();

        while (true) {
            System.out.println("Witaj w asystencie budowania nawyków. Wybierz opcje z listy nieżej:");
            System.out.println("1. Dodaj nawyk");
            System.out.println("2. Twoje nawyki");

            Scanner scanner = new Scanner(System.in);

            String wybor = scanner.next();

            switch (wybor) {
                case "1" -> {
                    System.out.println("Podaj nazwe nawyku");
                    String habitName = scanner.next();
                    habits.add(habitName);
                }
                case "2" -> {
                    System.out.println("Twoje nawyki");
                    for (String habit : habits) {
                        System.out.println(habit);

                    }
                }
                case "3" -> {
                    break;
                }
                default -> System.out.println("Zły wybór. Wybierz z listy poniżej");

            }
        }
    }
}