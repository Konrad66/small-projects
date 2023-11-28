package org.example.basics.exe22;

import java.util.Scanner;

public class Notes {

    //TODO do sprawdzenia


    public static void main(String[] args) {

        System.out.println("Enter number of notes: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        String[] notes = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.print("Enter notes " + (i) + ": ");
            notes[i] = scanner.nextLine();
        }

        System.out.println("All your notes: ");

        for (String note : notes) {
            System.out.println(note);
        }

        scanner.close();
    }
}