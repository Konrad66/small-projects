package org.example.advanced.contact_list;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    String readText(){
        return scanner.nextLine();
    }

    int readNumber(){
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}
