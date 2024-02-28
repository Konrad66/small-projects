package org.example.advanced.todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    private static final String FILE_PATH = "habits.csv";
    private static List<Habit> habits = new ArrayList<>();
    private static List<Habit> masteredHabits = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean exitFromAssistant = false;

    public static void main(String[] args) {
        readCSV();
        while (!exitFromAssistant) {
            printOptions();
            doOption();
        }
        saveToCSV();
    }

    private static void printOptions() {
        System.out.println("Witaj w asystencie budowania nawyków. Wybierz opcje z listy nieżej:");
        System.out.println("1. Dodaj nawyk");
        System.out.println("2. Usuń nawyki");
        System.out.println("3. Oznacz nawyki");
        System.out.println("4. Opanowane nawyki");
        System.out.println("5. Nowy dzień");
        System.out.println("0. Wyjdź z asystenta");
    }

    private static void doOption() {
        String choice = scanner.next();
        switch (choice) {
            case "1" -> addHabit();
            case "2" -> removeHabit();
            case "3" -> markHabit();
            case "4" -> masteredHabits();
            case "5" -> newDay();
            case "0" -> exitFromAssistant = true;
            default -> System.out.println("Zły wybór. Wybierz z listy poniżej");
        }
    }

    private static void addHabit() {
        System.out.println("Podaj nazwe nawyku");
        String habitName = scanner.next();
        habits.add(new Habit(habitName, false, 0, 0, false));
        saveToCSV();
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
        for (Habit habit : habits) {
            System.out.println(count + ". " + habit);
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
            Habit chosenHabit = habits.get(choice - 1);
            chosenHabit.doHabit();
            allCompleted();
            //alt + shift -> zaznaczanie wielu
            masterHabit(chosenHabit);
        }
    }

    private static void masterHabit(Habit chosenHabit) {
        double completePercentage = chosenHabit.habitDoneCount * 100.0 / chosenHabit.dayCount;
        if (chosenHabit.dayCount >= 30 && completePercentage >= 90) {
            chosenHabit.mastered = true;
            masteredHabits.add(chosenHabit);
            habits.remove(chosenHabit);
        }
    }

    private static void masteredHabits() {
        for (Habit habit : masteredHabits) {
            System.out.println("Gratulacje! Nawyk " + habit.getHabitName() + " został opanowany.");
        }
    }

    private static void allCompleted() {
        boolean wszystkieZrobione = true;
        for (Habit habit : habits) {
            if (!habit.done) {
                wszystkieZrobione = false;
                break;
            }
        }
        if (wszystkieZrobione) {
            System.out.println("Super, zrobiles wszystkie nawyki");
        }
    }

    private static void newDay() {
        for (Habit habit : habits) {
            habit.done = false;
            habit.dayCount++;
        }
        System.out.println("Witaj w nowym dniu. Powodzenia z dzisiejszymi nawykami.");
    }

    //todo metody do pracy na pliku do osobnej klasy

    private static void readCSV() {
        try {
            Scanner scanner = new Scanner(new File(FILE_PATH));
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                String[] data = text.split(";");
                String habitName = data[0];
                boolean isDone = Boolean.parseBoolean(data[1]);
                int habitDoneCount = Integer.parseInt(data[2]);
                int dayCount = Integer.parseInt(data[3]);
                boolean mastered = Boolean.parseBoolean(data[4]);
                if (mastered) { //todo powtorka
                    masteredHabits.add(new Habit(habitName, isDone, habitDoneCount, dayCount, mastered));
                } else {
                    habits.add(new Habit(habitName, isDone, habitDoneCount, dayCount, mastered));
                }
            }
            System.out.println("Nawyki zostały wczytane prawidłowo.");
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku: " + e.getMessage());
        }
    }

    private static void saveToCSV() {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH)) { //try with resource - wymaga zaimplementowanego AutoClosable
            for (Habit habit : habits) { //todo powtorka
                fileWriter.write(habit.getHabitName() + ";" + habit.isDone() + ";" + habit.getHabitDoneCount() + ";" + habit.getDayCount() + ";" + habit.mastered + ";" + "\n");
            }
            for (Habit habit : masteredHabits) {
                fileWriter.write(habit.getHabitName() + ";" + habit.isDone() + ";" + habit.getHabitDoneCount() + ";" + habit.getDayCount() + ";" + habit.mastered + ";" + "\n");
            }
            System.out.println("Progres został zapisany w pliku.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania progresu do pliku: " + e.getMessage());
        }
    }
}

//ConcurentModificationException - doczytać kiedy występuje i jak sobie z nim radzić


//Master habity tez maja byc utrwalane w CSV

//