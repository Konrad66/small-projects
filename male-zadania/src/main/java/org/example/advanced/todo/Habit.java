package org.example.advanced.todo;

public class Habit {

    private String habitName;

    public boolean isDone;

    public Habit(String habitName, boolean isDone) {
        this.habitName = habitName;
        this.isDone = isDone;
    }


    @Override
    public String toString() {
        String oznaczenie;
        if(isDone == true){
            oznaczenie = "Z";
        } else {
            oznaczenie = "NZ";
        }
        return habitName + " - " + oznaczenie;
    }


}
