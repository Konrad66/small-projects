package org.example.advanced.todo;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FileControl fileControl = new FileControl();
        MainController mainController = new MainController();
        mainController.fileControl = fileControl;
        fileControl.mainController = mainController;
        mainController.control();


    }
}

//ConcurentModificationException - doczytać kiedy występuje i jak sobie z nim radzić
/*
ConcurrentModificationException jest wyjątkiem zgłaszanym przez niektóre klasy w Java Collections Framework, takie jak ArrayList, HashMap, itp., gdy wykryją, że kolekcja została zmodyfikowana w sposób, który jest niezgodny z operacjami, na przykład gdy jednocześnie dokonuje się iteracji po kolekcji i zmienia jej strukturę.

Występuje gdy kolekcja jest modyfikowana podczas iteracji po niej
Przyczyną jest na przykład dodanie, usunięcie lub modyfikacja elementów bezpośrednio podczas gdy jednocześnie trwa iteracja tej samej kolekcji

Wyjątek jest zgłaszany dopiero podczas próby dostępu do iteratora, który wykrywa niezgodność

Wielowątkowy dostęp do kolekcji, gdzie jeden wątek modyfikuje kolekcję, podczas gdy inny wątek jednocześnie iteruje po niej, może prowadzić do ConcurrentModificationException.

Aby uniknąć ConcurrentModificationException, należy używać bezpiecznych mechanizmów synchronizacji, takich jak synchronized, lub używać klas z pakietu java.util.concurrent, które zapewniają bezpieczny dostęp do kolekcji w środowisku wielowątkowym.

Fail-Fast vs. Fail-Safe: Struktury danych w Java Collections Framework są zazwyczaj zaimplementowane jako "fail-fast", co oznacza, że natychmiastowo zgłaszają ConcurrentModificationException, gdy wykryją niezgodność podczas iteracji. Z drugiej strony, istnieją też struktury "fail-safe", które pozwalają na bezpieczne iterowanie po kolekcji, nawet jeśli jest ona modyfikowana w trakcie iteracji, ale niekoniecznie zapewniają aktualne widoki kolekcji.

 */


//Master habity tez maja byc utrwalane w CSV



/*

 */