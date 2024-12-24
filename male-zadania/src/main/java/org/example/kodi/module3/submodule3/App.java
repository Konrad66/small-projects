package org.example.kodi.module3.submodule3;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random random = new Random();
        int sumaA = 1000;
        int sumaB = 0;
        int loopNumber = 0;
        while (sumaA > sumaB) {
            loopNumber++;
            int randomNumberA = random.nextInt(10);
            sumaA += randomNumberA;
            int randomNumberB = random.nextInt(50);
            sumaB += randomNumberB;
            System.out.println("Your sumA equals: " + sumaA + " your sumaB equals: " + sumaB + " and loop run number equals: " + loopNumber);
        }

        System.out.println("------------------");
        System.out.println("Additional task");
        int number = 0;
        while (number <= 100) {
            if (number % 3 == 0) {
                System.out.print(number + ", ");
            }
            number++;
        }
    }
}