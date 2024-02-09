package org.example.advanced.todo;

import java.util.Scanner;

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


        System.out.println("Witaj w asystencie budowania nawyków. Wybierz opcje z listy nieżej:");
        System.out.println("1. Dodaj nawyk");
        System.out.println("2. Twoje nawyki");

        Scanner scanner = new Scanner(System.in);

        String wybor = scanner.next();

        if(wybor.equals("1")){
            System.out.println("Przechodzimy dalej");
        } else {
            System.out.println("Jeszcze nie działa");
        }

    }

}
