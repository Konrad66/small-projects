package org.example.zaawansowane.zad6;

import java.util.Objects;

public abstract class Citizen {

    private String name;

    public Citizen(String name) {
        this.name = name;
    }

    abstract public boolean canVote();

    public String getName() {
        return name;
    }
}