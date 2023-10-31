package org.example.advanced.escape_room;

public class KeyItem extends Item {

    private boolean keyTaken;

    public KeyItem() {
        super("key");
    }

    @Override
    public void use() {
        if (!keyTaken) {
            System.out.println("You taken key");
            keyTaken = true;
        }
    }

    @Override
    public boolean visible() {
       return !keyTaken;
    }


    //problem: jak klucz ma przestac byc wyswietlany bez modyfikowania kodu wyswietlania
    //rozwiazanie 1: wyswietlane sa tylko te przedmioty ktore sa widoczne
    //rozwiazanie 2: wyswietlanie wyswietla wszystkie ale klucza juz tam nie ma a wiec klucz przy uzyciu sam usunie sie z listy
}
