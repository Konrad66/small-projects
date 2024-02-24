package org.example.advanced.todo;

import java.io.File;
import java.io.FileNotFoundException;
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
    1. Wypicie butelki wody - NZ (30/30) -
    2. przeczytałeś książke - NZ (1/2)
    3. Powrót do menu
     */

    private static List<Habit> habits = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean exitFromAssistant = false;

    public static void main(String[] args) {
        loadHabitsFromCSV("C:\\Users\\PC\\IdeaProjects\\small-projects\\habits.csv");
        while (!exitFromAssistant) {
            printOptions();
            doOption();
        }
    }

    private static void printOptions() {
        System.out.println("Witaj w asystencie budowania nawyków. Wybierz opcje z listy nieżej:");
        System.out.println("1. Dodaj nawyk");
        System.out.println("2. Usuń nawyki");
        System.out.println("3. Oznacz nawyki");
        System.out.println("4. Opanowane nawyki");
        System.out.println("5. Nowy dzień");
        System.out.println("9. Wyjdź z asystenta");
    }

    private static void doOption() {
        String wybor = scanner.next();
        switch (wybor) {
            case "1" -> addHabit();
            case "2" -> removeHabit();
            case "3" -> markHabit();
            case "4" -> masteredHabits();
            case "5" -> newDay();
            case "9" -> exitFromAssistant = true;
            default -> System.out.println("Zły wybór. Wybierz z listy poniżej");
        }
    }

    private static void addHabit() {
        System.out.println("Podaj nazwe nawyku");
        String habitName = scanner.next();
        habits.add(new Habit(habitName, false, 0, 0));
    }

    private static void removeHabit() {
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

    private static void printHabits() {
        int count = 1;
        for (Habit habit1 : habits) {
            System.out.println(count + ". " + habit1);
            count++;
        }
    }

    private static void markHabit() {
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

    private static void masteredHabits() {
        for (Habit habit : habits) {
            double completePercentage = (double) habit.habitDoneCount * 100 / habit.dayCount;
            if (habit.dayCount >= 30) {
                if (completePercentage >= 90) {
                    System.out.println("Gratulacje! Nawyk " + habit.getHabitName() + " został opanowany.");
                }
            }
        }
    }

    private static void allCompleted() {
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

    private static void newDay() {
        for (Habit habit : habits) {
            habit.isDone = false;
            habit.dayCount++;
        }
        System.out.println("Witaj w nowym dniu. Powodzenia z dzisiejszymi nawykami.");
    }

    List<String> readCSV(){
        List<String> habitList = new ArrayList<>();
        try {
            Scanner reader = new Scanner(new File("habits.csv"));
            String text = reader.next();
            String[] texts = text.split(";");
            for (String name : texts) {
                habitList.add(name);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File doesn't exist");
            exception.printStackTrace();
        }
        return habitList;
    }


    private static void loadHabitsFromCSV(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");
                String habitName = data[0];
                boolean isDone = Boolean.parseBoolean(data[1]);
                int habitDoneCount = Integer.parseInt(data[2]);
                int dayCount = Integer.parseInt(data[3]);
                habits.add(new Habit(habitName, isDone, habitDoneCount, dayCount));
            }
            scanner.close();
            System.out.println("Nawyki zostały wczytane z pliku.");
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku: " + e.getMessage());
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


ile sukcesów na ile dni
zapisywanie stanu programu - przy otwarciu niech pobierze z pliku, przy zamknieciu niech nadpisze plik
1. Wczytywanie z pliku
2. Zastąpienie w nowym pliku
Jeśli aplikacja zobaczy że wykonałeś coś 30 razy w conajmniej 90% dobrze, zapyta czy chcemy robić nawyk dalej i przeniesie go do opanowanych nawyków
 */


/*
w Java są 4 modyfikatory dostępu:
- private - zasięg w ramach jednej klasy
- domyślny (dostęp pakietowy) - jest dostępny w ramach tego samego pakietu (w strukutrze projektu - package)
- protected - plus dodatkowo klasy dziedziczące
- public - dostępny w każdym pakiecie
 */