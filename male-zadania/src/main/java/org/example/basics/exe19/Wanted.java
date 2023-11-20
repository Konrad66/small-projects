package org.example.basics.exe19;

public class Wanted {

    public static void main(String[] args) {

        int[] numbers = new int[4];
        String[] text = new String[2];

        numbers[0] = 20;
        numbers[1] = 11;
        numbers[2] = 2023;
        numbers[3] = 5000;

        text[0] = "Kamil";
        text[1] = "Nowak";

        System.out.println(numbers[0] + " - " + numbers[1] + " - " + numbers[2] + " prisoner " + text[0] + " " + text[1] + " escaped.");
        System.out.println("Reward for bringing: " + numbers[3]);
    }
}