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
    1. Wypicie butelki wody - NZ (0)
    2. przeczytałeś książke - NZ (0)
    3. Powrót do menu

    2

    Twoje nawyki:
    1. Wypicie butelki wody - NZ (0)
    2. przeczytałeś książke - Z (1)
    3. Powrót do menu

    3

    1. Dodaj nawyk
    2. Oznacz jak ci idzie

    2

    Twoje nawyki:
    1. Wypicie butelki wody - NZ (0)
    2. przeczytałeś książke - Z (1)
    3. Powrót do menu

    1

    Twoje nawyki:
    1. Wypicie butelki wody - Z (1)
    2. przeczytałeś książke - Z (1)
    3. Powrót do menu
    Gratulacje zrobiłeś dziś wszystkie nawyki!

    >wyzeruj dzień

    Twoje nawyki:
    1. Wypicie butelki wody - NZ (1)
    2. przeczytałeś książke - NZ (1)
    3. Powrót do menu
     */

    public static void main(String[] args) {

        while (true) {
            System.out.println("Witaj w asystencie budowania nawyków. Wybierz opcje z listy nieżej:");
            System.out.println("1. Dodaj nawyk");
            System.out.println("2. Usuń nawyki");
            System.out.println("3. Twoje nawyki");
            System.out.println("4. Nowy dzień");
            System.out.println("9. Wyjdź z asystenta");

            Scanner scanner = new Scanner(System.in);
            String wybor = scanner.next();

            switch (wybor) {
                case "1" -> {
                    System.out.println("Podaj nazwe nawyku");
                    String habitName = scanner.next();
                    habits.add(new Habit(habitName, false));
                }
                case "2" -> {
                    while (true) {
                        System.out.println("Który z nawyków chcesz usunąć? Jak chcesz wrócic do menu wciśnij 0.");
                        printHabits();
                        int removeHabit = scanner.nextInt();
                        if (removeHabit == 0) {
                            break;
                        }
                        habits.remove(removeHabit - 1);
                    }
                }
                case "3" -> {
                    while (true) {
                        System.out.println("Twoje nawyki ponizej. Wybierz ktory udalo Ci się dziś zrobić. Jesli chcesz wrócić do menu wpisz 0");
                        printHabits();
                        int choice = scanner.nextInt();
                        if (choice == 0) {
                            break;
                        }
                        habits.get(choice - 1).doHabit();
                        allCompleted();
                    }
                }
                case "4" -> {
                    for (Habit habit : habits) {
                        habit.isDone = false;
                    }
                    System.out.println("Witaj w nowym dniu. Powodzenia z dzisiejszymi nawykami.");
                }
                case "9" -> {
                    return;
                }
                default -> System.out.println("Zły wybór. Wybierz z listy poniżej");
            }
        }
    }

    static List<Habit> habits = new ArrayList<>();

    public static void allCompleted() {
        boolean wszystkieZrobione = true;
        for (Habit habit : habits) {
            if (habit.isDone == false) {
                wszystkieZrobione = false;
            }
        }
        if (wszystkieZrobione) {
            System.out.println("Super, zrobiles wszystkie nawyki");

        }
    }

    public static void printHabits() {
        int count = 1;
        for (Habit habit1 : habits) {
            System.out.println(count + ". " + habit1);
            count++;
        }
    }
}


/*

- dla każdego nawyku
- sprawdź czy nie jest zrobiony
- jak skonczysz przegladac :
- czy byl jakis nawyk nie zrobiony
 - jesli nie  wyśiwetl że wszystkie zrobione



usunięcie nawyku
nowy dzień - zmieniaja wszystkie na niezrobione
licznik zrobionych nawykow

 */
