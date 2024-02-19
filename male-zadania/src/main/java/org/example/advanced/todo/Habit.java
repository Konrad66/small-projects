package org.example.advanced.todo;

public class Habit {

    private String habitName;

    public boolean isDone;

    public int habitDoneCount;

    public Habit(String habitName, boolean isDone) {
        this.habitName = habitName;
        this.isDone = isDone;
    }

    public void doHabit(){
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
