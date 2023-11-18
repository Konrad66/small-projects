package org.example.basics.exe15;

import java.util.Scanner;

public class CountingPoints {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points;
        int sum = 0;


        while (true){

            System.out.println("Enter a number (enter 0 to break): ");
            points = scanner.nextInt();
            sum+=points;
            if(points == -1){
                System.out.println("Your sum of points equals: " + sum);
                break;
            }

        }

    }
}
