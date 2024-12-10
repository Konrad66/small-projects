package org.example.kodi.module1.submodule5;

public class Dsf {
}

interface Employee {

    double calculateSalary();

}

class ProductSalaryEmployee implements Employee {

    private double salary;
    private int numberOfCreatedProduct;

    public ProductSalaryEmployee(double salary, int numberOfCreatedProduct) {
        this.salary = salary;
        this.numberOfCreatedProduct = numberOfCreatedProduct;
    }

    @Override
    public double calculateSalary() {
        return salary * numberOfCreatedProduct;
    }
}

class SpecialSalaryEmployee implements Employee {

    private static final double SALARY = 2000;
    private boolean soldAdditionalProduct;

    public SpecialSalaryEmployee(boolean soldAdditionalProduct) {
        this.soldAdditionalProduct = soldAdditionalProduct;
    }

    @Override
    public double calculateSalary() {
        if (soldAdditionalProduct) {
            return SALARY + (SALARY * 0.20);
        }
        return SALARY;
    }
}


class FixedSalaryEmployee implements Employee {

    private double salary;

    public FixedSalaryEmployee(double salary) {
        this.salary = salary;
    }

    public double calculateSalary() {
        return this.salary;
    }

}

class HourlySalaryEmployee implements Employee {

    private double hours;
    private double hourlyPay;

    public HourlySalaryEmployee(double hours, double hourlyPay) {
        this.hours = hours;
        this.hourlyPay = hourlyPay;
    }

    public double calculateSalary() {
        return this.hourlyPay * this.hours;
    }

}

// Payout
abstract class SalaryPayout {

    private Employee employee;

    public SalaryPayout(Employee employee) {
        this.employee = employee;
    }

    protected abstract void payout();

    public void processPayout() {
        System.out.println("Creating payout for: " + this.employee.calculateSalary() + " PLN");
        this.payout();
        System.out.println("Payout has been completed!");
    }

}

class SalaryPayoutProcessor extends SalaryPayout {

    public SalaryPayoutProcessor(Employee employee) {
        super(employee);
    }

    protected void payout() {
        System.out.println("Sending money to employee");
    }

}