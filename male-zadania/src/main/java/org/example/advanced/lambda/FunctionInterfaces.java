package org.example.advanced.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.function.*;

public class FunctionInterfaces {

    public static void main(String[] args) {

        //losuje liczbę od 1-10


        Supplier<Integer> getRandomNumber = () -> new Random().nextInt(10) + 1;

        System.out.println(getRandomNumber.get());

        //sprawdza czy hasło ma minimum 5 znaków
        Predicate<String> checkPassword = password -> password.length() >= 5;

//        Predicate<String> chceckPassword = password -> {
//            if (password.length() >= 5) {
//                return true;
//            }
//            return false;
//        };

        System.out.println(checkPassword.test("monitor"));

        //Consumer, Function, Operator, Predicate, Supplier, Runnable, Comparator
        // void -> T
    }
}
