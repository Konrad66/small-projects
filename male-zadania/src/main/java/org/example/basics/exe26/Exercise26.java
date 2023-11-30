package org.example.basics.exe26;

import java.util.Scanner;

public class Exercise26 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String mark;
        int length;
        int width;

        System.out.println("Podaj znak");
        mark = scanner.next();

        System.out.println("Enter the length of the side of the rectangle: ");
        length = scanner.nextInt();

        System.out.println("Enter the width of the side of the rectangle");
        width = scanner.nextInt();

        for(int i = 0; i < length; i++){
            System.out.println(mark);
            for (int j = 0; j < width; j++){
                System.out.print(mark);
            }
        }

    }
}
