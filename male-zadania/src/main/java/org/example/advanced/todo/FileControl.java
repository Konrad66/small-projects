package org.example.advanced.todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//todo czy taka forma importu list jest poprawna?
import static org.example.advanced.todo.Main.habits;
import static org.example.advanced.todo.Main.masteredHabits;

public class FileControl {

    private static final String FILE_PATH = "habits.csv";
    static Main main = new Main();

    //todo metody do pracy na pliku do osobnej klasy

    static void readCSV() {
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

    static void saveToCSV() {
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
