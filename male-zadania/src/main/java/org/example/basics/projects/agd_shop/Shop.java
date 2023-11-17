package org.example.basics.projects.agd_shop;

import java.util.Scanner;

public class Shop {

    public static void main(String[] args) {

         Scanner scanner = new Scanner(System.in);
         double productPrice;
         int installmentNumbers;

        System.out.println("Welcome to the appliances store.");
        System.out.println("Enter the price (from 100 PLN to 10 000 PLN):");
        productPrice = scanner.nextDouble();

        System.out.println("Specify how many installments you want to buy the product (from 6 to 48)");
        installmentNumbers = scanner.nextInt();

        if(!checkingInputData(productPrice, installmentNumbers)){
            System.out.println("Provide data are incorrect. Please provide right data.");
            return;
        }

        double interest;
        if (installmentNumbers >= 6 && installmentNumbers <=12 ){
            interest = 0.025;
        } else if (installmentNumbers >= 13 && installmentNumbers <= 24) {
            interest = 0.05;
        } else {
            interest = 0.1;
        }

        double monthlyInterest = interest / 12;
        double installment = calculateInstallment(productPrice, installmentNumbers, monthlyInterest);

        System.out.println("Your installment equals: " + installment + " PLN.");
    }

    private static boolean checkingInputData(double price, int installment){
        return (price >= 100 && price <= 10000) && (installment >= 6 && installment <= 48);
    }

    private static double calculateInstallment(double price, int installment, double monthlyInterest){
        return (price * monthlyInterest) / (1 - (Math.pow(1 + monthlyInterest, - installment)));
    }
}