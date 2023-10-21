package org.example.basics.exe12;

public class WeatherControl {


    public static void main(String[] args) {

        boolean rain = false;
        boolean sunShines = false;


        if(rain == true && sunShines == true ){
            System.out.println("Rainbow!");
        } else if (rain == false && sunShines == true) {
            System.out.println("It's clear");
        } else if (rain == false && sunShines == false) {
            System.out.println("It's cloudy");
        } else if (rain == true && sunShines == false) {
            System.out.println("Heavy rain");
        }


    }
}
