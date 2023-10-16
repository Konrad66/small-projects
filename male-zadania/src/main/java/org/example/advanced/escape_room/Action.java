package org.example.advanced.escape_room;

public abstract class Action {

    private String name;

    public Action(String name) {
        this.name = name;
    }

    public abstract void action();

    @Override
    public String toString() {
        return name;
    }
}
