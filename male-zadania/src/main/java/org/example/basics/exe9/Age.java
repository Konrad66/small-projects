package org.example.basics.exe9;

import java.util.Scanner;

public class Age {


    public static void main(String[] args) {

        System.out.println("Hello, what's your name?");
        Scanner name = new Scanner(System.in);
        String inputName = name.next();

        System.out.println("What's your surname?");
        Scanner surname = new Scanner(System.in);
        String inputSurname = surname.next();

        System.out.println("Hello " + inputName + " " + inputSurname + "! How old are you?");
        Scanner age = new Scanner(System.in);
        String inputAge = age.next();

/*
        if (inputAge > 18){
            System.out.println("You are ");
        }


 */
    }
}