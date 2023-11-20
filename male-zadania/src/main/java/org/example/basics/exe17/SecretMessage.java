package org.example.basics.exe17;

import java.util.Scanner;

public class SecretMessage {

    public static void main(String[] args) {

        System.out.println("Write password to see secret message.");
        Scanner scanner = new Scanner(System.in);
        String password;

        while (true) {
            System.out.println("Password: ");
            password = scanner.next();
            if (password.equals("1234")) {
                System.out.println("Hejka!");
                break;
            }
        }

    }
}
