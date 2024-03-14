package org.example.advanced.todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class FileControl {
    private static final String FILE_PATH_HABITS = "habits.csv";
    private static final String FILE_PATH_DATE = "date.txt";
    MainController mainController;

    void readCSVHabits() {
        try (Scanner scanner = new Scanner(new File(FILE_PATH_HABITS))) {

            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                String[] data = text.split(";");
                String habitName = data[0];
                boolean isDone = Boolean.parseBoolean(data[1]);
                int habitDoneCount = Integer.parseInt(data[2]);
                int dayCount = Integer.parseInt(data[3]);
                boolean mastered = Boolean.parseBoolean(data[4]);
                Habit habit = new Habit(habitName, isDone, habitDoneCount, dayCount, mastered);

                if (mastered) {
                    mainController.masteredHabits.add(habit);
                } else {
                    mainController.habits.add(habit);
                }
            }
            System.out.println("Nawyki zostały wczytane prawidłowo.");
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku: " + e.getMessage());
        }
    }

    LocalDate readLastStartDate() {
        try (Scanner scanner = new Scanner(new File(FILE_PATH_DATE))) {
            String text = scanner.nextLine();
            LocalDate localDate = LocalDate.parse(text);
            return localDate;
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku: " + e.getMessage());
        }
        return null;
    }


    void saveToCSV() {
        saveDate();
        saveHabitsToCSV();
    }

    private void saveDate() {
        LocalDate localDate = LocalDate.now();
        try (FileWriter fileWriter = new FileWriter(FILE_PATH_DATE)) {
            fileWriter.write(localDate.toString());
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania daty do pliku:" + e.getMessage());
        }

    }

    private void saveHabitsToCSV() {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH_HABITS)) { //try with resource - wymaga zaimplementowanego AutoClosable
            for (Habit habit : mainController.habits) {
                fileWriter.write(composeCSVLine(habit));
            }
            for (Habit habit : mainController.masteredHabits) {
                fileWriter.write(composeCSVLine(habit));
            }
            System.out.println("Progres został zapisany w pliku.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania progresu do pliku: " + e.getMessage());
        }
    }

    private String composeCSVLine(Habit habit) {
        return habit.getHabitName() + ";" + habit.isDone() + ";" + habit.getHabitDoneCount() + ";" + habit.getDayCount() + ";" + habit.mastered + ";" + "\n";
    }
}

