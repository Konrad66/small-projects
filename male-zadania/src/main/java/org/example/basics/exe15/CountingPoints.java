package org.example.basics.exe15;

import java.util.Scanner;

public class CountingPoints {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points;

        while (true){

            System.out.println("Enter a number: ");
            points = scanner.nextInt();
            points++;

            if(points == 0){
                break;
            }

        }

    }
}
