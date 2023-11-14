package org.example.basics.exe12;

import java.util.Scanner;

public class WeatherControl {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Did it rain today? Write true or false: ");
        boolean rain = scanner.nextBoolean();
        System.out.println("Did it sunshine today? Write true or false: ");
        boolean sunShines = scanner.nextBoolean();


        if (rain && sunShines) {
            System.out.println("Rainbow!");
        } else if (!rain && sunShines) {
            System.out.println("It's clear");
        } else if (!rain && !sunShines) {
            System.out.println("It's cloudy");
        } else {
            System.out.println("Heavy rain");
        }
    }
}