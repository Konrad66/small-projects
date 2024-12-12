package org.example.kodi.module2.submodule1;

public class App {
    public static void main(String[] args) {

        double sum = 0;
        double average = 0;
        int number_of_elements = 20;
        for (int i = 0; i < number_of_elements; i++) {
            System.out.println("Element: " + i);
            sum += i;
            average = sum / number_of_elements;
        }
        System.out.println("Average: " + average);

    }
}
