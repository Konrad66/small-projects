package org.example.kodi.module1.submodule4;

abstract class BankOperations {

    abstract protected void enterCard();

    abstract protected void enterPinCode();

    abstract protected void enterMoney();

    private void isAcceptedByBank() {
        System.out.println("Bank accepted your request to withdrawal");
    }

    private void checkBalance() {
        System.out.println("Your balance is x money");
    }

    private void operationIsAccepted() {
        System.out.println("You can withdrawal your money");
    }

    abstract protected void withdrawalMoney();

    abstract protected void finishedOperation();

    public void runProcess() {
        enterCard();
        enterPinCode();
        enterMoney();
        isAcceptedByBank();
        checkBalance();
        operationIsAccepted();
        withdrawalMoney();
        finishedOperation();
    }
}