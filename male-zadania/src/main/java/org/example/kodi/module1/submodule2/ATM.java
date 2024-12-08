package org.example.kodi.module1.submodule2;

public interface ATM {

    void deposit(int money);

    void withdrawal(int money);

    default void balance(int money){
        System.out.println("You have " + money + " money in your bank account");
    }

    default void connected() {
        System.out.println("You have successfully connected to your bank");
    }

    static void info() {
        System.out.println("ATM operation terminated");
    }
}