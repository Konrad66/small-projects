package org.example.advanced.escape_room;

public abstract class Item {

    private String name;

    public Item(String name) {
        this.name = name;
    }

    public abstract void use();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
