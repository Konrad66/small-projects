package org.example.kodi.module1.submodule2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much money do you want to deposit?");
        int money = scanner.nextInt();
        ATMImpl atm = new ATMImpl();

        atm.connected();
        atm.deposit(money);
        atm.balance(money);

        System.out.println("How much money do you want to withdraw?");
        atm.withdrawal(money);
        ATM.info();
    }
}