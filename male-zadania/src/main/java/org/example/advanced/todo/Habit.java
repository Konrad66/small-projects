package org.example.advanced.todo;

class Habit {

    private int habitID;
    private String habitName;
    boolean done;
    int habitDoneCount;
    int dayCount;
    boolean mastered;

    Habit(int habitID, String habitName, boolean done, int habitDoneCount, int dayCount, boolean mastered) {
        this.habitID = habitID;
        this.habitName = habitName;
        this.done = done;
        this.habitDoneCount = habitDoneCount;
        this.dayCount = dayCount;
        this.mastered = mastered;
    }

    void doHabit() {
        if (!done) {
            habitDoneCount++;
            done = true;
        } else {
            System.out.println("Ten nawyk jest już dziś zrobiony.");
        }
    }

    String getHabitName() {
        return habitName;
    }

    public boolean isDone() {
        return done;
    }


    public int getHabitDoneCount() {
        return habitDoneCount;
    }

    public int getDayCount() {
        return dayCount;
    }

    public int getHabitID() {
        return habitID;
    }

    @Override
    public String toString() {
        String oznaczenie;
        if (done == true) {
            oznaczenie = "Z";
        } else {
            oznaczenie = "NZ";
        }
        return habitName + " - " + oznaczenie + " (" + habitDoneCount + "/" + dayCount + ")";
    }
}