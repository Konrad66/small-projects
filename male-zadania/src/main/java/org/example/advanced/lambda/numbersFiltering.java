package org.example.advanced.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class numbersFiltering {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        numbers.removeIf(n -> n % 2 != 0);

        numbers.replaceAll(n -> n + 5);

        System.out.println(numbers);
    }
}