package org.example.basics.exe25;

public class Exercise25 {

    //TODO do sprawdzenia
    public static void main(String[] args) {
        int numbers[] = {-65, -60, -70, - 38, 43, 6, 24, 97, -23, 27};

        double average = 0;
        for (int number : numbers){
            average =+ number;
        }
        System.out.println("Average of numbers equals: " + average/numbers.length);

        //TODO zapytac dlaczego min a nie max value
        int maxNumber = Integer.MIN_VALUE;
        for(int number : numbers){
            if(number > maxNumber) {
                maxNumber = number;
            }
        }
        System.out.println("The greatest number is: " + maxNumber);

        //TODO zapytac dlacze man a nie min value
        int minValue = Integer.MAX_VALUE;
        for (int number : numbers){
            if (number < minValue){
                minValue = number;
            }
        }
        System.out.println("The lowest number is: " + minValue);
    }
}
