package org.example.advanced.escape_room;

import java.util.List;

public class ActionFactory {


    public Action createAction(String item) {
        if (item.equals("window")) {
            return new WindowAction();
        } else if (item.equals("key")) {
            return new KeyAction();
        }
        throw new IllegalStateException("Nie przewidziano przedmiotu o nazwie " + item);
    }
}