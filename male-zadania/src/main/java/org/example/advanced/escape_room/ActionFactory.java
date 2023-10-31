package org.example.advanced.escape_room;

public class ActionFactory {


    public Item createAction(String item) {
        if (item.equals("window")) {
            return new WindowItem();
        } else if (item.equals("key")) {
            return new KeyItem();

        }
        throw new IllegalStateException("Nie przewidziano przedmiotu o nazwie " + item);
    }
    //gdy dodajesz nowy typ obiektu w hierarchi dziedziczenia do programu to program powinien zostać zmodyfikowany max w jednym miejscu
    //L soLid
}