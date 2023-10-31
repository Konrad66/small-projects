package org.example.basics.exe12;

public class WeatherControl {


    public static void main(String[] args) {

        boolean rain = false;
        boolean sunShines = false;


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
