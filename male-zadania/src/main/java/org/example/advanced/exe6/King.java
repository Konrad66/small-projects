package org.example.advanced.exe6;

public class King extends Citizen {
    public King(String name) {
        super(name);
    }

    @Override
    public boolean canVote() {
        return false;
    }
}
