package org.example.kodi.module4.submodule4;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        ArrayList<Canon> canonArrayList = new ArrayList<>();

        Canon canon1 = new Canon();
        Canon canon2 = new Canon();
        Canon canon3 = new Canon();
        Canon canon4 = new Canon();
        Canon canon5 = new Canon();

        canonArrayList.add(canon1);
        canonArrayList.add(canon2);
        canonArrayList.add(canon3);
        canonArrayList.add(canon4);
        canonArrayList.add(canon5);

        for (Canon canon : canonArrayList) {
            canon.load();
        }

        for (Canon canon : canonArrayList) {
            canon.fire();
        }
    }
}


class Canon {

    private boolean loaded;

    public Canon() {
        this.loaded = false;
    }

    void fire() {
        if (!loaded) {
            System.out.println("Brak kuli w armacie :(");
            load();
        } else {
            System.out.println("Wystrzelono pocisk!");
        }
    }

    void load() {
        if (!loaded) {
            System.out.println("Ładuje pocisk");
            loaded = true;
        } else {
            System.out.println("Pocisk już załadowany strzelaj!");
        }
    }
}