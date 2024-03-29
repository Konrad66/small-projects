package org.example.advanced.todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileControl {
    private static final String FILE_PATH_HABITS = "habits.csv";
    private static final String FILE_PATH_DATE = "date.txt";

    List<Habit> readCSVHabits() {
        List<Habit> habitList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(FILE_PATH_HABITS))) {
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                String[] data = text.split(";");
                int habitID = Integer.parseInt(data[0]);
                String habitName = data[1];
                boolean isDone = Boolean.parseBoolean(data[2]);
                int habitDoneCount = Integer.parseInt(data[3]);
                int dayCount = Integer.parseInt(data[4]);
                boolean mastered = Boolean.parseBoolean(data[5]);
                Habit habit = new Habit(habitID, habitName, isDone, habitDoneCount, dayCount, mastered);
                habitList.add(habit);
            }
            System.out.println("Nawyki zostały wczytane prawidłowo.");
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku: " + e.getMessage());
        }
        return habitList;
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

    void saveToCSV(List<Habit> habits) {
        saveDate();
        saveHabitsToCSV(habits);
    }

    private void saveDate() {
        LocalDate localDate = LocalDate.now();
        try (FileWriter fileWriter = new FileWriter(FILE_PATH_DATE)) {
            fileWriter.write(localDate.toString());
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania daty do pliku:" + e.getMessage());
        }
    }

    private void saveHabitsToCSV(List<Habit> habits) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH_HABITS)) { //try with resource - wymaga zaimplementowanego AutoClosable
            for (Habit habit : habits) {
                fileWriter.write(composeCSVLine(habit));
            }
            System.out.println("Progres został zapisany w pliku.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania progresu do pliku: " + e.getMessage());
        }
    }

    private String composeCSVLine(Habit habit) {
        return habit.getHabitID() + ";" + habit.getHabitName() + ";" + habit.isDone() + ";" + habit.getHabitDoneCount() + ";" + habit.getDayCount() + ";" + habit.mastered + ";" + "\n";
    }
}