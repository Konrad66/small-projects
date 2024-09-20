package org.example.advanced.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class MyStreamService implements StreamService {


    @Override
    public void sortAndPrint(List<String> names) {
        names.stream()
                .sorted((name1, name2) -> -name1.compareTo(name2)
//
//                            if (name1.length() < name2.length()) {
//                                return -1;
//                            } else if (name1.length() == name2.length()) {
//                                return 0;
//                            } else {
//                                return 1;
//                            }
//                        }
                )
                .forEach(name -> System.out.println(name));
    }

    @Override
    public int distinctAndCountNumbers(int[] numbers) {
        return (int) Arrays.stream(numbers)
                .distinct()
                .count();
    }

    @Override
    public List<String> computeMaleNames(List<String> names) {
        return names.stream()
                .filter(name -> !name.endsWith("a"))
                .collect(Collectors.toList());
    }

    @Override
    public void printNumbersOfRange(int[] numbers, int minValue, int maxValue) {
        Arrays.stream(numbers)
                .filter(number -> number >= minValue && number <= maxValue)
                .distinct()
                .forEach(System.out::println);
    }

    //Zwraca listę liczb odpowiadających ilością liter w imionac
    @Override
    public List<Integer> computeNamesLength(List<String> names) {
//        return names.stream()
//                .flatMapToInt(name -> name.chars())
//                .filter(ch -> Character.isLetter(ch))
//                .collect(Collectors.toList());

        return null;
    }

    @Override
    public List<Person> buildPeopleWithNames(List<String> names) {
        return List.of();
    }

    @Override
    public List<Person> findPeopleOfIdGreaterThan(List<Person> people, int id) {
        return List.of();
    }

    @Override
    public boolean hasSenior(List<Person> people) {
        return false;
    }

    @Override
    public double sumTotalCash(List<Person> people) {
        return 0;
    }

    @Override
    public Person findRichestPerson(List<Person> people) {
        return null;
    }

    @Override
    public double computeAverageAge(List<Person> people) {
        return 0;
    }
}