package org.example.advanced.lambda;

import java.util.Scanner;

public class CalculatorLambdaDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setOperation(new Operation() {

            @Override
            public double execute(double number1, double number2) {
                return number1 + number2;
            }
        });
        // ustaw operacje dodawania
        calculator.calculate();

        calculator.setOperation((double number1, double number2) -> {
            return number1 - number2;
        });

        calculator.setOperation((number1, number2) -> number1 - number2);


        //ustaw operację odejmowania
        calculator.calculate();
    }
}

class Calculator {

    private Operation operation;


    void setOperation(Operation operation) {
        this.operation = operation;
    }

    void calculate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę 1");
        double number1 = scanner.nextDouble();
        System.out.println("Podaj liczbę 2");
        double number2 = scanner.nextDouble();
        double result = operation.execute(number1, number2);
        System.out.println("Wynik operacji to: " + result);
    }
}

interface Operation {

    double execute(double number1, double number2);
}

