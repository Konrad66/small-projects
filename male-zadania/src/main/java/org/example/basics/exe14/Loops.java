package org.example.basics.exe14;

import java.util.Random;

public class Loops {

    public static void main(String[] args) {

        Random random = new Random();
        int numbers;
        int counter = 0;

        while (true){
            numbers = random.nextInt(11);
            counter++;
            System.out.println("You drew: " + numbers);

            if(numbers == 10) {
                System.out.println("Congratulations, you drew 10. End of program after " + counter + " attempts.");
                for (int i = 0; i < counter; i++) {
                    int secondDraw = random.nextInt(counter);
                    System.out.println("Again draw numbers: " + secondDraw);
                }
                break;
            }
        }
    }
}