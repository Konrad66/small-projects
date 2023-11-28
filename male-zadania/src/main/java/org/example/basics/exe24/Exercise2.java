package org.example.basics.exe24;

import java.util.Random;

public class Exercise2 {

    public static void main(String[] args) {

        Random random = new Random();
        int numbers[] = new int[1000000];
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = random.nextInt(100) + 1;
        }

        int counter = 0;
        for (int number : numbers) {
            if (number == 25){
                counter++;
            }
        }
        System.out.println("Number 25 occurred " + counter + " times.");

        int occurrence[] = new int[100];
        for (int number : numbers){
            occurrence[number - 1]++;
        }

        for (int i = 0; i < occurrence.length; i++){
            if (occurrence[i] > 0){
                System.out.println("Number " + (i + 1) + " occurred " + ": " + occurrence[i] + " times.");
            }
        }
    }
}
