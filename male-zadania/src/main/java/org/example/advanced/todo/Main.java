package org.example.advanced.todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    private static List<Habit> habits = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean exitFromAssistant = false;

    public static void main(String[] args) {
        readCSV("habits.csv");
        while (!exitFromAssistant) {
            printOptions();
            doOption();
        }
    }

    private static void readCSV(String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                String[] data = text.split(";");
                String habitName = data[0];
                boolean isDone = Boolean.parseBoolean(data[1]);
                int habitDoneCount = Integer.parseInt(data[2]);
                int dayCount = Integer.parseInt(data[3]);
                habits.add(new Habit(habitName, isDone, habitDoneCount, dayCount));
            }
            //scanner.close();
            System.out.println("Nawyki zostały wczytane prawidłowo.");
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku: " + e.getMessage());
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


}