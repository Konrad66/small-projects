package org.example.advanced.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {

    private FileControl fileControl;
    private List<Habit> allHabits = new ArrayList<>();
    //private List<Habit> habits = new ArrayList<>();
    //private List<Habit> masteredHabits = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private boolean exitFromAssistant = false;

    MainController(FileControl fileControl) {
        this.fileControl = fileControl;
    }

    void control() {
        allHabits = fileControl.readCSVHabits();
        while (!exitFromAssistant) {
            if (fileControl.readLastStartDate().isBefore(LocalDate.now())) {
                newDay();
            }
            printOptions();
            doOption();
        }
        fileControl.saveToCSV(allHabits);
    }

    private void printOptions() {
        System.out.println("Witaj w asystencie budowania nawyków. Wybierz opcje z listy nieżej:");
        System.out.println("0. Wyjdź z asystenta");
        System.out.println("1. Dodaj nawyk");
        System.out.println("2. Nawyki");
        System.out.println("3. Statystyki");
        //todo zmienic menu statystyk
        System.out.println("4. Opanowane nawyki");
        //todo usunąć nowy dzień
        System.out.println("5. Nowy dzień");
    }

    private void doOption() {
        String choice = scanner.next();
        switch (choice) {
            case "0" -> exitFromAssistant = true;
            case "1" -> addHabit();
            case "2" -> doHabitOption();
            case "3" -> printStatistic();
            case "4" -> printMasteredHabits();
            case "5" -> newDay();

            default -> System.out.println("Zły wybór. Wybierz numer z listy poniżej");
        }
    }

    private void doHabitOption() {
        while (true) {
            System.out.println("Wybierz nawyk:");
            System.out.println("0. Powrót do menu");
            printNonMasteredHabits();
            int selectHabit = scanner.nextInt();
            if (selectHabit == 0) {
                break;
            } else if (selectHabit > 0 && selectHabit <= nonMasteredHabits().size()) {
                printHabitOptions();
                String selectOption = scanner.next();
                switch (selectOption) {
                    case "1" -> markHabit(selectHabit);
                    case "2" -> removeHabit(selectHabit);
                    case "3" -> editHabit(selectHabit);
                    case "4" -> resetHabit(selectHabit);
                }
            } else {
                System.out.println("Wybór spoza zakresu. Spróbuj jeszcze raz.");
            }
        }
    }

    private void printHabitOptions() {
        System.out.println("Co chcesz zrobić z wybranym nawykiem?");
        System.out.println("1. Oznacz nawyki");
        System.out.println("2. Usuń nawyki");
        System.out.println("3. Edytuj nazwe");
        System.out.println("4. Zresetuj nawyk");
    }

    private void markHabit(int choice) {
        Habit chosenHabit = nonMasteredHabits().get(choice - 1);
        chosenHabit.doHabit();
        masterHabit(chosenHabit);
    }

    private void addHabit() {
        System.out.println("Podaj nazwe nawyku");
        String habitName;
        scanner.nextLine();
        habitName = scanner.nextLine();
        IdGenerator idGenerator = new IdGenerator();
        int newId = idGenerator.giveLastId();
        //long actualTime = System.currentTimeMillis();
        allHabits.add(new Habit(newId++, habitName, false, 0, 0, false));
        idGenerator.saveNewId(newId);
    }

    private void removeHabit(int removeHabit) {
        Habit habitToRemove = nonMasteredHabits().get(removeHabit - 1);
        allHabits.remove(habitToRemove);
        System.out.println("Nawyk został prawidłowo usunięty.");

    }

    private void editHabit(int choice) {
        Habit habitToEdit = nonMasteredHabits().get(choice - 1);
        System.out.println("Aktualna nazwa nawyku " + habitToEdit.getHabitName());
        System.out.println("Podaj nową nazwę nawyku: ");
        scanner.nextLine();
        String newHabitName = scanner.next();
        habitToEdit.setHabitName(newHabitName);
        System.out.println("Nazwa nawyku została zaktualizowana. Jeśli chcesz wrócić do menu wpisz 0.");
    }

    private void resetHabit(int choice) {
        Habit habitToReset = nonMasteredHabits().get(choice - 1);
        habitToReset.setDayCount(0);
        habitToReset.setHabitDoneCount(0);
        habitToReset.setDone(false);
    }

    private void masterHabit(Habit chosenHabit) {
        double completePercentage = chosenHabit.habitDoneCount * 100.0 / chosenHabit.dayCount;
        if (chosenHabit.dayCount >= 30 && completePercentage >= 90) {
            chosenHabit.mastered = true;
        }
    }

    private void printMasteredHabits() {
        for (Habit habit : masteredHabits()) {
            System.out.println("Gratulacje! Nawyk " + habit.getHabitName() + " został opanowany.");
        }
    }

    private void printNonMasteredHabits() {
        int count = 1;
        for (Habit habit : nonMasteredHabits()) {
            System.out.println(count + ". " + habit);
            //System.out.println(habit.getHabitID()+ ". " + habit);
            count++;
        }
    }

    private List<Habit> masteredHabits() {
        List<Habit> masteredHabits = new ArrayList<>();
        for (Habit habit : allHabits) {
            if (habit.mastered) {
                masteredHabits.add(habit);
            }
        }
        return masteredHabits;
    }

    private List<Habit> nonMasteredHabits() {
        List<Habit> nonMasteredHabits = new ArrayList<>();
        for (Habit habit : allHabits) {
            if (!habit.mastered) {
                nonMasteredHabits.add(habit);
            }
        }
        return nonMasteredHabits;
    }

    private boolean areAllCompleted() {
        boolean wszystkieZrobione = true;
        for (Habit habit : nonMasteredHabits()) {
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

    private void newDay() {
        for (Habit habit : nonMasteredHabits()) {
            habit.done = false;
            habit.dayCount++;
        }
        System.out.println("Witaj w nowym dniu. Powodzenia z dzisiejszymi nawykami.");
    }

    private void printStatistic() {
        System.out.println("Poniżej znajdziesz kilka statystyk.");
        int countMasteredHabit = 0;
        int countNonMasteredHabit = 0;
        for (Habit habit : allHabits) {
            if (!habit.mastered) {
                countMasteredHabit++;
            } else {
                countNonMasteredHabit++;
            }
        }
        System.out.println("Łączna liczba nawyków nad którymi aktualnie pracujesz to: " + countMasteredHabit);
        System.out.println("Łączna liczba opanowanych już nawyków to: " + countNonMasteredHabit);

        for (Habit habit : allHabits) {
            double countPercentageHabit = habit.habitDoneCount * 1.0 / habit.dayCount;
            System.out.println("Twój nawyk - " + habit.getHabitName() + " - jest wykonany w " + (Math.round(countPercentageHabit * 100)) + " %");
        }
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
dodać unikalny numer dla każdego habitu; - dziala ale w przypadku usuniecia przedostatniego dodanego nawyku, nowe dodanie ma ten sam unikalny numer co ostatni nawyk
wyświetlanie statystyk (w ilu procentach zrobiliśmy konkretny nawyk, ile mamy nawyków ile wykonanych ile opanowanych)

 */

//todo
//zapyta jeszcze raz o modyfikacje pdoczas wyswietlnia listy foreachem
// zaokraglenie liczby


//printf - doczytac jak dziala
//ten temat sie wiaze z metoda String.format

//todo
//stworzyć aplikację

//todo
//dziennik postepu
//historia nawyków ??? ale tu moze baza danych???


//stworzenie kategorii

// po stworzeniu categorii przerobienie menu na bardziej czytelne
//statystyka pokazujaca ile w danym dniu zrobilismy nawykow
//jakies powiadomienia o wykonuwaniu nawykow
//tworzsenie celow i nagrod po ich wykonaniu