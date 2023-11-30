package org.example.basics.exe27;

import java.util.Scanner;

public class Exercise27 {

    public static void main(String[] args) {

        //TODO nie działa mi odwrócona choinka

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the height of the Christmas tree: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j < (n - i) || j > (n + i)) {
                    System.out.println("*");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}