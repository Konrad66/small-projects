package org.example.kodi.module1.submodule2;

public class ATMImpl implements ATM {

    @Override
    public void deposit(int money) {
        System.out.println("You deposited " + money + " money");
    }

    @Override
    public void withdrawal(int money) {
        System.out.println("You withdrew " + money + " money");
    }
}
