package org.example.advanced.todo;

import java.time.LocalDate;
import java.util.*;

public class Main {

    static FileControl fileControl = new FileControl();
    static List<Habit> habits = new ArrayList<>();
    static List<Habit> masteredHabits = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean exitFromAssistant = false;

    public static void main(String[] args) {
        fileControl.readCSVHabits();
        while (!exitFromAssistant) {
            if (fileControl.readLastStartDate().isBefore(LocalDate.now())) {
                newDay();
            }
            printOptions();
            doOption();
        }
        fileControl.saveToCSV();
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
            case "4" -> printMasteredHabits();
            case "5" -> newDay();
            case "0" -> exitFromAssistant = true;
            default -> System.out.println("Zły wybór. Wybierz numer z listy poniżej");
        }
    }

    private static void addHabit() {
        System.out.println("Podaj nazwe nawyku");
        String habitName = scanner.next();
        habits.add(new Habit(habitName, false, 0, 0, false));
        //fileControl.saveToCSV();
    }

    private static void removeHabit() {
        while (true) {
            System.out.println("Który z nawyków chcesz usunąć? Jak chcesz wrócic do menu wciśnij 0.");
            printHabits();
            int removeHabit = scanner.nextInt();
            if (removeHabit == 0) {
                break;
            } else if (removeHabit > 0 && removeHabit <= habits.size()) {
                habits.remove(removeHabit - 1);
                System.out.println("Nawyk został prawidłowo usunięty.");
            } else {
                System.out.println("Wybór spoza zakresu. Spróbuj jeszcze raz.");
            }
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
            } else if (choice > 0 && choice <= habits.size()) {
                Habit chosenHabit = habits.get(choice - 1);
                chosenHabit.doHabit();
                boolean allCompleted = areAllCompleted();
                //alt + shift -> zaznaczanie wielu
                masterHabit(chosenHabit);
                /*
                if(allCompleted){
                    newDay();
                    break;
                }

                 */
            } else {
                System.out.println("Wybór spoza zakresu. Spróbuj jeszcze raz.");
            }
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

    private static void printMasteredHabits() {
        for (Habit habit : masteredHabits) {
            System.out.println("Gratulacje! Nawyk " + habit.getHabitName() + " został opanowany.");
        }
    }

    private static boolean areAllCompleted() {
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
        return wszystkieZrobione;
    }

    private static void newDay() {
        for (Habit habit : habits) {
            habit.done = false;
            habit.dayCount++;
        }
        System.out.println("Witaj w nowym dniu. Powodzenia z dzisiejszymi nawykami.");
    }
}

//ConcurentModificationException - doczytać kiedy występuje i jak sobie z nim radzić
/*
ConcurrentModificationException jest wyjątkiem zgłaszanym przez niektóre klasy w Java Collections Framework, takie jak ArrayList, HashMap, itp., gdy wykryją, że kolekcja została zmodyfikowana w sposób, który jest niezgodny z operacjami, na przykład gdy jednocześnie dokonuje się iteracji po kolekcji i zmienia jej strukturę.

Występuje gdy kolekcja jest modyfikowana podczas iteracji po niej
Przyczyną jest na przykład dodanie, usunięcie lub modyfikacja elementów bezpośrednio podczas gdy jednocześnie trwa iteracja tej samej kolekcji

Wyjątek jest zgłaszany dopiero podczas próby dostępu do iteratora, który wykrywa niezgodność

Wielowątkowy dostęp do kolekcji, gdzie jeden wątek modyfikuje kolekcję, podczas gdy inny wątek jednocześnie iteruje po niej, może prowadzić do ConcurrentModificationException.

Aby uniknąć ConcurrentModificationException, należy używać bezpiecznych mechanizmów synchronizacji, takich jak synchronized, lub używać klas z pakietu java.util.concurrent, które zapewniają bezpieczny dostęp do kolekcji w środowisku wielowątkowym.

Fail-Fast vs. Fail-Safe: Struktury danych w Java Collections Framework są zazwyczaj zaimplementowane jako "fail-fast", co oznacza, że natychmiastowo zgłaszają ConcurrentModificationException, gdy wykryją niezgodność podczas iteracji. Z drugiej strony, istnieją też struktury "fail-safe", które pozwalają na bezpieczne iterowanie po kolekcji, nawet jeśli jest ona modyfikowana w trakcie iteracji, ale niekoniecznie zapewniają aktualne widoki kolekcji.

 */


//Master habity tez maja byc utrwalane w CSV



/*
Program zapisuje do pliku dzień w którym został zamknięty
Program podczas uruchomienia zczytuje z pliku czas kiedy został zamknięty i porównuje go z aktualnym
wyjdzie nam że jest inny dzień i w tym momencie odpalamy newday();
 */