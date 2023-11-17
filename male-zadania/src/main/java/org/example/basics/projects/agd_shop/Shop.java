package org.example.basics.projects.agd_shop;

import java.util.Scanner;

public class Shop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the appliances store.");
        System.out.println("Enter the price:");
        double price;
        do {
            price = scanner.nextDouble();
            if (price >= 100 || price <= 10000) {

                System.out.println("Incorrect amount");
                System.out.println("The installment system supports amounts from PLN 100 to PLN 10,000");
                System.out.println("Enter again correct price:");
            }
        } while (price <= 100 || price >= 10000);
        System.out.println("Your price is: " + price);

        System.out.println("Specify how many installments you want to buy the product");
        int installment = scanner.nextInt();
        if (installment > 6 || installment < 48) {
            System.out.println("Incorrect number of installments");
            System.out.println("The number of installments you can choose is 6 to 48");
        }

        if (installment >= 6 || installment <= 12) {
            double interest = (price / installment) + (price * 0.025);

            System.out.println("Your installment is: " + interest);
        }


    }
}
//zmienić linie 21 i 16 na wykorzystująca zmienną boolean