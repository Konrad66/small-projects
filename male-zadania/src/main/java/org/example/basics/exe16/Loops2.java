package org.example.basics.exe16;

public class Loops2 {
    //TODO do sprawdzenia

    public static void main(String[] args) {
        System.out.println("Numbers from 1 to 10");
        for(int i = 1; i < 11; i++){
            System.out.println(i);
        }
        System.out.println("Number from 99 to 66");
        for (int i = 99; i >= 66; i--){
            System.out.println(i);
        }
        System.out.println("Even numbers from 20 to 40");
        for(int i = 20; i <= 40; i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }

        String name = "Konrad";
        for(int i = 0; i < 5; i++){
            System.out.println(name);
        }
    }
}