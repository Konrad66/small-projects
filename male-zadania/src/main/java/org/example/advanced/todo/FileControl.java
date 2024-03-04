package org.example.advanced.todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

//todo czy taka forma importu list jest poprawna?
import static org.example.advanced.todo.Main.habits;
import static org.example.advanced.todo.Main.masteredHabits;

public class FileControl {
    private static final String FILE_PATH = "habits.csv";

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
                Habit habit = new Habit(habitName, isDone, habitDoneCount, dayCount, mastered);

                if (mastered) {
                    masteredHabits.add(habit);
                } else {
                    habits.add(habit);
                }
            }
            System.out.println("Nawyki zostały wczytane prawidłowo.");
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku: " + e.getMessage());
        }
    }

    static void saveToCSV() {
        //zapisz dane programu
        //....
        saveDate();
        
        //zapisz habity
        saveHabitsToCSV();
    }

    private static void saveDate(){
        LocalDate localDate = LocalDate.now();


    }

    private static void saveHabitsToCSV(){
        try (FileWriter fileWriter = new FileWriter(FILE_PATH)) { //try with resource - wymaga zaimplementowanego AutoClosable
            for (Habit habit : habits) {
                fileWriter.write(composeCSVLine(habit));
            }
            for (Habit habit : masteredHabits) {
                fileWriter.write(composeCSVLine(habit));
            }
            System.out.println("Progres został zapisany w pliku.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania progresu do pliku: " + e.getMessage());
        }
    }

    private static String composeCSVLine(Habit habit) {
        return habit.getHabitName() + ";" + habit.isDone() + ";" + habit.getHabitDoneCount() + ";" + habit.getDayCount() + ";" + habit.mastered + ";" + "\n";
    }
}