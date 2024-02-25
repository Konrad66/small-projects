package org.example.advanced.todo;

class Habit {

    private String habitName;
    boolean isDone;
    int habitDoneCount;
    int dayCount;

    Habit(String habitName, boolean isDone, int habitDoneCount, int dayCount) {
        this.habitName = habitName;
        this.isDone = isDone;
        this.habitDoneCount = habitDoneCount;
        this.dayCount = dayCount;
    }

    void doHabit() {
        if (isDone == false) {
            habitDoneCount++;
            isDone = true;
        } else {
            System.out.println("Ten nawyk jest już dziś zrobiony.");
        }
    }

    String getHabitName() {
        return habitName;
    }

    public boolean isDone() {
        return isDone;
    }

    public int getHabitDoneCount() {
        return habitDoneCount;
    }

    public int getDayCount() {
        return dayCount;
    }

    @Override
    public String toString() {
        String oznaczenie;
        if (isDone == true) {
            oznaczenie = "Z";
        } else {
            oznaczenie = "NZ";
        }
        return habitName + " - " + oznaczenie + " (" + habitDoneCount + "/" + dayCount + ")";
    }
}