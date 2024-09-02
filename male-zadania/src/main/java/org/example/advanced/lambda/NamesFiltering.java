package org.example.advanced.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NamesFiltering {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>(Arrays.asList("wiktoria", "przemek", "konrad", "beata", "kolo", "wiki"));

        names.replaceAll(name -> name.toUpperCase());

        names.removeIf(name -> name.length() <= 5);

        names.sort(String::compareTo);
        //names.sort((name1, name2) -> name1.compareTo(name2));
        System.out.println(names);
    }
}