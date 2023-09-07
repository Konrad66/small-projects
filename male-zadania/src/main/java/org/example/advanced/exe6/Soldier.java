package org.example.advanced.exe6;

public class Soldier extends Citizen {
    public Soldier(String name) {
        super(name);
    }

    @Override
    public boolean canVote() {
        return true;
    }
}
