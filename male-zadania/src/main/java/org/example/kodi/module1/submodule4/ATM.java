package org.example.kodi.module1.submodule4;

public class ATM extends BankOperations{

    @Override
    protected void enterCard() {
        System.out.println("Enter you card");
    }

    @Override
    protected void enterPinCode() {
        System.out.println("Enter your pin code");
    }

    @Override
    protected void enterMoney() {
        System.out.println("How much do you want to withdrawal");
    }

    @Override
    protected void withdrawalMoney() {
        System.out.println("ATM prepares money");
    }

    @Override
    protected void finishedOperation() {
        System.out.println("Thank you for using our ATM. Have a nice day");
    }
}