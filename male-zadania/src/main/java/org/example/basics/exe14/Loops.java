package org.example.basics.exe14;

import java.util.Random;

public class Loops {

    public static void main(String[] args) {

        Random random = new Random();
        int numbers;


        while (true){
            numbers = random.nextInt(11);

            System.out.println("You drew: " + numbers);

            if(numbers == 10){
                System.out.println("Congratulations, you drew 10");
                break;
            }
        }
    }
}