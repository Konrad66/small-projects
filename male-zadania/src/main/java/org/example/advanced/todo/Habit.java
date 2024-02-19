package org.example.advanced.todo;

class Habit {

    private String habitName;

    boolean isDone;

    private int habitDoneCount;

    Habit(String habitName, boolean isDone) {
        this.habitName = habitName;
        this.isDone = isDone;
    }

    void doHabit(){
        if(isDone == false){
            habitDoneCount++;
            isDone = true;
        } else {
            System.out.println("Ten nawyk jest już dziś zrobiony.");
        }
    }

    @Override
    public String toString() {
        String oznaczenie;
        if(isDone == true){
            oznaczenie = "Z";
        } else {
            oznaczenie = "NZ";
        }
        return habitName + " - " + oznaczenie + " (" + habitDoneCount + ")";
    }
}